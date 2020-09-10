import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
	static int[][] map;
	static int sX;
	static int sY;
	static int eX;
	static int eY;
	static int answer;
	static int n;
	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {-1,-2,-2,-1,1,2,2,1};
	
	static boolean checkRange(int x,int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	
	static void bfs() {
		map[sY][sX] = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {sX,sY});
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			if(x==eX&&y==eY) break;
			for(int i=0;i<8;++i) {
				int nX = x + dx[i];
				int nY = y + dy[i];
				if(!checkRange(nX,nY)) continue;
				
				if(map[y][x]+1<map[nY][nX]) {
					map[nY][nX] = map[y][x] + 1;
					q.offer(new int[] {nX,nY});
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for(int i=0;i<n;++i){
				Arrays.fill(map[i], Integer.MAX_VALUE);
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			sX = Integer.parseInt(st.nextToken());
			sY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			eX = Integer.parseInt(st.nextToken());
			eY = Integer.parseInt(st.nextToken());
			bfs();
			
			System.out.println(map[eY][eX]);
		}
	}
}
