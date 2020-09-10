import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ_14889 {
	static int N;
	static int[][] info;
	static boolean[] selected;
	static int answer;
	static void run(int idx, int cnt) {
		if(idx == N) {
			if(cnt!=N/2) return;
			int[] one = new int[N/2];
			int[] two = new int[N/2];
			
			int oneIdx = 0;
			int twoIdx = 0;
			
			for(int i=0;i<N;++i) {
				if(selected[i]) {
					one[oneIdx++] = i;
				}else {
					two[twoIdx++] = i;
				}
			}
			
			int oneResult = 0;
			int twoResult = 0;
			for(int i=0;i<(N/2)-1;++i) {
				for(int j=i+1;j<N/2;++j) {
					oneResult += info[one[i]][one[j]];
					oneResult += info[one[j]][one[i]];
					
					twoResult += info[two[i]][two[j]];
					twoResult += info[two[j]][two[i]];
				}
			}
			
			answer = Math.min(answer, Math.abs(oneResult-twoResult));
			return;
		}
		selected[idx] = true;
		run(idx+1,cnt+1);
		selected[idx] = false;
		run(idx+1,cnt);
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        info = new int[N][N];
        selected = new boolean[N];
        for(int i=0;i<N;++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;++j) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        run(0,0);
        System.out.println(answer);
	}
}