import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1562 {
    static int n,MOD=1000000000;
    static int[][][] DP;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        DP = new int[n+1][10][1024];

        for(int i=1;i<10;++i){
            DP[1][i][1<<i] = 1;
        }
        for(int i=2;i<=n;++i){
            for(int j=0;j<10;++j){
                for(int k=0;k<1024;++k){
                    int bit = k | (1<<j);
                    DP[i][j][bit] = (DP[i][j][bit] + ((0<j?DP[i-1][j-1][k]:0)+(j<9 ? DP[i-1][j+1][k]:0))%MOD)%MOD;
                }
            }
        }
        int result = 0;
        for(int i = 0;i<10;++i) {
            result = (result + DP[n][i][1023])%MOD;
        }
        System.out.println(result);
    }
}
