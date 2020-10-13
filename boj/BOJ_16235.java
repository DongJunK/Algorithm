import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ_16235{
    static int n,treeN,year;
    static int[][] map;
    static int[][] yangbun;
    static PriorityQueue<Tree> treeQ;
    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    static int[] dy = {-1,-1,-1,0,1,1,1,0};
    static boolean checkRange(int y,int x){
        return 0<y&&y<=n&&0<x&&x<=n;
    }

    static void afterYear(){
        PriorityQueue<Tree> pq = new PriorityQueue<Tree>();
        List<int[]> deadList = new ArrayList<int[]>();
        //spring
        while(!treeQ.isEmpty()){
            Tree tree = treeQ.poll();
            int x = tree.x;
            int y = tree.y;
            int age = tree.age;
            if(map[y][x] < age){
                deadList.add(new int[]{y,x,age/2});
            }else{
                map[y][x] -= age;
                ++tree.age;
                pq.offer(tree);
            }
        }
        treeQ = pq;
        
        //summer
        for(int i = 0;i<deadList.size();++i){
            int y = deadList.get(i)[0];
            int x = deadList.get(i)[1];
            int yang = deadList.get(i)[2];
            map[y][x] += yang;
        }
        List<Tree> treeList = new ArrayList<Tree>();
        //fall
        for(Tree tree : treeQ){
            
            if(tree.age%5 == 0){
                for(int j=0;j<8;++j){
                    int nX = tree.x + dx[j];
                    int nY = tree.y + dy[j];
                    if(checkRange(nY, nX)){
                        treeList.add(new Tree(nX,nY,1));
                    }
                }
            }
        }
        for(int i=0;i<treeList.size();++i){
            treeQ.offer(treeList.get(i));
        }

        //winter
        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                map[i][j] += yangbun[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        treeN = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        yangbun = new int[n+1][n+1];

        treeQ = new PriorityQueue<Tree>();
        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                map[i][j] = 5;
            }
        }
        for(int i=1;i<=n;++i){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;++j){
                yangbun[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<treeN;++i){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            treeQ.offer(new Tree(x,y,age));
        }
        while(0<year--){
            afterYear();
        }
        System.out.println(treeQ.size());
    }

    static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;
        public Tree(int x, int y, int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}