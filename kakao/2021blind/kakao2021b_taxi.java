public class kakao2021b_taxi {
	int[][] map;
	int INF = Integer.MAX_VALUE;
	public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        map = new int[n+1][n+1];
        for(int i=1;i<=n;++i) {
        	for(int j=1;j<=n;++j) {
        		map[i][j] = INF;
        		if(i==j) {
        			map[i][j] = 0;
        		}
        	}
        }
        for(int i=0;i<fares.length;++i) {
        	map[fares[i][0]][fares[i][1]] = fares[i][2];
        	map[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
                    if(map[j][i] == INF || map[i][k] == INF)continue;
					if(map[j][k] > map[j][i] + map[i][k])
						map[j][k] = map[j][i] + map[i][k];
				}
			}
		}
        for(int i=1;i<=n;++i) {
        	answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new kakao2021b_taxi().solution(6,4,5,6,new int[][] {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}}));
	}

}
