import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class kakao2019b_key {
	boolean[] select;
	int columnSize, rowSize,answer;
	String[][] relation;
	List<String> key;
	
	public boolean check(int cnt) {
		Set<String> set = new HashSet<String>();
		for(int i=0;i<rowSize;++i) {
			String compareStr = "";
			for(int k=0;k<columnSize;++k) {
				if(select[k]) {
					compareStr += relation[i][k]+",";
				}
			}
			if(!set.add(compareStr)) {
				return false;
			}
		}
		return true;
	}
	
	public void np(int idx, int cnt) {
		if(cnt!=0&&check(cnt)) {
			++answer;
			return;
		}
		
		if(idx == columnSize) return;
		
		for(int i=idx;i<columnSize;++i) {
			if(select[i]) continue;
			select[i] = true;
			np(i+1,cnt+1);
			select[i] = false;
		}
	}
	
	public int solution(String[][] relation) {
        answer = 0;
        columnSize = relation[0].length;
        rowSize = relation.length;
        select = new boolean[columnSize];
        key = new ArrayList<String>();
        this.relation = relation;
        for(int i=0;i<columnSize;++i) {
        	select[i] = true;
        	np(i,1);
        	select[i] = false;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] input1 = new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		String[][] input2 = new String[][] {{"a","aa"},{"aa","a"},{"a","a"}};
		String[][] input3 = new String[][] {{"a","b","c"},{"1","b","c"},{"a","b","4"},{"a","5","c"}};
		String[][] input4 = new String[][] {{"a","1","4"},{"2","1","5"},{"a","2","4"}};
		System.out.println(new kakao2019b_key().solution(input4));
	}
}