import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL_1733 {
	static int[] dx = {1,1,1,0,-1,-1,-1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	static int[][] map = new int[21][21];
	static int ansX;
	static int ansY;
	static int winner;
	static boolean flag = false;
	static boolean checkRange(int x,int y) {
		return 0<x&&x<20&&0<y&&y<20;
	}
	static void find(int y, int x,int now, int d,int cnt) {
		if(!checkRange(x,y)) return;
		if(map[y][x] != now ) return;

		int ny = y + dy[d];
		int nx = x + dx[d];
		if(cnt==5) {
			if(!checkRange(x,y)||map[ny][nx] == now) return;
			winner = map[y][x];
			flag = true;
			return;
		}
		if(map[ny][nx] == now) {
			find(ny,nx,now,d,cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=1;i<20;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<20;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		winner = 0;
		outer:for(int i=1;i<20;++i) {
			for(int j=1;j<20;++j) {
				if(map[i][j] != 0) {
					for(int d=0;d<4;++d) {
						if(map[i+dy[d+4]][j+dx[d+4]] == map[i][j])continue;
						ansX = j;
						ansY = i;
						find(i,j,map[i][j],d,1);
						if(flag) break outer;
					}
				}
			}
		}
		
		System.out.println(winner);
		if(winner == 0) return;
		System.out.println(ansY+" "+ansX);
		
	}

}
