import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class kakao2019WI_tuple {
	public int[] solution(String s) {
        int[] answer = {};
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int start = 0;
        int end = 0;
        boolean flag = false;
        for(int i=0;i<s.length();++i) {
        	if(s.charAt(i) == '{') {
        		start = i+1;
        		flag = true;
        	}else if(flag && s.charAt(i) == '}'){
        		end = i;
        		int[] arr = Arrays.stream(s.substring(start,end).split(","))
        				.map(String::trim).mapToInt(Integer::parseInt).toArray();
        		for(int j=0;j<arr.length;++j) {
        			if(hash.get(arr[j]) == null) {
        				hash.put(arr[j], 0);
        			}else {
        				hash.replace(arr[j], hash.get(arr[j])+1);
        			}
        		}
        		flag = false;
        	}
        }
        List<Pair> list = new ArrayList<Pair>();
        hash.forEach((key, value)->{
        	list.add(new Pair(key, value));
        });
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0;i<answer.length;++i) {
        	answer[i] = list.get(i).key;
        }
        
        return answer;
    }
	class Pair implements Comparable<Pair>{
		int key;
		int value;
		Pair(int key, int value){
			this.key = key;
			this.value = value;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return o.value - this.value;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		System.out.println(Arrays.toString(new kakao2019WI_tuple().solution(s)));
	}
	
}