import java.util.Arrays;

public class line2021_C {
	public int[] solution(int n) {
        int[] answer = new int[2];
        String num = "";
        int cnt = 0;
        while(n/10 != 0) {
        	num = Integer.toString(n);
        	System.out.println(n);
        	int now = num.length()/2;
        	int firstNum = 0;
        	int secondNum = 0;
        	if(num.charAt(now)=='0') {
        		int start=now;
        		
        		while(start<=num.length()&&num.charAt(start++)=='0') {}
        		--start;
        		if(start==num.length()) {
        			secondNum = Integer.parseInt(num)/10;
        		}else {
        			secondNum = Integer.parseInt(num.substring(0,start)) + Integer.parseInt(num.substring(start,num.length()));
        		}
        		start = now;
        		while(0<start&&num.charAt(start--)=='0') {}
        		
        		if(start==0) {
        			n = secondNum;
        		}else {
        			firstNum = Integer.parseInt(num.substring(0,start)) + Integer.parseInt(num.substring(start,num.length()));
        			if(firstNum<secondNum) {
        				n = firstNum;
        			}else {
        				n = secondNum;
        			}
        		}
        	}else {
        		firstNum = Integer.parseInt(num.substring(0,now)) + Integer.parseInt(num.substring(now,num.length()));
            	
            	if(num.length()%2==0) {
            		n = firstNum;
            	}else {
            		secondNum = Integer.parseInt(num.substring(0,now+1))+Integer.parseInt(num.substring(now+1,num.length()));
                	if(firstNum<secondNum) {
                		n = firstNum;
                	}else {
                		n = secondNum;
                	}
            	}
        	}
        	++cnt;
        }
        answer[0] = cnt;
        answer[1] = n;
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new line2021_C().solution(10007)));
	}

}
