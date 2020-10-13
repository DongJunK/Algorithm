import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7236 {
    static char[][] map;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        
        for(int t=1;t<=TC;++t){
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];
            int result = 0;
            for(int i=0;i<n;++i){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;++j){
                    map[i][j] = st.nextToken().charAt(0);
                }
            }

            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    if(map[i][j] == 'W'){
                        result = Math.max(result, checkDepth(i, j));
                    }
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }
    static boolean checkRange(int y,int x){
        return 0<=y&&y<n&&0<=x&&x<n;
    }
    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};
    static int checkDepth(int y, int x){
        int checkN = 0;
        int gN = 0;
        for(int i=0;i<8;++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(checkRange(ny, nx)){
                if(map[ny][nx] == 'W') ++checkN;
                else ++gN;
            }
        }
        if(gN==8) return 1;
        return checkN;
    }
}
