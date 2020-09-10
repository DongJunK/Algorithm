import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	static int height;
	static int width;
	static int turnN;
	static int[][] arr;
	static int[][] turn;
	static boolean[] visit;
	static int[][] tmpArr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int answer = Integer.MAX_VALUE;
	static int nowX;
	static int nowY;
	
	// 배열 돌리는 부분
	static void turnArr(int idx) {
		int cX = turn[idx][0];
		int cY = turn[idx][1];
		int depth = turn[idx][2];
		for(int i=depth;0<i;--i) {
			nowX = cX-i;
			nowY = cY-i;
			int tmp = tmpArr[nowY][nowX];
			rec(1,i*2+1);
			rec(0,i*2+1);
			rec(3,i*2+1);
			rec(2,i*2+1);
			
			tmpArr[nowY][nowX+1] = tmp;
			
		}
	}
	
	// 방향에 맞게 숫자를 한칸씩 이동 시키는 부분
	static void rec(int d, int length) {
		for(int i=0;i<length-1;++i) {
			int nX = nowX + dx[d];
			int nY = nowY + dy[d];
			
			tmpArr[nowY][nowX] = tmpArr[nY][nX];
			nowX = nX;
			nowY = nY;
		}
	}
	
	//순열
	static void run(int cnt) {
		if(cnt == turnN) {
			int result = Integer.MAX_VALUE;
			for(int i=1;i<=height;++i) {
				int now=0;
				for(int j=1;j<=width;++j) {
					now +=tmpArr[i][j];
				}
				result = Math.min(result,now);
			}
			answer = Math.min(answer, result);
			return;
		}
		
		int[][] tmp = new int[height+1][width+1];
		arrayCopy(tmpArr,tmp);
		for(int i=0;i<turnN;++i) {
			if(visit[i])continue;
			visit[i] = true;
			arrayCopy(tmp,tmpArr);
			turnArr(i);
			run(cnt+1);
			visit[i] = false;
		}
	}
	
	// 배열 복사
	static void arrayCopy(int[][] one, int[][] two) {
		for(int i=0;i<one.length;++i) {
			System.arraycopy(one[i], 0, two[i], 0, two[i].length);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken()); 
		width = Integer.parseInt(st.nextToken()); 
		turnN = Integer.parseInt(st.nextToken());
		turn = new int[turnN][3];
		arr = new int[height+1][width+1];
		tmpArr = new int[height+1][width+1];
		visit = new boolean[turnN];
		for(int i=1;i<=height;++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=width;++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<turnN;++i) {
			st = new StringTokenizer(br.readLine());
			turn[i][1] = Integer.parseInt(st.nextToken());
			turn[i][0] = Integer.parseInt(st.nextToken());
			turn[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<turnN;++i) {
			visit[i] = true;
			arrayCopy(arr,tmpArr);
			turnArr(i);
			run(1);
			visit[i] = false;
		}
		
		System.out.println(answer);
	}
	
}