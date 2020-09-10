import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1233 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;++t) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> al = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;++i) {
				al.add(Integer.parseInt(st.nextToken()));
			}
			
			int commandN = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<commandN;++i) {
				
				st.nextToken();
				int insertIndex = Integer.parseInt(st.nextToken());
				int insertN = Integer.parseInt(st.nextToken());
				for(int j=0;j<insertN;++j) {
					al.add(insertIndex++,Integer.parseInt(st.nextToken()));
				}
				
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i=0;i<10;++i) {
				sb.append(al.get(i)).append(" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		}
	}
}
