import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	static int height;
	static int width;
	static int maxWall;
	static int[][] map;
	static int[][] run;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean checkRange(int x,int y) {
		return 0<=x&&x<width&&0<=y&&y<height;
	}
	static void bfs(int x,int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y,0,1});
		while(!q.isEmpty()) {
			int nowX = q.peek()[0];
			int nowY = q.peek()[1];
			int wall = q.peek()[2];
			int walk = q.peek()[3];
			q.poll();
			if(nowX==width-1&&nowY==height-1) {
				System.out.println(walk);
				return;
			}
			
			for(int i=0;i<4;++i) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				if(!checkRange(nx,ny) || run[ny][nx] <= wall) continue;
				
				if(map[ny][nx] == 1 && wall == 0) {
					run[ny][nx] = wall+1;
					q.offer(new int[] {nx,ny,wall+1,walk+1});
				}
				else if(map[ny][nx] == 0) {
					run[ny][nx] = wall;
					q.offer(new int[] {nx,ny,wall,walk+1});
				}
					
			}
		}
		System.out.println(-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		maxWall = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		run = new int[height][width];
		for(int i=0;i<height;++i) {
			String input = br.readLine();
			for(int j=0;j<width;++j) {
				map[i][j] = input.charAt(j) - '0';
				run[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs(0,0);
	}
}
