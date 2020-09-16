import java.util.HashSet;

public class line2021_A {
	public int solution(int[][] boxes) {
        HashSet<Integer> set = new HashSet<Integer>();
        int cnt = 0;
        for(int i=0;i<boxes.length;++i) {
        	for(int j=0;j<boxes[i].length;++j) {
        		if(!set.add(boxes[i][j])) {
        			set.remove(boxes[i][j]);
        			++cnt;
        		}
        	}
        }
        return boxes.length - cnt;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
