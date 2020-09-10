import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int height;
	static int width;
	static int x;
	static int y;
	static int runTime;
	static int[][] map;
	static boolean[][] v;
	static Queue<int[]> q;
	
	static boolean checkRange(int x, int y) {
		return 0<=x&&x<width&&0<=y&&y<height;
	}
	static void checkConnection(int[] moveArr,int[] now) {
		
		for(int i=0;i < moveArr.length;++i) {
			int nextX = now[0] + dx[moveArr[i]];
			int nextY = now[1] + dy[moveArr[i]];
			int nextTime = now[2] + 1;
			if(!checkRange(nextX,nextY) || v[nextY][nextX] || map[nextY][nextX] == 0 || runTime <= nextTime) 
				continue;
			
			int tunnel = map[nextY][nextX];
			
			switch(moveArr[i]) {
			case 0:
				if(tunnel == 2 || tunnel == 6 || tunnel == 7) 
					continue;
				break;
			case 1:
				if(tunnel == 2 || tunnel == 4 || tunnel == 5)
					continue;
				break;
			case 2:
				if(tunnel == 3 || tunnel == 5 || tunnel == 6)
					continue;
				break;
			case 3:
				if(tunnel == 3 || tunnel == 4 || tunnel == 7)
					continue;
				break;
			}
			v[nextY][nextX] = true;
			q.offer(new int[]{nextX,nextY,nextTime});
		}
	}
	static void run() {
		q = new LinkedList<int[]>();
		q.offer(new int[] {x,y,0});
		v[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			switch(map[now[1]][now[0]]) {
			case 1:
				checkConnection(new int[] {0,1,2,3},now);
				break;
			case 2:
				checkConnection(new int[] {2,3},now);
				break;
			case 3:
				checkConnection(new int[] {0,1},now);
				break;
			case 4:
				checkConnection(new int[] {1,3},now);
				break;
			case 5:
				checkConnection(new int[] {1,2},now);
				break;
			case 6:
				checkConnection(new int[] {0,2},now);
				break;
			case 7:
				checkConnection(new int[] {0,3},now);
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	      
	    for(int test_case = 1; test_case<=T; ++test_case) {
	    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	        height = Integer.parseInt(st.nextToken());
	        width = Integer.parseInt(st.nextToken());
	        y = Integer.parseInt(st.nextToken());
	        x = Integer.parseInt(st.nextToken());
	        runTime = Integer.parseInt(st.nextToken());
	        
	        map = new int[height][width];
	        v = new boolean[height][width];
	         
	        for(int i = 0; i<height; ++i) {
	           st = new StringTokenizer(br.readLine(), " ");
	           for(int j = 0; j<width; ++j) {
	              map[i][j] = Integer.parseInt(st.nextToken());
	              v[i][j] = false;
	           }
	        }
	        run();
	        int answer=0;
	        for(int i=0;i<height;++i) {
	        	for(int j=0;j<width;++j) {
	        		if(v[i][j]) ++answer;
	        	}
	        }
	        StringBuilder sb = new StringBuilder();
	        sb.append("#").append(test_case).append(" ").append(answer);
	        
	        System.out.println(sb.toString());
	    }
	}
}
