import java.util.Arrays;

public class B {
    int[] answer = {};
    int getLevel(int n){
        int level = 1;
        int value = 0;
        outer:while(true){
            for(int i=0;i<level;++i){
                if(value == n){
                    break outer;
                }
                ++value;
            }
            ++level;
        }
        return level;
    }
    void dq(int n, int idx, int value){
        if(n <= 0) return;
        if(n == 1){
            answer[idx] = value;
            return;
        }
        int cnt = n;
        int level = getLevel(idx);
        for(int i=0;i<cnt;++i){
            answer[idx] = value++;
            idx += level++;
        }
        idx -= --level;
        --cnt;
        for(int i=0;i<cnt;++i){
            answer[++idx] = value++;
        }
        --cnt;
        for(int i=0;i<cnt;++i){
            idx -= level--;
            answer[idx] = value++;
        }
        dq(n-3,idx+level,value);
    }
    public int[] solution(int n) {
        answer = new int[(n*(n+1))/2];
        dq(n,0,1);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new B().solution(4)));
    }
}
