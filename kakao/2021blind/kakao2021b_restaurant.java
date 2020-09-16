import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class kakao2021b_restaurant {
	HashMap<String, Integer> courseMap;
	boolean[] v;
	int[] cnt;
	String select;
	void check(int idx,int cnt, int n, String menu) {
		if(idx == menu.length()) {
			if(cnt == n) {
				if(courseMap.containsKey(select)) {
					courseMap.replace(select, courseMap.get(select)+1);
				}else {
					courseMap.put(select, 1);
				}
			}
			return;
		}
		select += menu.charAt(idx);
		check(idx+1,cnt+1,n,menu);
		select = select.substring(0,select.length()-1);
		check(idx+1,cnt,n,menu);
	}
	
	public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        courseMap = new HashMap<String, Integer>();
        v = new boolean[11];
        cnt = new int[11];
        for(int i=0;i<course.length;++i) {
        	v[course[i]] = true;
        }
        for(int i=0;i<orders.length;++i) {
        	for(int j=2;j<=orders[i].length();++j) {
        		if(!v[j])continue;
        		select = "";
        		char[] arr = orders[i].toCharArray();
        		Arrays.sort(arr);
        		check(0,0,j,new String(arr));
        	}
        }
        
        for(String key : courseMap.keySet()) {
        	cnt[key.length()] = Math.max(cnt[key.length()], courseMap.get(key));
        	//System.out.println(key+" "+ courseMap.get(key));
        }
        List<String> list = new ArrayList<String>();
        for(String key : courseMap.keySet()){
        	if(cnt[key.length()]<2)continue;
        	if(cnt[key.length()] == courseMap.get(key)) {
        		list.add(key);
        	}
        }
        answer = new String[list.size()];
        answer = list.toArray(answer);
        Arrays.sort(answer);
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input1 = new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		String[] input2 = new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		String[] input3 = new String[] {"XYZ", "XWY", "WXA"};
		
		System.out.println(Arrays.toString(new kakao2021b_restaurant().solution(input3, new int[] {2,3,4})));
	}

}
