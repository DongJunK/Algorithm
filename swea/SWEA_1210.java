import java.util.Scanner;

public class SWEA_1210 {
	int dx[] = {1,-1,0};
	int dy[] = {0,0,-1};
	int map[][] = new int[100][100];
	boolean visit[][] = new boolean[100][100];
	
	boolean check_range(int x,int y) {
		return 0<=x&&x<100&&0<=y&&y<100;
	}
	
	void solve() {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;++t) {
			int startX=0;
			int startY=0;
			int result = 0;
			for(int i=0;i<100;++i) {
				for(int j=0;j<100;++j) {
					map[i][j] = sc.nextInt();
					visit[i][j] = false;
				}
			}
			
			for(int i=0;i<100;++i) {
				if(map[99][i] == 2) {
					startX = i;
					startY = 99;
					break;
				}
			}
			
			int nowX = startX;
			int nowY = startY;
			
			while(true) {
				if(nowY==0) {
					result = nowX;
					break;
				}
				visit[nowY][nowX] = true;
				for(int i=0;i<3;++i) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];
					if(check_range(nextX,nextY) && map[nextY][nextX] == 1 && !visit[nextY][nextX]) {
						nowX = nextX;
						nowY = nextY;
						break;
					}
				}
			}
			System.out.println("#" + t + " " + result);
			
		}
		sc.close();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SWEA_1210().solve();
	}
}