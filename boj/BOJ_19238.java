import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_19238 {
    static int n, client, fuel, taxiX, taxiY;
    static List<Client> clientList;
    static int[][] map;
    static int[][] d;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean checkRange(int y, int x){
        return 0<x&&x<=n&&0<y&&y<=n;
    }
    static void getMinDistClient(){
        d = new int[n+1][n+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{taxiY,taxiX});
        d[taxiY][taxiX] = 0;
        while(!q.isEmpty()){
            int nowY = q.peek()[0];
            int nowX = q.poll()[1];
            for(int i=0;i<4;++i){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                if(checkRange(nextY, nextX) && d[nextY][nextX] == 0 && map[nextY][nextX] != 1 && (nextY != taxiY || nextX != taxiX)){
                    d[nextY][nextX] = d[nowY][nowX] + 1;
                    q.offer(new int[]{nextY, nextX});
                }
            }
        }
        for(int i=0;i<clientList.size();++i){
            int nY = clientList.get(i).sY;
            int nX = clientList.get(i).sX;
            if(d[nY][nX] == 0 && (nY != taxiY || nX != taxiX) ){
                clientList.get(i).dist = Integer.MAX_VALUE;
            }else {
            	clientList.get(i).dist = d[nY][nX];
            }
        }
    }
    static int getMinDistClient(int y, int x){
        d = new int[n+1][n+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{taxiY,taxiX});
        while(!q.isEmpty()){
            int nowY = q.peek()[0];
            int nowX = q.poll()[1];
            if(nowY == y && nowX == x){
                return d[y][x];
            }
            for(int i=0;i<4;++i){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                if(checkRange(nextY, nextX) && d[nextY][nextX] == 0 && map[nextY][nextX] != 1){
                    d[nextY][nextX] = d[nowY][nowX] + 1;
                    q.offer(new int[]{nextY, nextX});
                }
            }
        }
        return -1;
    }

    static void run(){
        while(!clientList.isEmpty()){
            getMinDistClient();
            Collections.sort(clientList);
            Client nowClient = clientList.get(0);
            int nowDist = nowClient.dist;
            if(fuel<nowDist || nowDist == Integer.MAX_VALUE){
                fuel = -1;
                return;
            }else{
                fuel -= nowDist;
                taxiY = nowClient.sY;
                taxiX = nowClient.sX;
            }
            
            int aimY = nowClient.eY;
            int aimX = nowClient.eX;
            int arriveDist = getMinDistClient(aimY, aimX);
            if(fuel<arriveDist || arriveDist == -1){
                fuel = -1;
                return;
            }else{
                taxiY = aimY;
                taxiX = aimX;
                fuel += arriveDist;
            }
            clientList.remove(nowClient);
        }
    }
    static class Client implements Comparable<Client>{
        int sX,sY,eX,eY, dist;
        public Client(int sY,int sX, int eY, int eX){
            this.sX = sX;
            this.sY = sY;
            this.eX = eX;
            this.eY = eY;
        }
		@Override
		public int compareTo(Client o) {
            if(o.dist<this.dist){
                return 1;
            }else if(this.dist == o.dist){
                if(o.sY<this.sY){
                    return 1;
                }else if(o.sY == this.sY && o.sX < this.sX){
                    return 1;
                }
            }
            return -1;
		}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        client = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        clientList = new ArrayList<Client>();
        for(int i=1;i<=n;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        taxiY = Integer.parseInt(st.nextToken());
        taxiX = Integer.parseInt(st.nextToken());
        for(int i=0;i<client;++i){
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int aimY = Integer.parseInt(st.nextToken());
            int aimX = Integer.parseInt(st.nextToken());
            clientList.add(new Client(startY,startX,aimY,aimX));
        }
        run();
        System.out.println(fuel);
    }
}