import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_19236{
    static int[][][] map = new int[4][4][2];
    static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
    static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
    static int[][] pos;
    static int answer;
    static boolean checkRange(int y,int x){
        return 0<=y&&y<4&&0<=x&&x<4;
    }

    static void moveFish(){
        for(int i=1;i<17;++i){
            if(pos[i][0] == -1) continue;
            int y = pos[i][0];
            int x = pos[i][1];
            int d = map[y][x][1];
            int tmpD = d;
            while(true){
                int nY = y + dy[d];
                int nX = x + dx[d];
                if(!checkRange(nY, nX)|| map[nY][nX][0] == 0){
                    if(map[y][x][1] == 8){
                        map[y][x][1] = 1;
                        d = 1;
                    }else{
                        ++map[y][x][1];
                        ++d;
                    }
                    if(tmpD == d) break;
                }else{
                    // 현재값 저장
                    int tmpFishNum = map[y][x][0];
                    int tmpDirection =  map[y][x][1];
                    // 이동할꺼 현재에 저장
                    map[y][x][0] = map[nY][nX][0]; 
                    map[y][x][1] = map[nY][nX][1];

                    // 이동할꺼에 현재꺼 저장
                    map[nY][nX][0] = tmpFishNum;
                    map[nY][nX][1] = tmpDirection;

                    if(map[y][x][0] != -1){
                        //바뀐 현재 위치에 있는 정보 현재 위치 값으로 저장
                        pos[map[y][x][0]][0] = y;
                        pos[map[y][x][0]][1] = x;
                    }

                    // 바꾼 애 위치를 다음 위치로 저장
                    pos[i][0] = nY;
                    pos[i][1] = nX;
                    break;
                }
            }
        }
    }

    static void copyMap(int[][][] a, int[][][] b){
        for(int i=0;i<4;++i){
            for(int j=0;j<4;++j){
                for(int k=0;k<2;++k){
                    a[i][j][k] = b[i][j][k];
                }
            }
        }
    }
    static void copyPos(int[][] a, int[][] b){
        for(int i=0;i<17;++i){
            for(int j=0;j<2;++j){
                a[i][j] = b[i][j];
            }
        }
    }

    static void dfs(int ans){
        moveFish();
        int[][][] tmpMap = new int[4][4][2];
        int[][] tmpPos = new int[17][2];
        copyMap(tmpMap, map);
        copyPos(tmpPos, pos);

        int nowY = pos[0][0];
        int nowX = pos[0][1];
        int nowD = map[nowY][nowX][1];
        List<int[]> list = new ArrayList<int[]>();
        while(true){
            int nextY = nowY + dy[nowD];
            int nextX = nowX + dx[nowD];
            if(!checkRange(nextY, nextX))break;

            if(map[nextY][nextX][0] != -1){
                list.add(new int[]{nextY,nextX});
            }
            nowY = nextY;
            nowX = nextX;
        }

        if(list.isEmpty()){
            answer = Math.max(answer, ans);
            return;
        }

        for(int i=0;i<list.size();++i){
            int value = map[list.get(i)[0]][list.get(i)[1]][0];
            pos[map[list.get(i)[0]][list.get(i)[1]][0]][0] = -1;
            map[pos[0][0]][pos[0][1]][0] = -1;
            map[list.get(i)[0]][list.get(i)[1]][0] = 0;
            pos[0][0] = list.get(i)[0];
            pos[0][1] = list.get(i)[1];
            
            dfs(ans+value);
            copyMap(map,tmpMap);
            copyPos(pos,tmpPos);
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        pos = new int[17][2];
        answer = 0;
        for(int i=0;i<4;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;++j){
                map[i][j][0] = Integer.parseInt(st.nextToken());
                map[i][j][1] = Integer.parseInt(st.nextToken());
                pos[map[i][j][0]][0] = i;
                pos[map[i][j][0]][1] = j;
            }
        }
        pos[0][0] = 0;
        pos[0][1] = 0;
        answer = map[0][0][0];
        pos[map[0][0][0]][0] = -1;
        map[0][0][0] = 0;
        
        dfs(answer);
        
        System.out.println(answer);
    }
}