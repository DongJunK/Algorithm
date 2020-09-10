import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247 {
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	static int N;
	static boolean[] visit;
	static int[][] client;
	static int answer;
	
	static void rec(int x,int y, int cnt,int sum) {
		if(cnt == N) {
			answer = Math.min(answer, sum + Math.abs(x-endX)+Math.abs(y-endY));
			return;
		}
		for(int i=0;i<N;++i) {
			if(!visit[i]) {
				visit[i] = true;
				rec(client[i][0],client[i][1],cnt+1,sum+Math.abs(client[i][0]-x)+Math.abs(client[i][1]-y));
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			client = new int[N][2];
			visit = new boolean[N];
			answer = Integer.MAX_VALUE;
			for(int i=0;i<N;++i) {
				client[i][0] = Integer.parseInt(st.nextToken());
				client[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;++i) {
				visit[i] = true;
				rec(client[i][0],client[i][1],1,Math.abs(client[i][0]-startX)+Math.abs(client[i][1]-startY));
				visit[i] = false;
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}
}
