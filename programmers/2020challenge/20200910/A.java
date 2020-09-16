import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class A {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<numbers.length-1;++i){
            for(int j=i+1;j<numbers.length;++j){
                set.add(numbers[i]+numbers[j]);
            }
        }
        answer = new int[set.size()];
        int idx = 0;
        for(int item:set){
            answer[idx++] = item;
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println();
    }
}