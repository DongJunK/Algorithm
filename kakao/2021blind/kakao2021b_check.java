public class kakao2021b_check {
	public String checkSC(String new_id) {
		String result = "";
		for(int i=0;i<new_id.length();++i) {
			
			char now = new_id.charAt(i);
			if(!('a'<=now&&now<='z'||now=='.'||now=='-'||now=='_'||'0'<=now&&now<='9'))
				continue;
			result+=new_id.charAt(i);
		}
		return result;
	}
	public String checkRepeatDot(String new_id) {
		boolean flag = false;
		String result = "";
		for(int i=0;i<new_id.length();++i) {
			char now = new_id.charAt(i);
			if(!flag && now == '.') {
				flag = true;
				result += now;
			}else if(flag && now=='.') {
				continue;
			}
			else {
				flag = false;
				result+=now;
			}
		}
		return result;
	}
	public String checkDotFirstOrLast(String new_id) {
		if(new_id.length()==0) return new_id;
		
		if(new_id.charAt(0) == '.') {
			new_id = new_id.substring(1,new_id.length());
		}
		if(new_id.length()==0) return new_id;
		if(new_id.charAt(new_id.length()-1)=='.') {
			new_id = new_id.substring(0,new_id.length()-1);
		}
		return new_id;
	}
	public String checkEmpty(String new_id) {
		return new_id.length()==0 ? "a" : new_id;
	}
	
	public String checkOverLength(String new_id) {
		if(16<=new_id.length()) {
			new_id = new_id.substring(0, 15);
		}
		if(new_id.charAt(new_id.length()-1) == '.') {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
		return new_id;
	}
	public String checkUnderLength(String new_id) {
		while(new_id.length()<3) {
			new_id += new_id.charAt(new_id.length()-1);
		}
		return new_id;
	}
	public String solution(String new_id) {
        String answer = "";
        //first
        new_id = new_id.toLowerCase();
        
        //second
        new_id = checkSC(new_id);
        
        //third
        new_id = checkRepeatDot(new_id);
        
        //fourth
        new_id = checkDotFirstOrLast(new_id);
        
        //fifth
        new_id = checkEmpty(new_id);
        
        //sixth
        new_id = checkOverLength(new_id);
        
        //seventh
        new_id = checkUnderLength(new_id);
        
        answer = new_id;
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new kakao2021b_check().solution("123_.def"));
	}

}
