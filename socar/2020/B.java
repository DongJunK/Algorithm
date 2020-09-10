
public class B {
	public int solution(String[] bakery_schedule, String current_time, int K) {
		int answer = 0;
		int curHour = Integer.parseInt(current_time.substring(0,2));
		int curMin = Integer.parseInt(current_time.substring(3,5));
		int count = 0;
		boolean flag = false;
		for(int i=0;i<bakery_schedule.length;++i) {
			int scheHour = Integer.parseInt(bakery_schedule[i].substring(0,2));
			int scheMin = Integer.parseInt(bakery_schedule[i].substring(3,5));
			int scheCnt = Integer.parseInt(bakery_schedule[i].substring(6));
			if((scheHour==curHour&&curMin<=scheMin)||(curHour<scheHour)) {
				count += scheCnt;
			}
			
			if(K<=count) {
				answer += (scheHour-curHour)*60+(scheMin-curMin);
				flag = true;
				break;
			}
		}
		if(!flag) answer = -1;
		return answer;
	}
}
