import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
	static int[][] map;
	static boolean[][] v;
	static int n;
	static int maxBuilding;
	static int cnt;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static void up() {
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				map[i][j] -= 1;
				if(map[i][j] < 0) map[i][j] = 0;
			}
		}
	}
	static boolean checkRange(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	
	static void dfs(int x, int y) {
		if(v[y][x]) return;
		v[y][x] = true;
		for(int i=0;i<4;++i) {
			int nX = x+dx[i];
			int nY = y+dy[i];
			if(checkRange(nX,nY)&&map[nY][nX]!=0&&!v[nY][nX]) {
				dfs(nX,nY);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new boolean[n][n];
		for(int i=0;i<n;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxBuilding = Math.max(maxBuilding, map[i][j]);
			}
		}
		int answer = 0;
		for(int t=0;t<maxBuilding;++t) {
			cnt = 0;
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					v[i][j] = false;
				}
			}
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] != 0 && !v[i][j]) {
						dfs(j,i);
						++cnt;
					}
				}
			}
			answer = Math.max(answer, cnt);
			up();
		}
		System.out.println(answer);
	}
}
