import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
	static int[][] map;
	static int height;
	static int width;
	static int[] dx = {1,-1,0,0,-1,1,-1,1};
	static int[] dy = {0,0,1,-1,-1,-1,1,1};
	static int answer;
	
	static boolean checkRange(int x, int y) {
		return 0<=x&&x<width&&0<=y&&y<height;
	}
	
	static void dfs(int x, int y) {
		map[y][x] = answer;
		for(int i=0;i<8;++i) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			if(checkRange(nX,nY) && map[nY][nX] == 1) {
				dfs(nX,nY);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st= new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			if(width == 0 && height == 0) {
				break;
			}
			
			answer = 2;
			map = new int[height][width];
			for(int i=0;i<height;++i) {
				map[i] = new int[width];
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<width;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<height;++i) {
				for(int j=0;j<width;++j) {
					if(map[i][j] == 1) {
						dfs(j,i);
						++answer;
					}
				}
			}
			
			System.out.println(answer - 2);
			
		}
	}
}
