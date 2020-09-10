import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_2805 {
	static int N;
	static int[][] map;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	static int result;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;++t) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0;i<N;++i) {
				String input = br.readLine();
				for(int j=0;j<N;++j) {
					map[i][j] = input.charAt(j)-'0';
				}
			}
			result = 0;
			Queue<Move> q = new LinkedList<Move>();
			q.offer(new Move(N/2,N/2,N/2));
			
			while(true) {
				if(q.isEmpty()) {
					break;
				}
				Move m = q.poll();
				
				if(m.cnt == -1 ||map[m.y][m.x]==-1) continue;
				
				result += map[m.y][m.x];
				map[m.y][m.x] = -1;
				
				for(int i = 0; i < 4; ++i) {
					int nextX = m.x + dx[i];
					int nextY = m.y + dy[i];
					q.offer(new Move(nextX,nextY,m.cnt-1));
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(result).append("\n");
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		}
	}	
	static class Move{
		int x;
		int y;
		int cnt;
		public Move(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
}
