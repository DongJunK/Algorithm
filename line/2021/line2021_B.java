import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class line2021_B {
	public int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        Deque<Integer> dq = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<ball.length;++i) {
        	dq.offer(ball[i]);
        }
        int idx = 0;
        for(int i=0;i<order.length;++i) {
        	if(order[i] == dq.peekFirst()) {
        		answer[idx++] = dq.pollFirst();
        		while(set.contains(dq.peekFirst())) {
        			answer[idx++] = dq.peekFirst();
        			set.remove(dq.pollFirst());
        			
        		}
        	}else if(order[i] == dq.peekLast()) {
        		answer[idx++] = dq.pollLast();
        		while(set.contains(dq.peekLast())) {
        			answer[idx++] = dq.peekLast();
        			set.remove(dq.pollLast());
        		}
        	}else {
        		set.add(order[i]);
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
