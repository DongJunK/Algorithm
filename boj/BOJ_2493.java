import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2493 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<N;++i) {
			while(!s.isEmpty()) {
				int pre = s.pop();
				if(arr[pre] < arr[i]){
					continue;
				}
				if(arr[i] < arr[pre]){
					s.push(pre);
					break;
				}
			}
			System.out.print(i+" ");
			s.push(i);
		}
		System.out.println();
	}
}
