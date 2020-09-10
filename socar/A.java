
public class A {
	static int N;
	boolean checkBottom(int y) {
		return y==N;
	}
	boolean down(String[] drum, int x) {
		int y = 0;
		boolean starFlag = false;
		while(true) {
			if(checkBottom(y)) {
				return true;
			}
			switch(drum[y].charAt(x)) {
			case '#':
				++y;
				break;
			case '*':
				if(starFlag) {
					return false;
				}else {
					starFlag = true;
					++y;
				}
				break;
			case '>':
				++x;
				break;
			case '<':
				--x;
				break;
			}
		}
	}
	int solution(String[] drum) {
		int answer = 0;
		N = drum.length;
		for(int i=0;i<N;++i) {
			if(down(drum,i)) {
				++answer;
			}
				
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] drum = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
		int answer = new A().solution(drum);
		System.out.println(answer);
	}

}
