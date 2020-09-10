
public class C {
	int[] move;
	int maxAns = 0;
	int maxLimit = 0;
	int size = 0;
	int N;
	boolean[] v;
	boolean checkRange(int pos) {
		return 0<=pos&&pos<size;
	}
	
	void dfs(int pos, int limit, int ans, int[][] delivery) {
 		if(maxLimit<limit) {
			maxAns = Math.max(maxAns, ans);
			return;
		}
		for(int i=0;i<4;++i) {
			int nPos = pos + move[i];
			if(i<2) {
				if((pos%N==0 && i == 1 )||(pos%N==N-1 && i == 0)) continue;
			}
			if(!checkRange(nPos)) continue;
			
			if(limit <= delivery[nPos][0] && !v[nPos]) {
				v[nPos] = true;
				dfs(nPos,limit+1,ans+delivery[nPos][1],delivery);
				v[nPos] = false;
			}else {
				dfs(nPos,limit+1,ans,delivery);
			}
		}
	}
	public int solution(int r, int[][] delivery) {
		move = new int[] {1,-1,r,-r};
		N = r;
		v = new boolean[delivery.length];
		int answer = 0;
		size = delivery.length;
		
		for(int i=0;i<delivery.length;++i) {
			maxLimit = Math.max(maxLimit, delivery[i][0]);
			v[i] = false;
		}
		
		v[0] = true;
		dfs(0,0,delivery[0][1],delivery);
		
		answer = maxAns;
		
		return answer;
	}
	public static void main(String[] args) {
		int[][] test1 = new int[][]{{1, 5},{8, 3},{4, 2},{2, 3},{3, 1},{3, 2},{4, 2},{5, 2},{4, 1}};
		System.out.println(new C().solution(3, test1));
	}
}
