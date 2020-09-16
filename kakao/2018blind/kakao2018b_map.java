public class kakao2018b_map {
	public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        String zero = "";
        for(int i=0;i<arr1.length;++i) zero += "0";
        for(int i=0;i<arr1.length;++i) {
        	answer[i] = "";
        	String bn1 = Integer.toBinaryString(arr1[i]);
        	String bn2 = Integer.toBinaryString(arr2[i]);
        	bn1 = bn1.length() == arr1.length ? bn1:zero.substring(0,arr1.length-bn1.length())+bn1;
        	bn2 = bn2.length() == arr2.length ? bn2:zero.substring(0,arr2.length-bn2.length())+bn2;
        	for(int j=0;j<bn1.length();++j) {
        		if(((bn1.charAt(j)-'0')|(bn2.charAt(j)-'0')) == 0) {
            		answer[i] += " ";
            	}else {
            		answer[i] += "#";
            	}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}