import java.util.ArrayList;
import java.util.List;

public class kakao2018b_traffic {
	List<int[]> time;
	public int solution(String[] lines) {
        int answer = 0;
        time = new ArrayList<int[]>();
        
        for(int i=0;i<lines.length;++i) {
        	String[] info = lines[i].split(" ");
        	
        	String[] timeInfo = info[1].split(":");
        	int hourToMs = Integer.parseInt(timeInfo[0])*3600000;
        	int minToMs = Integer.parseInt(timeInfo[1])*60000;
        	int secondToMs = (int)(Double.parseDouble(timeInfo[2])*1000);
        	
        	int end = hourToMs + minToMs + secondToMs;
        	int running = (int)(Double.parseDouble(info[2].substring(0,info[2].length()-1))*1000);
        	time.add(new int[]{end-(running-1),end});
        }
        for(int i=0;i<time.size();++i) {
        	int cnt = 1;
        	for(int j=i+1;j<time.size();++j) {
        		int nowEnd = time.get(i)[1];
        		int checkStart = time.get(j)[0];
        		if(checkStart-nowEnd<1000) {
        			++cnt;
        		}
        	}
        	answer = Math.max(answer, cnt);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input1 = new String[]{"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s","2016-09-15 21:00:02.066 2.62s"};
		String[] input2 = new String[] {
				"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
		System.out.println(new kakao2018b_traffic().solution(input1));
	}
	
	
}
