import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class SWEA_2117 {
	static int n;
	static int money;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int answer;
	
	static boolean checkRange(int x,int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	
	static void bfs(int x,int y,int k) {
		int oper = k*k + (k-1)*(k-1);
		Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {x,y,1});
		int homeMoney = 0;
		int cnt = 0;
		visit = new boolean[n][n];
		
		visit[y][x] = true;
		homeMoney += map[y][x];
		if(map[y][x] != 0) ++cnt;
		
		while(!q.isEmpty()) {
			int nowX = q.peek()[0];
			int nowY = q.peek()[1];
			int nowDist = q.peek()[2];
			q.poll();
			
			for(int i=0;i<4;++i) {
				int nY = nowY + dy[i];
				int nX = nowX + dx[i];
				if(!checkRange(nX, nY) || visit[nY][nX] || k<=nowDist) continue;
				
				visit[nY][nX] = true;
				homeMoney += map[nY][nX];
				if(map[nY][nX]!=0) ++cnt;
				q.offer(new int[] {nX,nY,nowDist+1});
			}
		}
		if(oper<=homeMoney) {
			answer = Math.max(answer, cnt);
			return;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			money = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			
			
			for(int i=0;i<n;++i) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1)map[i][j] = money;
				}
			}
			answer = 0;
			for(int i=1;i<=n+1;++i) {
				for(int j=0;j<n;++j) {
					for(int k=0;k<n;++k) {
						bfs(k,j,i);
					}
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}