import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_5653 {
	static int width, height, time;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] map;
	static boolean[][] v;
	static PriorityQueue<Node> q;
	static PriorityQueue<Node> tmpQ;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			map = new int[700][700];
			q = new PriorityQueue<Node>();
			
			for(int i=300;i<300+height;++i) {
				st = new StringTokenizer(br.readLine());
				for(int j=300;j<300+width;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 0) continue;
					q.offer(new Node(j,i,map[i][j],map[i][j]));
				}
			}
			while(0<time--) {
				run();
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(q.size());
			System.out.println(sb.toString());
		}
	}
	static void run() {
		tmpQ = new PriorityQueue<Node>();
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			--node.time;
			if(node.status == 2) {
				for(int j=0;j<4;++j) {
					int nextX = node.x + dx[j];
					int nextY = node.y + dy[j];
					if(map[nextY][nextX] == 0) {
						map[nextY][nextX] = node.num;
						tmpQ.offer(new Node(nextX,nextY,node.num,node.num));
					}
				}
			}
			
			if(node.time==0) {
				switch(node.status) {
				case 1:
					node.time = node.num;
					node.status = 2;
					break;
				case 2:
					node.status = 0;
					break;
				}
			}
			if(node.status == 0) continue;
			
			tmpQ.offer(node);
		}
		q = tmpQ;
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int num;
		int time;
		int status;
		public Node(int x, int y,int num, int time) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.time = time;
			this.status = 1;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.num - this.num;
		}
		
	}

}
