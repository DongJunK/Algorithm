import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7272 {
	
	static int checkHall(char ch) {
		int result = 0;
		switch(ch) {
		case 'B':
			result = 2;
			break;
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
			result = 1;
			break;
		default:
			result = 0;
		}
		return result;
	}

	static boolean checkAlpha(String str, String compareStr) {
		if(str.length() != compareStr.length()) return false;
		
		for(int i=0;i<str.length();++i) {
			if(checkHall(str.charAt(i)) != checkHall(compareStr.charAt(i))) return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean result = checkAlpha(st.nextToken(),st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			if(result) sb.append("SAME");
			else sb.append("DIFF");
			
			System.out.println(sb.toString());
		}
	}

}
