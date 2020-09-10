import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class SWEA_5648 {
    static int[][] map;
    static List<Ball> ballInfo;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int answer;
    static int N;
    static boolean checkRange(int x, int y) {
        return 0<=x&&x<=4000&&0<=y&&y<=4000;
    }
 
     
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
         
        for(int t=1;t<=TC;++t) {
            N = Integer.parseInt(br.readLine());
            ballInfo = new ArrayList<Ball>();
            for(int i = 0;i<N;++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())*2 + 2000;
                int y = Integer.parseInt(st.nextToken())*2 + 2000;
                int d = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                 
                ballInfo.add(new Ball(x,y,d,score));
            }
             
 
            map = new int[4001][4001];
            
            for(int i=0;i<=4000;++i) {
            	Arrays.fill(map[i], -1);
            }

            answer = 0;
            
            for(int time=0;time<=4000;++time) {
                for(int i=0;i<ballInfo.size();++i) {
                    Ball now = ballInfo.get(i);
                    int nX = now.x + dx[now.d];
                    int nY = now.y + dy[now.d];
                     
                    if(!checkRange(nX,nY)) {
                    	map[now.y][now.x] = 0;
                        ballInfo.remove(i--);
                        continue;
                    }
                    else if(map[nY][nX] == -1) {
                    	map[now.y][now.x] = 0;
                        map[nY][nX] = i;
                    }else {
                        ballInfo.get(map[nY][nX]).collision = true;
                        now.collision = true;
                    }
                    now.x = nX;
                    now.y = nY;
                     
                }
                for(int i=0;i<ballInfo.size();++i) {
                    if(ballInfo.get(i).collision) {
                        answer += ballInfo.get(i).score;
                        map[ballInfo.get(i).y][ballInfo.get(i).x] = -1;
                        ballInfo.remove(i--);
                    }
                }
            }
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb.toString());
        }
    }
    
    static class Ball{
        int x;
        int y;
        int d;
        int score;
        boolean collision;
        public Ball(int x, int y, int d, int score) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.score = score;
            this.collision = false;
        }
         
    }
}