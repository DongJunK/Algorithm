import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767 {
	static int n;
	static int[][] map;
	static List<Pair> list;
	static int coreCnt;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int maxCore;
	static int minLine;
	
	static boolean checkRange(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;++t) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			list = new ArrayList<Pair>();
			coreCnt = 0;
			
			for(int i=0;i<n;++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i == 0 || i == n-1 || j == 0 || j == n-1) continue;
						++coreCnt;
						list.add(new Pair(i,j));
					}
				}
			}
			maxCore = Integer.MIN_VALUE;
			minLine = Integer.MAX_VALUE;
			
			dfs(0,0,0);
			
			System.out.println("#"+t+" "+minLine);
		}
	}
	
	static void dfs(int idx, int cnt, int line) {
		if(idx == coreCnt) {
			if(maxCore < cnt) {
				maxCore = cnt;
				minLine = line;
			}else if(maxCore == cnt && minLine > line) {
				maxCore = cnt;
				minLine = line;
			}
			return;
		}
		
		Pair p = list.get(idx);
		for(int i=0;i<4;++i) {
			int check = setLine(p,i);
			if(check != -1) {
				dfs(idx+1,cnt+1,line+check);
				int x = p.x;
				int y = p.y;
				while(true) {
					x += dx[i];
					y += dy[i];
					if(checkRange(x,y)) {
						map[y][x] = 0;
					}else {
						break;
					}
				}
			}
		}
		dfs(idx+1,cnt,line);
	}
	
	static int setLine(Pair p, int d) {
		int x = p.x;
		int y = p.y;
		boolean flag = false;
		int line = 0;
		while(true) {
			x += dx[d];
			y += dy[d];
			
			if(!checkRange(x,y)) {
				flag = true;
				break;
			}else if(map[y][x] != 0) {
				flag = false;
				break;
			}
		}
		x = p.x;
		y = p.y;
		if(flag) {
			while(true) {
				x += dx[d];
				y += dy[d];
				
				if(!checkRange(x,y))break;
				map[y][x] = 1;
				++line;
			}
			return line;
		}
		
		return -1;
		
	}
	
	
	static class Pair{
		int x,y;
		
		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
