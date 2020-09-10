import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class SWEA_5658 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String secret = br.readLine();
			
			Set<String> set = new HashSet<String>();
			
			for(int i=0;i<N;++i) {
				String input = "";
				for(int j=0;j<N/4;++j) {
					input += Character.toString(secret.charAt((i+j)%N));
				}
				set.add(input);
			}
			
			List<String> list = new ArrayList<String>(set);
			Collections.sort(list, Collections.reverseOrder());
			long answer = Integer.parseInt(list.toArray()[K-1].toString(),16);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}

}
