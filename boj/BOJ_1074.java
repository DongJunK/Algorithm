import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	static int n;
	static int r;
	static int c;
	static int cnt;
	static void rec(int n, int x,int y) {
		if(n == 2) {
			if(y == r && x == c) {
				System.out.println(cnt);
				return;
			}
			++cnt;
			if(y + 1 == r && x == c) {
				System.out.println(cnt);
				return;
			}
			++cnt;
			if(y == r && x + 1 == c) {
				System.out.println(cnt);
				return;
			}
			++cnt; 
			if(y + 1 == r && x + 1 == c) {
				System.out.println(cnt);
				return;
			}
			++cnt;
			return;
		}
		
		rec(n/2,x,y);
		rec(n/2,x+n/2,y);
		rec(n/2,x,y+n/2);
		rec(n/2,x+n/2,y+n/2);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		rec(1<<n,0,0);
	}
}
