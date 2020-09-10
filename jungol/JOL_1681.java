import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JOL_1681 {
	static int n;
	static int[][] map;
	static boolean[] v;
	static int answer;
	
	static void dfs(int now,int start, int d,int cnt) {
		if(answer<d) return;
		if(cnt==n-1) {
			if(map[now][start] == 0) return;
			answer = Math.min(answer, d+map[now][start]);
			return;
		}
		for(int j=0;j<n;++j) {
			if(now!=j&&!v[j]&&map[now][j] != 0) {
				v[j] = true;
				dfs(j,start,d+map[now][j],cnt+1);
				v[j] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new boolean[n];
		for(int i=0;i<n;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		for(int i=0;i<n;++i) {
			v[i] = true;
			dfs(i,i,0,0);
			v[i] = false;
		}
		
		System.out.println(answer);
	}

}
