import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class BOJ_19235 {
    static boolean[][] g;
    static boolean[][] b;
    static void pushBlock(int num, boolean[][] map, boolean[][] block,int pos){
        int nowy = 0;
        int nowx = pos;
        while(true){
            if(nowy==5){
                nowy = 4;

                break;
            }
            boolean flag = false;
            outer:for(int i=0;i<2;++i){
                for(int j=0;j<2;++j){
                    flag = map[nowy+i][nowx+j] & block[i][j];
                    if(flag) break outer;
                }
            }
            if(flag){
                --nowy;
                for(int i=0;i<2;++i){
                    for(int j=0;j<2;++j){
                        map[nowy+i][nowx+j] = block[i][j];
                    }
                }
            }
        }
    }
    static void print(boolean[][] map, String name){
        System.out.println(name);
        for(int i=0;i<map.length;++i){
            for(int j=0;j<map[i].length;++j){
                System.out.print(map[i][j]+ " ");
            }System.out.println();
        }System.out.println();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        g = new boolean[6][4];
        b = new boolean[6][4];
        for(int t=0;t<n;++t){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            boolean[][] gblock = new boolean[2][2];
            boolean[][] bblock = new boolean[2][2];
            gblock[0][0] = true;
            switch(num){
                case 1:
                    gblock[0][0] = false;
                    gblock[1][0] = true;
                    break;
                case 2:
                    gblock[0][1] = true;
                    break;
                case 3:
                    gblock[1][0] = true;
                    break;
            }
            if(num != 1){
                for(int i=0;i<2;++i){
                    for(int j=0;j<2;++j){
                        bblock[i][j] = gblock[j][i];
                    }
                }
            }else{
                bblock[1][1] = true;
            }
            

            pushBlock(num, g, gblock, x);
            pushBlock(num, b, bblock, y);
            print(g, "g");
            print(b, "b");
        }
        
    }
}
