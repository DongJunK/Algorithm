import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {
	static char[][] pairBracket = {{'{','}'},{'(',')'},{'[',']'},{'<','>'}};
	static boolean checkBracket(char pre, char now) {
		for(int i=0;i<4;++i) {
			if(pairBracket[i][0] == pre && pairBracket[i][1] == now)
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;++t) {
			String bracket = br.readLine();
			Stack<Character> bracketStack = new Stack<Character>();
			int result = 1;
			for(int i=0;i<bracket.length();++i) {
				char nowBracket = bracket.charAt(i);
				boolean flag = false;
				for(int j=0;j<4;++j) {
					if(nowBracket == pairBracket[j][0]){
						flag = true;
						bracketStack.push(nowBracket);
						break;
					}
				}
				if(!flag) {
					char preBracket = bracketStack.pop();
					if(!checkBracket(preBracket,nowBracket)) {
						result = 0;
						break;
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(result);
			System.out.println(sb.toString());
			
		}
	}

}