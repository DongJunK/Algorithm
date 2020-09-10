import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014 {
	static int n;
	static int length;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0,-1,1,0,0};
	static int[] dy = {0,0,1,-1,0,0,-1,1};
	
	static boolean checkRange(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	
	static boolean checkPoss(int x,int y,int d) {
		int now = map[y][x];
		visit[y][x] = true;
		for(int i=0;i<length-1;++i) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(!checkRange(nx,ny)||now != map[ny][nx]||visit[ny][nx]) {
				return false;
			}
			visit[ny][nx] = true;
			y = ny;
			x = nx;
		}
		return true;
	}
	
	
	static int checkRoad(int x,int y, int d) {
		int now = map[y][x];
		visit = new boolean[n][n];
		
		for(int i=1;i<n;++i) {
			x+=dx[d];
			y+=dy[d];
			int com = map[y][x];
			if(1<Math.abs(com-now)) return 0;
			
			if(now<com&&!checkPoss(x+dx[d+4],y+dy[d+4],d+4))
				return 0;
			
			if(com<now&&!checkPoss(x,y,d))
				return 0;
			
			now = com;
		}
		
		return 1;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			length = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			
			for(int i=0;i<n;++i) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;
			for(int i=0;i<n;++i) {
				answer += checkRoad(0,i,0);
				answer += checkRoad(i,0,2);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
