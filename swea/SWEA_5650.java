import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_5650 {
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N;
	static int answer;
	static HashMap<String,String> wormhole = new HashMap<String,String>();
	
	static boolean checkRange(int x,int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}

	static int go(int y, int x, int d) {
		int startY = y;
		int startX = x;
		int answer = 0;
		while(true) {
			int nX = x + dx[d];
			int nY = y + dy[d];
			if((nX == startX && nY == startY) || (checkRange(nX,nY)&&map[nY][nX] == -1)) {
				break;
			}
			
			if(!checkRange(nX,nY)) {
				d = d==0 ? 1 : d==1 ? 0 : d==2 ? 3 : 2;
				++answer;
				x = nX;
				y = nY;
				continue;
			}
			switch(map[nY][nX]) {
			case 1:
				d = d==0 ? 1 : d==1 ? 3 : d==2 ? 0 : 2;
				++answer;
				break;
			case 2:
				d = d==0 ? 1 : d==1 ? 2 : d==2 ? 3 : 0;
				++answer;
				break;
			case 3:
				d = d==0 ? 2 : d==1 ? 0 : d==2 ? 3 : 1;
				++answer;
				break;
			case 4:
				d = d==0 ? 3 : d==1 ? 0 : d==2 ? 1 : 2;
				++answer;
				break;
			case 5:
				d = d==0 ? 1 : d==1 ? 0 : d==2 ? 3 : 2;
				++answer;
				break;
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				String[] next = wormhole.get(nX+","+nY).split(",");
				x = Integer.parseInt(next[0]);
				y = Integer.parseInt(next[1]);
				break;
			case 0:
				break;
			}
			if(6<=map[nY][nX]&&map[nY][nX]<=10) continue;
			x = nX;
			y = nY;
		}
		return answer;
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;++t) {
			N = Integer.parseInt(br.readLine());
			ArrayList<String>[] a = new ArrayList[5];
			for(int i=0;i<5;++i) {
				a[i] = new ArrayList();
			}
			answer = 0;
			map = new int[N][N];
			for(int i=0;i<N;++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(6<=map[i][j]) {
						a[map[i][j]-6].add(j+","+i);
					}
				}
			}
			
			for(int i=0;i<5;++i) {
				if(!a[i].isEmpty()) {
					wormhole.put(a[i].get(0), a[i].get(1));
					wormhole.put(a[i].get(1), a[i].get(0));
				}
			}
			
			// 구현 //
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j] == 0) {
						for(int k=0;k<4;++k) {
							//System.out.println(j+" "+i+" "+k);
							answer = Math.max(answer, go(i,j,k));
						}
					}
				}
			}
			////////
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
}