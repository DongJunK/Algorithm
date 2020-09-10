import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SWEA_2382 {
    static int N;
    static int time;
    static int asN;
    static int[] dx = {0,0,0,-1,1};
    static int[] dy = {0,-1,1,0,0};
    static int[][] map;
    static ArrayList<Asso> al;
    static boolean checkRange(int x, int y) {
        return 0<x&&x<N-1&&0<y&&y<N-1;
    }
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            asN = Integer.parseInt(st.nextToken());
            al = new ArrayList<Asso>();
             
            for(int i=0;i<asN;++i) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                al.add(new Asso(x,y,d,num));
            }
             
            while(0<time--) {
                map = new int[N][N];
                for(int i=0;i<N;++i) {
                    Arrays.fill(map[i], -1);
                }
                for(int i=0;i<al.size();++i) {
                    Asso next = al.get(i);
                    int nX = next.x + dx[next.d];
                    int nY = next.y + dy[next.d];
                    if(!checkRange(nX,nY)) {
                        next.num /=2;
                        if(next.num != 0){
                            next.d = next.d==1?2:next.d==2?1:next.d==3?4:3;
                            next.x = nX;
                            next.y = nY;
                        }
                        continue;
                    }
                     
                    if(map[nY][nX]==-1) {
                        next.x = nX;
                        next.y = nY;
                        map[nY][nX] = i;
                    }else if(al.get(map[nY][nX]).num<next.num){
                        Asso asso = al.get(map[nY][nX]);
                        asso.addNum += asso.num;
                        asso.num = next.num;
                        asso.d = next.d;
                        next.num = 0;
                    }else if(next.num<al.get(map[nY][nX]).num) {
                        Asso asso = al.get(map[nY][nX]);
                        asso.addNum += next.num;
                        next.num = 0;
                    }
                }
                 
                for(int i=0;i<al.size();++i) {
                    if(al.get(i).num == 0) {
                        al.remove(i--);
                        continue;
                    }
                    Asso now = al.get(i);
                    now.num += now.addNum;
                    now.addNum = 0;
                }
            }
            int answer = 0;
            for(int i=0;i<al.size();++i) {
                answer += al.get(i).num;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb.toString());
        }
    }
    static class Asso{
        int x;
        int y;
        int d;
        int num;
        int addNum;
        public Asso(int x, int y, int d, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.num = num;
            this.addNum = 0;
        }
    }
}