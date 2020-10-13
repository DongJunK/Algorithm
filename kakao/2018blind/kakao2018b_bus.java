import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kakao2018b_bus {
	List<Integer> timeList;
	public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        timeList = new ArrayList<Integer>();
        int busTime = 9 * 3600;
        int answerTime = 0;
        for(int i=0;i<timetable.length;++i) {
        	int second = 0;
        	String[] time = timetable[i].split(":");
        	second +=Integer.parseInt(time[0])*3600;
        	second +=Integer.parseInt(time[1])*60;
        	timeList.add(second);
        }
        
        Collections.sort(timeList);
        for(int i=1;i<n;++i) {
        	for(int j=0;j<m;++j) {
        		if(timeList.get(0)<=busTime) {
        			timeList.remove(0);
        		}else {
        			break;
        		}
        	}
        	busTime += t*60;
        }
        if(timeList.size()<m) {
        	answerTime = busTime;
        }else if(timeList.get(m-1)<=busTime){
        	answerTime = timeList.get(m-1) - 60;
        }else {
        	answerTime = busTime;
        }
        String hour = Integer.toString(answerTime/3600);
        String min = Integer.toString((answerTime%3600)/60);
        
        answer = hour.length() == 1 ? "0"+hour:hour;
        answer += ":"+ (min.length() == 1 ? "0"+min:min);
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(new kakao2018b_bus().solution(1, 1, 1, new String[] {"23:59"}));
	}

}