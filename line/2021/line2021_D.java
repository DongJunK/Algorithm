public class line2021_D {
	int[][] maze;
	int[] dx = {-1,0,1,0};
	int[] dy = {0,1,0,-1};
	int n;
	int answer;
	public boolean checkRange(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	public void dfs(int x,int y, int dir, int cnt) {
		if(x == n-1 && y == n-1) {
			answer = cnt;
			return;
		}
		int nx = x + dx[(dir+1)%4];
		int ny = y + dy[(dir+1)%4];
		if(!checkRange(nx,ny) || maze[ny][nx] == 1) {
			dfs(x,y,dir==0?3:dir-1,cnt);
			return;
		}
		dfs(nx,ny,(dir+1)%4,cnt+1);
	}
	public int solution(int[][] maze) {
        answer = 0;
        this.maze = maze;
        n = maze.length;
        dfs(0,0,0,0);
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new line2021_D().solution(new int[][] {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}}));
	}

}
