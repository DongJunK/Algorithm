import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
	static int[][] arr;
	static long answer = Integer.MAX_VALUE;
	static int N;
	static void dfs(long s,long b, int idx) {
		if(idx == N) {
			if(s == 0 && b == 0) return;
			
			answer = Math.min(answer, Math.abs(s-b));
			return;
		}
		if(s==0) {
			dfs(arr[idx][0],b+arr[idx][1],idx+1);
		}else {
			dfs(arr[idx][0]*s,b+arr[idx][1],idx+1);
		}
		dfs(s,b,idx+1);
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		
		System.out.println(answer);
		
	}

}
