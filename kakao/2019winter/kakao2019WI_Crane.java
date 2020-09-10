import java.util.Stack;

public class kakao2019WI_Crane {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<moves.length;++i) {
        	int now = moves[i]-1;
        	int item = 0;
        	for(int j=0;j<board.length;++j) {
    			if(board[j][now] != 0) {
    				item = board[j][now];
    				board[j][now] = 0;
    				break;
    			}
    		}
        	if(item != 0) {
        		if(!s.isEmpty()&&s.peek() == item) {
        			s.pop();
        			answer+=2;
        			continue;
        		}
        		s.push(item);
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(new kakao2019WI_Crane().solution(board, moves));
	}
}
