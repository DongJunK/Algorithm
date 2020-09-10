import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
	static int[] p;
	
	static void makeSet(int N) {
		for(int i=1;i<=N;++i) {
			p[i] = i;
		}
	}
	
	static void union(int one, int two) {
		int oneRoot = find(one);
		int twoRoot = find(two);
		
		if(oneRoot != twoRoot) {
			p[twoRoot] = oneRoot;
		}
	}
	
	static int find(int node) {
		if(p[node] == node) {
			return node;
		}
		p[node] = find(p[node]);
		return p[node];
	}
	static int checkSame(int one, int two) {
		int oneRoot = find(one);
		int twoRoot = find(two);
		if(oneRoot == twoRoot) 
			return 1;
		else
			return 0;
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1];
			makeSet(N);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			for(int i=0;i<M;++i) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				if(cmd == 1) {
					sb.append(checkSame(one,two));
				}
				else {
					union(one,two);
				}
			}
			
			System.out.println(sb.toString());
		}
	}
}