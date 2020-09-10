import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_7699 {
    static int height;
    static int width;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer;
    static char[][] alphabet;
    static boolean[] visit;
     
    static boolean checkRange(int x,int y) {
        return 0<=x&&x<width&&0<=y&&y<height;
    }
    static void dfs(int x,int y,int cnt) {
		answer = Math.max(answer, cnt);
        if (answer == 26) return;
        
        for(int i=0;i<4;++i) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if(!checkRange(nX,nY)||visit[alphabet[nY][nX]-'A']) continue;
            visit[alphabet[nY][nX]-'A'] = true;
            dfs(nX,nY,cnt+1);
            visit[alphabet[nY][nX]-'A'] = false;
        }
         
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;++t){
            StringTokenizer st = new StringTokenizer(br.readLine());
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            alphabet = new char[height][width];
            for(int i=0;i<height;++i) {
                String input = br.readLine();
                for(int j=0;j<width;++j) {
                    alphabet[i][j] = input.charAt(j);
                }
            }
            visit = new boolean[26];
            answer = -1;
            visit[alphabet[0][0]-'A'] = true;
            dfs(0,0,1);
            System.out.println("#"+t+" "+answer);
             
        }
    }
 
}