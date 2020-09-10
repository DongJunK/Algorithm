import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1225 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t=1;t<=10;++t) {
			br.readLine();
			LinkedList<Integer> secret = new LinkedList<Integer>();
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for(int i=0;i<8;++i) {
				secret.offer(Integer.parseInt(st.nextToken()));
			}
			int value = 0;
			while(true) {
				int secretFirst = secret.poll();
				secretFirst -= (value++%5)+1;
				
				if(secretFirst<=0) {
					secretFirst = 0;
					secret.offer(secretFirst);
					break;
				}
				secret.offer(secretFirst);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i=0;i<8;++i) {
				sb.append(secret.poll()).append(" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		}
	}
}
