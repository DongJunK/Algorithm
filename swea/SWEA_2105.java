import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2105 {
	
	static int N;
	static boolean[][] visit;
	static int[][] map;
	static boolean[] desert;
	static boolean[] direction;
	static int[] dx = {1,-1,-1,1};
	static int[] dy = {1,1,-1,-1};
	static int startX, startY;
	static int answer;
	static boolean checkRange(int x,int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;++t) {
			N = Integer.parseInt(br.readLine());
			desert = new boolean[101];
			direction = new boolean[4];
			
			map = new int[N][N];
			visit = new boolean[N][N];
			for(int i=0;i<N;++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visit[i][j] = false;
				}
			}
			answer = 0;
			Arrays.fill(desert, false);
			Arrays.fill(direction, false);
			
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					for(int d=0;d<2;++d) {
						direction[d] = true;
						desert[map[i][j]] = true;
						visit[i][j] = true;
						startX = j;
						startY = i;
						dfs(j,i,d,1);
						direction[d] = false;
						visit[i][j] = false;
						desert[map[i][j]] = false;
					}
				}
			}
			if(answer == 0) answer = -1;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
	static void dfs(int x,int y,int d,int cnt) {
		
		for(int i=0;i<4;++i) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX==startX&&nextY==startY&&cnt!=2&&(i==d||!direction[i])) {
				answer = Math.max(answer, cnt);
				return;
			}
			if(!checkRange(nextX,nextY)||desert[map[nextY][nextX]]||visit[nextY][nextX])continue;
			visit[nextY][nextX] = true;
			desert[map[nextY][nextX]] = true;
			if(d == i) {
				dfs(nextX,nextY,i,cnt+1);
			}else if(!direction[i]&&!visit[nextY][nextX]){
				direction[i] = true;
				dfs(nextX,nextY,i,cnt+1);
				direction[i] = false;
			}
			
			visit[nextY][nextX] = false;
			desert[map[nextY][nextX]] = false;
			
		}
	}

}
