import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {
	static int n, total, answer;
	static int[] people;
	static boolean[] v;
	static List<Integer>[] edge;
	
	static void check(int cnt) {
		int connectCnt = 0;
		boolean[] tmpV = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		int sum = 0;
		for(int i=1;i<=n;++i) {
			if(v[i]) {
				q.add(i);
				sum += people[i];
				tmpV[i] = true;
				++connectCnt;
				break;
			}
		}
		while(!q.isEmpty()) {
			int next = q.poll();
			for(int current : edge[next]) {
				if(v[current]&&!tmpV[current]) {
					q.offer(current);
					tmpV[current] = true;
					sum += people[current];
					++connectCnt;
				}
			}
		}
		
		if(cnt != connectCnt)return;
		
		for(int i=1;i<=n;++i) {
			if(!v[i]) {
				q.add(i);
				tmpV[i] = true;
				++connectCnt;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int next = q.poll();
			for(int current : edge[next]) {
				if(!v[current]&&!tmpV[current]) {
					q.offer(current);
					tmpV[current] = true;
					++connectCnt;
				}
			}
		}
		
		if(connectCnt==n) {
			answer = Math.min(answer, Math.abs(total-(sum*2)));
		}
		
	}
	static void solve(int idx, int cnt) {
		if(idx == n+1) {
			if(cnt == n || cnt == 0) return;
			check(cnt);
			return;
		}
		v[idx] = true;
		solve(idx+1,cnt+1);
		v[idx] = false;
		solve(idx+1,cnt);
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		people = new int[n+1];
		edge = new ArrayList[n+1];
		v = new boolean[n+1];
		total = 0;
		for(int i=1;i<=n;++i) {
			people[i] = Integer.parseInt(st.nextToken());
			total +=people[i];
		}
		for(int i=1;i<=n;++i) {
			st = new StringTokenizer(br.readLine());
			edge[i] = new ArrayList<Integer>();
			int length = Integer.parseInt(st.nextToken());
			for(int j=0;j<length;++j) {
				edge[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		answer = Integer.MAX_VALUE;
		solve(1,0);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
}