import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class kakao2018b_news {
	List<String> oneList;
	HashMap<String,Integer> oneHash;
	HashMap<String,Integer> twoHash;
	List<String> twoList;
	public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        oneList = new ArrayList<String>();
        twoList = new ArrayList<String>();
        oneHash = new HashMap<String, Integer>();
        twoHash = new HashMap<String, Integer>();
        addItem(oneHash,oneList,str1);
        addItem(twoHash,twoList,str2);
        
        int same = sameStr();
        int union = unionStr();
        double rate = (double)same/union;
        if(union == 0) {
        	rate = 1;
        }
        else if(same == 0) {
        	rate = 0;
        }
        int result = (int)(rate * 65536);
        return result;
    }
	
	int unionStr() {
		int result = 0;
		for(int i=0;i<oneList.size();++i) {
			String value = oneList.get(i);
			if(twoHash.containsKey(value)) {
				result += Math.max(oneHash.get(value), twoHash.get(value));
				oneHash.replace(value, 0);
				twoHash.replace(value, 0);
			}
		}
		for(int i=0;i<oneList.size();++i){
			result += oneHash.get(oneList.get(i));
		}
		for(int i=0;i<twoList.size();++i) {
			result += twoHash.get(twoList.get(i));
		}
		return result;
	}
	
	int sameStr() {
		int result = 0;
		for(int i=0;i<oneList.size();++i) {
			String value = oneList.get(i);
			if(twoHash.containsKey(value)) {
				result += Math.min(oneHash.get(value), twoHash.get(value));
			}
		}
		return result;
	}
	
	void addItem(HashMap<String,Integer> hash, List<String> list, String str) {
		for(int i=0;i<str.length()-1;++i) {
        	if(0<=str.charAt(i)-'a'&&str.charAt(i)-'a'<=26&&0<=str.charAt(i+1)-'a'&&str.charAt(i+1)-'a'<=26) {
        		String value = str.substring(i,i+2);
        		list.add(value);
        		if(hash.containsKey(value)) {
        			hash.replace(value, hash.get(value)+1);
        			list.remove(list.size()-1);
        		}else {
        			hash.put(value, 1);
        		}
        	}
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new kakao2018b_news().solution("E=M*C^2", "e=m*c^2"));
	}

}
