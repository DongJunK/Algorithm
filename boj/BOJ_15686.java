import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
	static int n;
	static int maxChickenN;
	static int[][] map;
	static List<int[]> chicken;
	static int answer;
	static boolean[][] chickenCheck;
	
	static int checkDist(int y,int x) {
		int dist = Integer.MAX_VALUE;
		for(int i=0;i<chicken.size();++i) {
			int cY = chicken.get(i)[0];
			int cX = chicken.get(i)[1];
			if(chickenCheck[cY][cX]) {
				dist = Math.min(dist, Math.abs(x-cX) + Math.abs(y-cY));
			}
		}
		return dist;
	}
	
	static void solve(int now, int chickenN) {
		if(chickenN == maxChickenN) {
			int result = 0;
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					if(map[i][j] == 1) {
						result += checkDist(i,j);
					}
				}
			}
			answer = Math.min(answer, result);
			return;
		}
		for(int i=now;i<chicken.size();++i) {
			int cY = chicken.get(i)[0];
			int cX = chicken.get(i)[1];
			chickenCheck[cY][cX] = true;
			solve(i+1,chickenN+1);
			chickenCheck[cY][cX] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		maxChickenN = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		chickenCheck = new boolean[n][n];
		chicken = new ArrayList<int[]>();
		for(int i=0;i<n;++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		answer = Integer.MAX_VALUE;
		solve(0,0);
		System.out.println(answer);
	}

}
