import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	static int[][] map;
	static int width;
	static int height;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static boolean checkRange(int x, int y) {
		return 0<=x&&x<width&&0<=y&&y<height;
	}
	
	static int bfs(){
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i=0;i<height;++i) {
			for(int j=0;j<width;++j) {
				if(map[i][j] == 1) {
					q.offer(new int[] {j,i});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0;i<4;++i) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				if(checkRange(nextX,nextY) &&
						map[nextY][nextX] == 0) {
					map[nextY][nextX] = map[now[1]][now[0]] + 1;
					q.offer(new int[] {nextX,nextY});
				}
			}
			
		}
		int answer = 0;
		outer:for(int i=0;i<height;++i) {
			for(int j=0;j<width;++j) {
				if(map[i][j] == 0) {
					answer = 0;
					break outer;
				}
				answer = Math.max(answer,map[i][j]);
			}
		}
		return answer-1;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		for(int i=0;i<height;++i) {
			map[i] = new int[width];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<width;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
		
	}

}
