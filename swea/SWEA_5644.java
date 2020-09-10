import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_5644 {
	static int N;
	static int apN;
	static int[] moveA;
	static int[] moveB;
	static int[][] map = new int[11][11];
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};
	static int[][] ap;
	
	static void checkAp(int x,int y, PriorityQueue<int[]> q) {
		for(int i=0;i<apN;++i) {
			if(Math.abs(ap[i][0]-x)+Math.abs(ap[i][1]-y)<=ap[i][2]) {
				q.offer(new int[]{ap[i][3],ap[i][4]});
			}
		}
	}
	
	static int run() {
		int result = 0;
		int[] nextA = {1,1};
		int[] nextB = {10,10};
		
		for(int i=0;i<=N;++i) {
			PriorityQueue<int[]> qA = new PriorityQueue<>((w1, w2) -> {  
                    if(w1[0]<w2[0]) return 1;
                    else if(w2[0]<w1[0]) return -1;
                    else return 0;
            });
			PriorityQueue<int[]> qB = new PriorityQueue<>((w1, w2) -> {  
                if(w1[0]<w2[0]) return 1;
                else if(w2[0]<w1[0]) return -1;
                else return 0;
        });
			checkAp(nextA[0],nextA[1],qA);
			checkAp(nextB[0],nextB[1],qB);
			if(qA.isEmpty() && !qB.isEmpty()) {
				result += qB.poll()[0];
			}else if(!qA.isEmpty() && qB.isEmpty()) {
				result += qA.poll()[0];
			}else if(!qA.isEmpty() && !qB.isEmpty()) {
				int[] qAInfo = qA.poll();
				int[] qBInfo = qB.poll();
				if(qAInfo[1] == qBInfo[1] && qA.size() == 0 && qB.size() == 0) {
					result += qAInfo[0];
				}
				else if(qAInfo[1] == qBInfo[1] && qA.size() == 0) {
					result += qAInfo[0] + qB.poll()[0];
				}
				else if(qAInfo[1] == qBInfo[1] && qB.size() == 0) {
					result += qBInfo[0] + qA.poll()[0];
				}else if(qAInfo[1] == qBInfo[1] && qA.size() != 0 && qB.size() != 0){
					result += qAInfo[0];
					int qATmp = qA.poll()[0];
					int qBTmp = qB.poll()[0];
					if(qATmp<qBTmp) {
						result += qBTmp;
					}
					else {
						result += qATmp;
					}
				}else{
					result += qAInfo[0] + qBInfo[0];
				}
			}
			
			if(N==i) break;
			nextA[0] = nextA[0]+dx[moveA[i]];
			nextA[1] = nextA[1]+dy[moveA[i]];
			nextB[0] = nextB[0]+dx[moveB[i]];
			nextB[1] = nextB[1]+dy[moveB[i]];
			
			
			
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t = 1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			apN = Integer.parseInt(st.nextToken());
			
			moveA = new int[N];
			moveB = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;++i) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;++i) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			ap = new int[apN][5];
			for(int i=0;i<apN;++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<4;++j) {
					ap[i][j] = Integer.parseInt(st.nextToken());
				}
				ap[i][4] = i+1;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(run());
			System.out.println(sb.toString());
		}
	}
	
}
