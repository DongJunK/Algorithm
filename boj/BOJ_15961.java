import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15961 {
	static int sushi[];
	static int table[];
	static int n,sushiN,eat,coupon;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		sushiN = Integer.parseInt(st.nextToken());
		eat = Integer.parseInt(st.nextToken());
		coupon = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<Integer>();
		int answer = 0;
		table = new int[n+eat];
		sushi = new int[sushiN+1];
		for(int i=0;i<n;++i) {
			table[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		set.add(coupon);
		for(int i=n;i<n+eat;++i) {
			table[i] = table[cnt++];
		}
		
		for(int i=0;i<eat;++i) {
			++sushi[table[i]];
			set.add(table[i]);
		}
		
		for(int i=eat;i<n+eat;++i) {
			--sushi[table[i-eat]];
			if(table[i-eat]!=coupon&&sushi[table[i-eat]]==0) {
				set.remove(table[i-eat]);
			}
			++sushi[table[i]];
			set.add(table[i]);
			answer = Math.max(answer, set.size());
		}
		System.out.println(answer);
	}
}
