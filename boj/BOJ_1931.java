import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
	static Conference[] cf;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cf = new Conference[N];
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cf[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cf);
		int n=0;
		int answer = 0;
		for(int i=0;i<N;++i) {
			if(n<=cf[i].start) {
				n = cf[i].end;
				++answer;
			}
		}
		System.out.println(answer);
	}
	
	static class Conference implements Comparable<Conference>{
		int start;
		int end;
		Conference(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Conference o) {
			// TODO Auto-generated method stub
			if(this.end - o.end  == 0) {
				if(this.start < o.start) {
					return -1;
				}else {
					return 1;
				}
			}
			return this.end - o.end;
		}
	}

}
