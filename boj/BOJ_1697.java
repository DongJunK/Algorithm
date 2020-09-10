import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int now = Integer.parseInt(st.nextToken());
		int aim = Integer.parseInt(st.nextToken());
		int max = 100000;
		int answer = 0;
		boolean[] visit = new boolean[max+1];
		
		Arrays.fill(visit,false);
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(now);
		while(true) {
			int size = q.size();
			for(int i=0;i<size;++i) {
				int next = q.poll();
				if(next == aim){
					System.out.println(answer);
					return;
				}
				if(0<=next-1&&!visit[next-1]) {
					q.offer(next-1);
					visit[next-1] = true;
				}
				if(next+1<=max && !visit[next+1]) {
					q.offer(next+1);
					visit[next+1] = true;
				}
				if(next*2<=max && !visit[next*2]) {
					q.offer(next*2);
					visit[next*2] = true;
				}
			}
			
			++answer;
		}
	}
}
