import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2447 {
	static char[][] map;
	static int n;
	static int r;
	static int c;
	static int cnt;
	static void rec(int n, int x,int y) {
		if(n == 1) {
			map[y][x] = '*';
			return;
		}
		for(int i=0;i<3;++i) {
			for(int j=0;j<3;++j) {
				if(i==1&&j==1) {
					continue;
				}
				rec(n/3,x+(j*(n/3)),y+(i*(n/3)));
			}
		}
		return;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new char[3000][3000];
		n = Integer.parseInt(st.nextToken());
		for(int i=0;i<3000;++i) {
			for(int j=0;j<3000;++j) {
				map[i][j] = ' ';
			}
		}
		rec(n,0,0);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;++i) {
			for(int j=0;j<n;++j) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
