import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int map[][];
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i=0;i<N;++i) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			outer:for(int i = 0;i<N;++i) {
				if(N<i+M) break;
				for(int j=0;j<N;++j) {
					if(N<j+M) continue outer;
					int sum = 0;
					for(int k=i;k<i+M;++k) {
						for(int l=j;l<j+M;++l) {
							sum += map[k][l];
						}
					}
					result = Math.max(result,sum);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(result);
			System.out.println(sb.toString());
		}
	}
}