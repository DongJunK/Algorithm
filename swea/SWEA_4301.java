import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4301 {
	static boolean[][] map;
	static int width;
	static int height;
	static int[] dx = {2,-2,0,0};
	static int[] dy = {0,0,2,-2};
	static boolean checkRange(int x, int y) {
		return 0<=x&&x<width&&0<=y&&y<height;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			map = new boolean[height][width];
			for(int i=0;i<height;++i) {
				Arrays.fill(map[i], false);
			}
			int answer = 0;
			for(int i=0;i<height;++i) {
				for(int j=0;j<width;++j) {
					boolean flag = false;
					for(int k=0;k<4;++k) {
						int checkX = j + dx[k];
						int checkY = i + dy[k];
						if(checkRange(checkX,checkY) 
								&& map[checkY][checkX]) {
							flag = true;
							break;
						}
					}
					if(flag) continue;
					else {
						map[i][j] = true;
						++answer;
					}
				}
			}
			
			System.out.println("#"+t+" "+answer);
			
		}
	}

}
