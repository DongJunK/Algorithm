import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1939 {
	static int n;
	static int gongsa;
	static int answer;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean flag;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=TC;++t) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			gongsa = Integer.parseInt(st.nextToken());
			int top = 0;
			map = new int[n][n];
			visit = new boolean[n][n];
			for(int i=0;i<n;++i) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					top = Math.max(top, map[i][j]);
				}
			}
			q = new LinkedList<int[]>();
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] == top) {
						q.offer(new int[] {j,i});
					}
				}
			}
			while(!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				q.poll();
				flag = false;
				visit[y][x] = true;
				dfs(x,y,1);
				visit[y][x] = false;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int x,int y,int cnt) {
		
		answer = Math.max(answer, cnt);
		for(int i=0;i<4;++i) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!checkRange(nx,ny)||visit[ny][nx]) continue;
			visit[ny][nx] = true;
			if(map[ny][nx]<map[y][x]){
				
				dfs(nx,ny,cnt+1);
				
			}else if(!flag && map[ny][nx]-gongsa<=map[y][x]-1) {
				flag = true;
				int tmp = map[ny][nx];
				map[ny][nx] = map[y][x] - 1;
				dfs(nx,ny,cnt+1);
				map[ny][nx] = tmp;
				flag = false;
			}
			visit[ny][nx] = false;
		}
	}
	
	static boolean checkRange(int x,int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	

}
