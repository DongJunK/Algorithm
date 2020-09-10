import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1954 {
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int map[][];
	static int N;
	
	static boolean check_range(int x,int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}
	
	static void printAnswer() {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int t=1;t<=TC;++t) {
			int cnt =1;
			N = sc.nextInt();
			
			map = new int[N][N];
			
			// 배열 초기화
			for(int i=0;i<N;++i) {
				Arrays.fill(map[i], 0);
			}
			
			int nowX = 0;
			int nowY = 0;
			int direction = 0;
			map[nowY][nowX] = cnt++;
			
			while(cnt<=N*N) {
				int nextX = nowX + dx[direction];
				int nextY = nowY + dy[direction];
				if(check_range(nextX,nextY) && map[nextY][nextX] == 0) {
					nowX = nextX;
					nowY = nextY;
					map[nowY][nowX] = cnt++;
				}else {
					direction+=1;
					direction%=4;
				}
			}
			
			System.out.println("#"+t);
			//정답 출력
			printAnswer();
		}
		sc.close();
	}

}
