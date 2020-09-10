import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
  
public class SWEA_5656 {
    static int N;
    static int height;
    static int width;
    static int[][] map;
    static int[][] tmpMap;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer;
    static int[] list; 
    static boolean checkRange(int x,int y) {
        return 0<=x&&x<width&&0<=y&&y<height;
    }
     
    static void bfs() {
        copyMap();
        for(int p=0;p<N;++p) {
            int x = list[p];
            Queue<int[]> q = new LinkedList<int[]>();
            int top = -1;
            for(int i=0;i<height;++i) {
                if(tmpMap[i][x] != 0) {
                    top = i;
                    break;
                }
            }
            if(top == -1)return;
            q.offer(new int[] {x,top});
             
            while(!q.isEmpty()) {
                int nowX = q.peek()[0];
                int nowY = q.peek()[1];
                q.poll();
                int interval = tmpMap[nowY][nowX];
                tmpMap[nowY][nowX] = 0;
                for(int i=0;i<4;++i) {
                    int nextX = nowX;
                    int nextY = nowY;
                    for(int j=0;j<interval-1;++j) {
                        nextX += dx[i];
                        nextY += dy[i];
                        if(checkRange(nextX,nextY)&&tmpMap[nextY][nextX] != 0) {
                            q.offer(new int[] {nextX,nextY});
                        }
                    }
                }
            }
            relocation();
        }
    }
    static void relocation() {
        for(int i=0;i<width;++i) {
            for(int j=height-1;0<=j;--j) {
                if(tmpMap[j][i]==0) {
                    int k;
                    for(k=j-1;0<=k;--k) {
                        if(tmpMap[k][i] != 0) {
                            tmpMap[j][i] = tmpMap[k][i];
                            tmpMap[k][i] = 0;
                            break;
                        }
                    }
                    if(k==-1) {
                        break;
                    }
                }
            }
        }
    }
 
    static int check() {
        int result = 0;
        for(int i=0;i<height;++i) {
            for(int j=0;j<width;++j) {
                if(tmpMap[i][j] != 0) ++result;
            }
        }
        return result;
    }
     
    static void copyMap() {
        for(int i=0;i<height;++i) {
            for(int j=0;j<width;++j) {
                tmpMap[i][j] = map[i][j];
            }
        }
    }
     
    static void run(int cnt) {
        if(cnt == N) {
            bfs();
            answer = Math.min(answer,check());
            return;
        }
        for(int i=0;i<width;++i) {
            list[cnt] = i;
            run(cnt+1);
        }
    }
     
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            map = new int[height][width];
            tmpMap = new int[height][width];
            list = new int[N];
            for(int i=0;i<height;++i) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<width;++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = Integer.MAX_VALUE;
             
            run(0);
             
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb.toString());
        }
    }
}