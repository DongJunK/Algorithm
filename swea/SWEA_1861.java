import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861 {
	static int[][] map;
	static int N;
	static int maxAns;
	static int startNumAns;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static boolean check_range(int x,int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}
	
	static void solve(int x, int y, int startNum, int cnt) {
		int flag = 0;
		for(int i=0;i<4;++i) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			if(check_range(nX,nY) && map[nY][nX] == map[y][x] + 1) {
				solve(nX,nY,startNum,cnt+1);
				++flag;
			}
		}
		if(flag == 0) {
			if(maxAns == cnt && startNum<startNumAns) {
				startNumAns = startNum;
			}else if(maxAns<cnt) {
				maxAns = cnt;
				startNumAns = startNum;
			}
			
			return;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;++t) {
			N =Integer.parseInt(br.readLine());
			maxAns = 0;
			startNumAns = 123456789;
			map = new int[N][N];
			for(int i=0;i<N;++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					solve(j,i,map[i][j],1);					
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(startNumAns).append(" ").append(maxAns);
			System.out.println(sb.toString());
		}
	}
}
