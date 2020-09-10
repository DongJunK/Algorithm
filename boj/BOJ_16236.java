import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static int answer;
	static int startX,startY;
	static boolean[][] visit;
	static int[][] map;
	static List<int[]> eatFish;
	static int n;
	static int[] dx = {0,-1,1,0};
	static int[] dy = {-1,0,0,1};
	static int eatN;
	
	static boolean checkRange(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	
	static boolean bfs() {
		List<int[]> eat = new ArrayList<int[]>();
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {startX,startY,0});
		visit[startY][startX] = true;
		int minDist = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int dist = q.poll()[2];
			for(int i=0;i<4;++i) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				int nextD = dist+1;
				if(!checkRange(nextX,nextY) || visit[nextY][nextX] || map[startY][startX]<map[nextY][nextX]||minDist<nextD) continue;
				
				if(map[nextY][nextX]!=0 && map[nextY][nextX] < map[startY][startX]) {
					eat.add(new int[] {nextX,nextY});
					minDist = nextD;
				}else {
					q.offer(new int[] {nextX,nextY,nextD});
				}
				visit[nextY][nextX] = true;
			}
		}
		int eatX=Integer.MAX_VALUE;
		int eatY=Integer.MAX_VALUE;
		for(int i=0;i<eat.size();++i) {
			int nowX = eat.get(i)[0];
			int nowY = eat.get(i)[1];
			if(nowY<eatY) {
				eatX = nowX;
				eatY = nowY;
			}else if(nowY==eatY){
				if(nowX<eatX) {
					eatX = nowX;
					eatY = nowY;
				}
			}
		}
		if(eat.size()==0) {
			return false;
		}else {
			++eatN;
			if(eatN == map[startY][startX]) {
				eatN = 0;
				map[startY][startX] += 1;
			}
			map[eatY][eatX] = map[startY][startX];
			map[startY][startX] = 0;
			startY = eatY;
			startX = eatX;
			answer += minDist;
			return true;
		}
		
	}
	static void initVisit() {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				visit[i][j] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					startY = i;
					startX = j;
					map[i][j] = 2;
				}
			}
		}
		answer = 0;
		eatN = 0;
		while(bfs()){
			initVisit();
		}
		System.out.println(answer);
	}

}
