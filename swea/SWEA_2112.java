import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112 {
	static int height;
	static int width;
	static int accept;
	static int answer;
	static int[][] map;
	static int[][] tmpMap;
	static int[] select;
	static int[] paint;
	static boolean flag;
	static boolean checkAccept(int[][] tmp) {
		for(int x=0;x<width;++x) {
			int check = 1;
			int now = tmp[0][x];
			for(int i=1;i<height;++i) {
				if(check==accept) {
					break;
				}
				if(now == tmp[i][x]) {
					++check;
				}else {
					now = tmp[i][x];
					check = 1;
				}
			}
			
			if(check<accept)
				return false;
		}
		return true;
	}
	
	
	
	static void copyMap(int[][] one, int[][] two) {
		for(int i=0;i<height;++i) {
			System.arraycopy(one[i], 0, two[i], 0, two[i].length);
		}
	}
	static void run(int[][] map,int idx, int check) {
		for(int i=0;i<width;++i) {
			map[idx][i] = check;
		}
	}
	
	static void perm2(int idx, int n) {
		if(idx == n) {
			copyMap(map,tmpMap);
			for(int i=0;i<n;++i) {
				run(tmpMap,select[i],paint[i]);
			}
			if(checkAccept(tmpMap)) {
				flag = true;
			}
			return;
		}
		paint[idx] = 0;
		perm2(idx+1,n);
		paint[idx] = 1;
		perm2(idx+1,n);
	}
	
	static void perm(int idx, int cnt, int n) {
		if(flag) return;
		if(cnt == n) {
			perm2(0,n);
			return;
		}
		for(int i=idx;i<height;++i) {
			select[cnt] = i;
			perm(i+1,cnt+1,n);
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			accept = Integer.parseInt(st.nextToken());
			map = new int[height][width];
			tmpMap = new int[height][width];
			for(int i=0;i<height;++i) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<width;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = accept;
			select = new int[accept];
			paint = new int[accept];
			
			for(int i=0;i<accept;++i) {
				flag = false;
				perm(0,0,i);
				if(flag) {
					answer = i;
					break;
				}
			}
			
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
