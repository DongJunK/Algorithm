import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class kakao2019WI_blacklist {
	List<String>[] list;
	HashSet<String> select;
	HashSet<String> ans;
	int n;
	public int solution(String[] user_id, String[] banned_id) {
        n = banned_id.length;
        list = new ArrayList[banned_id.length];
        for(int i=0;i<banned_id.length;++i) {
        	list[i] = new ArrayList<String>();
        	outer:for(int j=0;j<user_id.length;++j) {
        		if(banned_id[i].length() != user_id[j].length()) continue;
        		for(int k=0;k<banned_id[i].length();++k) {
        			if(banned_id[i].charAt(k) == '*') continue;
        			if(banned_id[i].charAt(k) != user_id[j].charAt(k))
        				continue outer;
        		}
        		list[i].add(user_id[j]);
        	}
        }
        select = new HashSet<String>();
        ans = new HashSet<String>();
        
        perm(0);
        return ans.size();
    }
	
	void perm(int idx) {
		if(idx == n) {
			Object[] str = select.toArray();
			Arrays.sort(str);
			String input = "";
			for(int i=0;i<str.length;++i) {
				input+=str[i]+",";
			}
			ans.add(input);
			return;
		}
		for(int i=0;i<list[idx].size();++i) {
			
			if(select.add(list[idx].get(i))) {
				perm(idx+1);
				select.remove(list[idx].get(i));
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id2 = {"*rodo", "*rodo", "******"};
		String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(new kakao2019WI_blacklist().solution(user_id3, banned_id3));
	}

}
