import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3499 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;++t) {
			br.readLine();
			String[] deq = br.readLine().split(" ");
			
			System.out.print("#"+t);
			int front = 0;
			int back = deq.length%2==0 ? deq.length/2 : deq.length/2 + 1;
			for(int i=0;i<deq.length;++i) {
				if(i%2==0) {
					System.out.print(" "+deq[front++]);
				}else {
					System.out.print(" "+deq[back++]);
				}
			}
			System.out.println();
		}
	}
}
