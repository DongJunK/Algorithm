import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kakao2021b_running {
	public String solution(String play_time, String adv_time, String[] logs) {
		int maxRunning = 0;
		String answer ="00:00:00";
		int answerStart = 0;
		List<Time> timeList = new ArrayList<Time>();
        String[] timeInfo = adv_time.split(":");
        int hour = Integer.parseInt(timeInfo[0])*3600;
        int min = Integer.parseInt(timeInfo[1])*60;
        int second = (int)(Double.parseDouble(timeInfo[2]));
    	int adv_running = hour+min+second;
        for(int i=0;i<logs.length;++i) {
        	String[] info = logs[i].split("-");
        	
        	timeInfo = info[0].split(":");
        	hour = Integer.parseInt(timeInfo[0])*3600;
        	min = Integer.parseInt(timeInfo[1])*60;
        	second = (int)(Double.parseDouble(timeInfo[2]));
        	int start = hour+min+second;
        	
        	timeInfo = info[1].split(":");
        	hour = Integer.parseInt(timeInfo[0])*3600;
        	min = Integer.parseInt(timeInfo[1])*60;
        	second = (int)(Double.parseDouble(timeInfo[2]));        	
        	int end = hour+min+second;
        	
        	timeList.add(new Time(start,end,i));
        }
        Collections.sort(timeList);
        int running = 0;
        for(int i=0;i<timeList.size();++i) {
        	Time now = timeList.get(i);
        	if(now.start<adv_running) {
        		if(now.end<=adv_running) {
        			running += now.end-now.start;
        		}else {
        			running += adv_running - now.start;
        		}
        	}else {
        		break;
        	}
        }
        maxRunning = running;
        answerStart = -1;
        for(int i=0;i<timeList.size();++i) {
        	running = 0;
        	int start = timeList.get(i).start;
        	int end = start + adv_running;
        	
        	for(int j=0;j<timeList.size();++j) {
        		int checkStart = timeList.get(j).start;
        		int checkEnd = timeList.get(j).end;
        		
        		if(checkStart<end) {
            		if(checkEnd<=end) {
            			running += checkEnd - checkStart;
            		}else {
            			running += end - checkStart;
            		}
            	}else {
            		break;
            	}
        	}
        	if(maxRunning<running) {
        		answerStart = timeList.get(i).idx;
        		maxRunning = running;
        	}
        }
        if(answerStart != -1) {
        	answer = logs[answerStart].split("-")[0];
        }
        
        return answer;
    }
	
	class Time implements Comparable<Time>{
		int start;
		int end;
		int idx;
		public Time(int start, int end, int idx) {
			this.start = start;
			this.end = end;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Time o) {
			// TODO Auto-generated method stub
			return this.start-o.start;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new kakao2021b_running().solution("50:00:00", "50:00:00", new String[] {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
	}

}
