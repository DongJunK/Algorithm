import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static int[] dx = {1,0,1};
    static int[] dy = {0,1,1};
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
    }
}
