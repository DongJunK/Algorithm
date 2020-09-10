import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
	static int v,e,start;
	static int[] d;
	static List<Node>[] list;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		list = new ArrayList[v+1];
		d = new int[v+1];
		for(int i=1;i<=v;++i) {
			list[i] = new ArrayList();
			d[i] = INF;
		}
		for(int i=0;i<e;++i) {
			st = new StringTokenizer(br.readLine());
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			list[sV].add(new Node(eV,score));
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		d[start] = 0;
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int nNum = n.number;
			
			for(Node c :list[nNum]) {
				int cNum = c.number;
				if(d[nNum]+c.d<d[cNum]) {
					d[cNum] = d[nNum] + c.d;
					c.d = d[nNum] + c.d;
					pq.offer(c);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=v;++i) {
			sb.append(d[i] == INF?"INF":d[i]).append("\n");
		}
		System.out.println(sb);
	}
	static class Node implements Comparable<Node>{
		int number;
		int d;
		public Node(int number, int d) {
			this.number = number;
			this.d = d;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.d - o.d;
		}
	}
}
