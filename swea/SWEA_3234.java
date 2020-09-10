import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3234 {
	static int n;
	static int[] arr;
	static boolean[] v;
	static int answer;
	
	static void solution(int cnt, int l,int r,int remain) {
		if(remain+r<=l) { // 남은 추의 무게 합이 왼쪽보다 같거나 작을 경
			int sum = 1;

			//index당 오른쪽, 왼쪽 각각 한번 총 2번씩 경우의 수가 있기 때문에 남은 index만큼 곱하기 2
			for(int i=0;i<n-cnt;++i) {
				sum*=2;
			}
			
			// Factorial 남은 index에 대한 배치순서
			for(int i=1;i<=n-cnt;++i) {
				sum*=i;
			}
			answer += sum;
			return;
		}
		
		if(cnt == n) {
			if(r<=l) {
				++answer;
			}
			return;
		}
		
		for(int i=0;i<n;++i) {
			if(v[i]) continue;
			v[i] = true;
			if(r+arr[i]<=l) {
				solution(cnt+1,l,r+arr[i],remain-arr[i]);
			}
			solution(cnt+1,l+arr[i],r,remain-arr[i]);
			
			v[i] = false;
		}
			
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;++t) {
			answer = 0;
			
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			v = new boolean[n];
			for(int i=0;i<n;++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			solution(0,0,0,Arrays.stream(arr).sum());
			
			System.out.println("#"+t+" "+answer);
		}
	}

}
