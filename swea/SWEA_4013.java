import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_4013 {
	static int k;
	static int width = 8;
	static int height = 4;
	static Deque<Integer>[] gear;
	static int[] turnInfo;
	static int turn;
	static int aim;
	
	static void InitTurn() {
		turnInfo = new int[4];
		for(int i=0;i<4;++i) {
			turnInfo[i] = 0;
		}
	}
	
	static void turnGear() {
		
		for(int i=0;i<4;++i) {
			if(turnInfo[i]==1) {
				gear[i].offerFirst(gear[i].pollLast());
			}else if(turnInfo[i]==-1){
				gear[i].offerLast(gear[i].pollFirst());
			}
		}
	}
	
	static void check_turn(int now, int cD) {
		if(now<0 || 3<now) return;
		int comPos = now-cD;
		
		List<Integer> nowList = (LinkedList<Integer>)gear[now];
		List<Integer> comList = (LinkedList<Integer>)gear[comPos];
		
		if(cD == 1 && nowList.get(6) != comList.get(2) ) {
			turnInfo[now] = -turnInfo[comPos];
			check_turn(now+cD,cD);
		}else if(cD==-1&&nowList.get(2) != comList.get(6)){
			turnInfo[now] = -turnInfo[comPos];
			check_turn(now+cD,cD);
		}
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			int k = Integer.parseInt(br.readLine());
			
			gear = new Deque[4];
			for(int i=0;i<4;++i) {
				gear[i] = new LinkedList<Integer>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;++j) {
					 gear[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(int i = 0;i<k;++i) {
				InitTurn();
				StringTokenizer st = new StringTokenizer(br.readLine());
				int aim = Integer.parseInt(st.nextToken())-1;
				turn = Integer.parseInt(st.nextToken());
				turnInfo[aim] = turn;
				check_turn(aim-1,-1);
				check_turn(aim+1,1);
				turnGear();
			}
			int answer = 0;
			for(int i=0;i<4;++i) {
				answer += gear[i].pollFirst()*Math.pow(2, i);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
