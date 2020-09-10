import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class SWEA_4008 {
    static int N;
    static int[] oper = {0,0,0,0};
    static int[] number;
    static long maxResult;
    static long minResult;
     
     
    static void run(int now, int result) {
        if(now == N) {
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }
        for(int i=0;i<4;++i) {
            if(oper[i]!=0) {
                --oper[i];
                 
                switch(i) {
                case 0:
                    run(now+1,result+number[now]);
                    break;
                case 1:
                    run(now+1,result-number[now]);
                    break;
                case 2:
                    run(now+1,result*number[now]);
                    break;
                case 3:
                    run(now+1,result/number[now]);
                    break;
                }
                 
                ++oper[i];
            }
        }
    }
     
     
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;++t) {
            N = Integer.parseInt(br.readLine());
            number = new int[N];
            maxResult = Long.MIN_VALUE;
            minResult = Long.MAX_VALUE;
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<4;++i) {
                oper[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;++i) {
                number[i] = Integer.parseInt(st.nextToken());
            }
             
            run(1,number[0]);
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(maxResult-minResult);
            System.out.println(sb.toString());
        }
    }
}