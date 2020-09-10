import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124 {
	static Edge[] Elist;
	static int[] p;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long result = 0;
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			Elist = new Edge[E];
			p = new int[V+1];
			for(int i=1;i<=V;++i) {
				p[i] = i;
			}
			for(int i=0;i<E;++i) {
				st = new StringTokenizer(br.readLine());
				Elist[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(Elist);
			for(int i=0;i<E;++i) {
				if(union(Elist[i].start,Elist[i].end)) {
					result += Elist[i].weight;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
	static int find(int node) {
		if(p[node]==node) {
			return node;
		}
		return p[node] = find(p[node]);
	}
	
	static boolean union(int one, int two) {
		int oneRoot = find(one);
		int twoRoot = find(two);
		if(oneRoot != twoRoot) {
			p[twoRoot] = oneRoot;
			return true;
		}
		return false;
	}
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
}
