import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251 {
	static int n;
	static double e; // 세율
	static long answer;
	static List<Pair> island;
	static int[] p;
	static PriorityQueue<Distance> pq;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			n = Integer.parseInt(br.readLine());
			p = new int[n];
			island = new ArrayList<Pair>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] x = new int[n];
			int[] y = new int[n];
			for(int i=0;i<n;++i) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;++i) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<n;++i) {
				island.add(new Pair(i,x[i],y[i]));
				p[i] = i;
			}
			e = Double.parseDouble(br.readLine());
			pq = new PriorityQueue<Distance>();
			answer = 0;
			
			for(int i=0;i<n;++i) {
				for(int j=i+1;j<n;++j) {
					double dist = Math.pow((island.get(i).x-island.get(j).x),2)+Math.pow((island.get(i).y-island.get(j).y),2);
					pq.add(new Distance(island.get(i).number,island.get(j).number,dist));
				}
			}
			
			while(!pq.isEmpty()) {
				Distance distance = pq.poll();
				union(distance.u,distance.v,distance.weight);
			}
			
			System.out.println("#"+t+" "+Math.round(answer*e));
		}
	}
	static void union(int start, int end, double dist) {
		int startRoot = find(start);
		int endRoot = find(end);
		if(startRoot != endRoot) {
			p[endRoot] = p[startRoot];
			answer += dist;
		}
	}
	static int find(int x) {
		if(x == p[x]) {
			return x;
		}
		return p[x] = find(p[x]);
	}
	
	static class Pair{
		int number;
		int x,y;
		public Pair(int number, int x, int y) {
			this.number = number;
			this.x = x;
			this.y = y;
		}
	}
	static class Distance implements Comparable<Distance>{
		int u;
		int v;
		double weight;
		public Distance(int u, int v, double weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Distance o) {
			// TODO Auto-generated method stub
			if(this.weight > o.weight) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}
