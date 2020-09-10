import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class SWEA_1228 {
	static ArrayList<String> makePostfix(String formula) {
		ArrayList<String> form = new ArrayList<String>();
		Stack<String> oper = new Stack<String>();
		for(int i=0;i<formula.length();++i) {
			char now = formula.charAt(i);
			if(now == '*' || now == '+') {
				if(oper.isEmpty()) {
					oper.push(Character.toString(now));
				}
				else if(now == '*') {
					oper.push("*");
				}else {
					while(!oper.isEmpty()) {
						form.add(oper.pop());
					}
					oper.push(Character.toString(now));
				}
			}
			else {
				form.add(Character.toString(now));
				
			}
		}
		while(!oper.isEmpty()) {
			form.add(oper.pop());
		}
		return form;
	}
	static int calc(String str) {
		ArrayList<String> postfix = makePostfix(str);
		Stack<Integer> num = new Stack<Integer>();
		for(int i=0;i<postfix.size();++i) {
			String now = postfix.get(i);
			if(now.equals("*") || now.equals("+")) {
				int value1 = num.pop();
				int value2 = num.pop();
				if(now.equals("*")) {
					num.push(value1 * value2);
				}else {
					num.push(value1+value2);
				}
			}else {
				num.push(Integer.parseInt(now));
			}
		}
		
		return num.pop();
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;++t) {
			br.readLine();
			int answer = calc(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
}