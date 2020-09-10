import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {
	static int[][] grid;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N;
	static int cnt;
	static boolean checkRange(int x, int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}
	static void dfs(int y,int x)
	{
	    ++cnt;
	    grid[y][x] = 0;
	    for(int i=0;i<4;++i)
	    {
	        int nextX = x+dx[i];
	        int nextY = y+dy[i];
	        if(checkRange(nextX,nextY)&&
	           grid[nextY][nextX] == 1)
	        {
	            dfs(nextY,nextX);
	        }
	    }
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for(int i=0;i<N;++i) {
			String input = br.readLine();
			grid[i] = new int[N];
			for(int j=0;j<N;++j) {
				grid[i][j] = input.charAt(j)-'0';
			}
		}
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(grid[i][j] == 1) {
					cnt = 0;
					dfs(i,j);
					array.add(cnt);
				}
			}
		}
		Collections.sort(array);
		System.out.println(array.size());
		for(int i=0;i<array.size();++i) {
			System.out.println(array.get(i));
		}
	}

}