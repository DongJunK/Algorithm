import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
	static int width, height;
	static int[][] map;
	static int[][] tmpMap;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[] top;
	static int[] bottom;
	static int time;
	
	static boolean checkRange(int x,int y) {
		return 0<=x&&x<width&&0<=y&&y<height;
	}

	static void airCleaner(boolean topOrBottom,int startY,int startX,int d){
		int nowY = startY;
	    int nowX = startX;
	    int move_dust = 0;
	    while(true){
	    	if(!checkRange(nowX+dx[d],nowY+dy[d])) {
	    		if(topOrBottom){  
			        d = (d+1)%4;
			    }else{
			        d = (d-1)<0?3:d-1;
			    }
	    	}
	        nowY += dy[d];
	        nowX += dx[d];
	        
	        if(startY == nowY && startX == nowX) break;
	        int now_dust = map[nowY][nowX];
	        map[nowY][nowX] = move_dust;
	        move_dust = now_dust;
	    }
	}


	static void airCleanerRun(){
	    airCleaner(true,top[1],top[0],2);
	    airCleaner(false,bottom[1],bottom[0],2);
	}
	
	static void spreadDustAround(int y,int x){
	    int amount_spread_dust = map[y][x]/5;
	    int spread_n = 0;

	    for(int i=0;i<4;++i){
	        int nextY = y+dy[i];
	        int nextX = x+dx[i];
	        if(checkRange(nextX,nextY) && map[nextY][nextX] != -1){
	        	tmpMap[nextY][nextX] += amount_spread_dust;
	            ++spread_n;
	        }
	    }

	    tmpMap[y][x] += map[y][x] - (amount_spread_dust * spread_n);
	}

	static void copyMap(int[][] one,int[][] two) {
		for(int i=0;i<one.length;++i) {
			System.arraycopy(one[i], 0, two[i], 0, two[i].length);
		}
	}
	
	static void spreadDust() {
		for(int i=0;i<height;++i){
	        for(int j=0;j<width;++j){
	            if(map[i][j]==-1){
	            	tmpMap[i][j] = -1;
	                continue;
	            }
	            tmpMap[i][j] = 0;
	        }
	    }

	    for(int i=0;i<height;++i){
	        for(int j=0;j<width;++j){
	            if(0 < map[i][j]) spreadDustAround(i,j);
	        }
	    }
	    copyMap(tmpMap,map);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());
		tmpMap = new int[height][width];
		map = new int[height][width];
		top = new int[2];
		bottom = new int[2];
		
		boolean flag = false;
		for(int i=0;i<height;++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<width;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(!flag) {
						top[1] = i;
						top[0] = j;
						flag = true;
					}else {
						bottom[1] = i;
						bottom[0] = j;
					}
				}
			}
		}
		while(0<time--) {
			spreadDust();
			airCleanerRun();
		}
		
		int answer = 0;
		for(int i=0;i<height;++i) {
			for(int j=0;j<width;++j) {
				answer += map[i][j];
			}
		}
		System.out.println(answer+2);
	}
}