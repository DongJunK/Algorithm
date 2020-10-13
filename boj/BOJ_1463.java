import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] DP = new int[1000001];
        DP[1] = 0;
        DP[2] = 1;
        DP[3] = 1;
        for(int i=4;i<=n;++i){
            if(i%3 == 0 && DP[i/3] < DP[i-1]){
                DP[i] = DP[i/3] + 1;
            }else if(i%2 == 0 && DP[i/2] < DP[i-1]){
                DP[i] = DP[i/2] + 1;
            }else{
                DP[i] = DP[i-1] + 1;
            }
        }
        System.out.println(DP[n]);
    }
}
