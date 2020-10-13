import java.util.Arrays;
import java.util.Comparator;
public class camera {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,new Comparator<int[]>(){
            @Override
            public int compare(int[] t1, int[] t2){
                return t1[1] - t2[1];
            }
        });

        for(int i=0;i<routes.length;++i){
            ++answer;
            int now = i;
            for(int j=now+1;j<routes.length;++j){
                if(routes[j][0]<=routes[now][1]){
                    ++i;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new camera().solution(new int[][]{{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}));
    }
}
