import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2477 {
	static int clientN;
	static int repairN;
	static int receiptN;
	static int repairSame;
	static int receiptSame;
	
	static int[] receiptTime;
	static int[] repairTime;
	static int[] receiptNowArr;
	static int[] repairNowArr;
	
	static Client[] clientArr;
	
	static Queue<Integer> receiptWait;
	static Queue<Integer> repairWait;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			receiptN = Integer.parseInt(st.nextToken());
			repairN = Integer.parseInt(st.nextToken());
			clientN = Integer.parseInt(st.nextToken());
			receiptSame = Integer.parseInt(st.nextToken());
			repairSame = Integer.parseInt(st.nextToken());
			receiptTime = new int[receiptN+1];
			repairTime = new int[repairN+1];
			clientArr = new Client[clientN+1];
			
			receiptNowArr = new int[receiptN+1];
			repairNowArr = new int[repairN+1];
			Arrays.fill(receiptNowArr, -1);
			Arrays.fill(repairNowArr, -1);
			receiptWait = new LinkedList<Integer>();
			repairWait = new LinkedList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=receiptN;++i) {
				receiptTime[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=repairN;++i) {
				repairTime[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=clientN;++i) {
				Client c = new Client(Integer.parseInt(st.nextToken()));
				clientArr[i] = c;
				receiptWait.offer(i);
			}
			int answer = 0;
			
			int nowClientN = clientN;
			int time = 0;
			
			while(0<nowClientN){
				for(int i=1;i<=receiptN;++i) {
					if(receiptNowArr[i] != -1){
						if(clientArr[receiptNowArr[i]].time == 0) {
							repairWait.offer(receiptNowArr[i]);
							receiptNowArr[i] = -1;
						}
					}
				}
				for(int i=1;i<=receiptN;++i) {
					if(receiptNowArr[i] == -1){
						if(receiptWait.isEmpty())continue;
						if(clientArr[receiptWait.peek()].time==0) {
							receiptNowArr[i] = receiptWait.poll(); //해당 접수 창구 번호 저장
							clientArr[receiptNowArr[i]].time = receiptTime[i]; // 해당 접수 창구 시간 저장
							if(receiptSame == i) { // 지갑 잃어버린 사람과 같은 창구
								clientArr[receiptNowArr[i]].flag = true;
							}
						}
					}
				}
				
				for(int i=1;i<=repairN;++i) {	
					if(repairNowArr[i] != -1){
						if(clientArr[repairNowArr[i]].time == 0) {
							if(clientArr[repairNowArr[i]].flag && i == repairSame) {
								answer += repairNowArr[i];
							}
							repairNowArr[i] = -1;
							--nowClientN;
						}
					}
				}
				
				for(int i=1;i<=repairN;++i) {
					if(repairNowArr[i] == -1) {
						if(repairWait.isEmpty())continue;
						repairNowArr[i] = repairWait.poll();
						clientArr[repairNowArr[i]].time = repairTime[i];
					}
				}	
				
				downTime();
				++time;
			}
			
			if(answer == 0 ) answer = -1;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
	static void downTime() {
		for(int i=1;i<=clientN;++i) {
			if(0<clientArr[i].time) {
				--clientArr[i].time;
			}
		}
	}
	static class Client{
		int time;
		boolean flag;
		public Client(int time) {
			this.time = time;
			flag = false;
		}
	}

}
