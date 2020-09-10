import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135 {
	static int height, width, distance;
	static int[][] map;
	static int[][] runMap;
	static int[] dx = {-1,0,1};
	static int[] dy = {0,-1,0};
	
	static boolean checkRange(int x,int y) {
		return 0<=x&&x<width&&0<=y&&y<height;
	}
	
	static void downEnermy() {
		for(int i=height-1;0<=i;--i) {
			for(int j=0;j<width;++j) {
				if(i==height-1) {
					runMap[i][j] = 0;
				}else if(runMap[i][j] == 1) {
					runMap[i][j] = 0;
					runMap[i+1][j] = 1;
				}
			}
		}
	}
	
	static void initRunMap() {
		for(int i=0;i<height;++i) {
			for(int j=0;j<width;++j) {
				runMap[i][j] = map[i][j];
			}
		}
	}
	
	static void detectEnermy(int x, PriorityQueue<AimEnermy> q) {
		Queue<int[]> now = new LinkedList<int[]>();
		now.offer(new int[] {x,height-1,1});
		while(!now.isEmpty()) {
			int[] nowInfo = now.poll();
			if(!q.isEmpty()) {
				AimEnermy tmp = q.peek();
				if(tmp.distance<nowInfo[2])break;
			}
			if(runMap[nowInfo[1]][nowInfo[0]]==1) {
				q.offer(new AimEnermy(nowInfo[0],nowInfo[1],nowInfo[2]));
			}
			
			for(int i=0;i<3;++i) {
				int nextX = nowInfo[0] + dx[i];
				int nextY = nowInfo[1] + dy[i];
				int nextMove = nowInfo[2] + 1;
				if(!checkRange(nextX,nextY)||distance<nextMove) continue;
				now.offer(new int[] {nextX,nextY,nextMove});
			}
		}
		
	}
	
	static int run(int[] position) {
		PriorityQueue<AimEnermy> pq[] = new PriorityQueue[3];
		int result = 0;
		
		for(int i=0;i<height;++i) {
			ArrayList<Integer> ax = new ArrayList<Integer>();
			ArrayList<Integer> ay = new ArrayList<Integer>();
			for(int j=0;j<3;++j) {
				for(int k=0;k<3;++k) {
					pq[k] = new PriorityQueue<AimEnermy>();
				}
				detectEnermy(position[j],pq[j]);
				if(!pq[j].isEmpty()) {
					AimEnermy ae = pq[j].poll();
					if(runMap[ae.y][ae.x] == 1) {
						ax.add(ae.x);
						ay.add(ae.y);
					}
				}
			}
			for(int k=0; k<ax.size();++k) {
				if(runMap[ay.get(k)][ax.get(k)] == 1) {
					runMap[ay.get(k)][ax.get(k)] = 0;
					++result;
				}
					
			}
			downEnermy();
		}
		
		return result;
	}
	
	static class AimEnermy implements Comparable<AimEnermy>{
		int x,y,distance;
		AimEnermy(int x, int y,int distance){
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		@Override
		public int compareTo(AimEnermy o) {
			// TODO Auto-generated method stub
			if((o.distance==this.distance && o.x<this.x)||o.distance<this.distance) {
					return 1;
			}else {
				return -1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		distance = Integer.parseInt(st.nextToken());
		
		map = new int[height][width];
		runMap = new int[height][width];
		
		for(int i = 0;i<height;++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<width;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i=0;i<width-2;++i) {
			for(int j=i+1;j<width-1;++j) {
				for(int k=j+1;k<width;++k) {
					initRunMap();
					answer = Math.max(answer,run(new int[] {i,j,k}));
				}
			}
		}
		System.out.println(answer);
	}
	
}
