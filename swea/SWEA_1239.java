import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1239 {
	static int N;
	static boolean[][] map;
	static int[] v;
	
	static int bfs(int start) {
		int ans = 0; 
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[]{start,0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(0<v[now[0]]) continue;
			
			v[now[0]] = now[1] + 1;
			for(int i=1;i<=N;++i) {
				if(map[now[0]][i]) {
					q.offer(new int[] {i, now[1]+1});
				}
			}
		}
		int max = 0;
		for(int i=1;i<=N;++i) {
			max = Math.max(max, v[i]);
		}
		
		for(int i=1;i<=N;++i) {
			if(max == v[i]) {
				ans = Math.max(ans, i);
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			map = new boolean[N+1][N+1];
			v = new int[N+1];
			
			for(int i=1;i<=N;++i) {
				Arrays.fill(map[i],false);
			}
			Arrays.fill(v, 0);
			
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<N/2;++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = true;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(bfs(start));
			System.out.println(sb.toString());
		}
	}
}
