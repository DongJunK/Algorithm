import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class SWEA_7465 {
	static int[] p;
	static int cnt;
	static int find(int node) {
		++cnt;
		if(p[node] == node) {
			return node;
		}
		return p[node] = find(p[node]);
	}
	
	static void union(int one, int two){
		cnt = 0;
		int oneRoot = find(one);
		int oneCnt = cnt;
		cnt = 0;
		int twoRoot = find(two);
		int twoCnt = cnt;
		if(oneRoot == twoRoot) 
			return;
		if(twoCnt<oneCnt) {
			p[twoRoot] = oneRoot;
		}else {
			p[oneRoot] = twoRoot;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;++t){
            int n,m;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			p = new int[n+1];
		
			for(int i=1;i<=n;++i) {
				p[i] = i;
			}
		
			for(int i=0;i<m;++i) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
		
			HashSet<Integer> set = new HashSet<Integer>();
			for(int i=1;i<=n;++i) {
				set.add(find(i));
			}
			System.out.println("#"+t+" "+set.size());
        }	
	}
}
