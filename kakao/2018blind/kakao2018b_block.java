public class kakao2018b_block {
	int height;
	int width;
	int[] dx = {1,0,1};
	int[] dy = {0,1,1};
	boolean[][] visit;
	char[][] map;
	public void removeBlock() {
		for(int i=0;i<height;++i) {
			for(int j=0;j<width;++j) {
				if(visit[i][j]) {
					map[i][j] = ' ';
				}
			}
		}
	}
	public void down() {
		for(int i=0;i<width;++i) {
			for(int j=height-1;0<=j;--j) {
				if(map[j][i] ==' ') {
					for(int k=j-1;0<=k;--k) {
						if(map[k][i] != ' ') {
							map[j][i] = map[k][i];
							map[k][i] = ' ';
							break;
						}
					}
				}
			}
		}
	}
	public boolean check() {
		boolean result = false;
		for(int i=0;i<height-1;++i) {
			for(int j=0;j<width-1;++j) {
				boolean flag=true;
				if(map[i][j] ==' ')continue;
				for(int k=0;k<3;++k) {
					int checkX = j + dx[k];
					int checkY = i + dy[k];
					if(map[i][j] != map[checkY][checkX]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					visit[i][j] = true;
					for(int k=0;k<3;++k) {
						int checkX = j + dx[k];
						int checkY = i + dy[k];
						visit[checkY][checkX] = true;
					}
					result = true;
				}
			}
		}
		if(result) {
			removeBlock();
			down();
		}
		return result;
	}
	public int solution(int m, int n, String[] board) {
        int answer = 0;
        height = m;
        width = n;
        map = new char[height][width];
        for(int i=0;i<height;++i) {
        	for(int j=0;j<width;++j) {
        		map[i][j] = board[i].charAt(j);
        	}
        }
        do {
        	visit = new boolean[height][width];
        	
        }while(check());
        
        for(int i=0;i<height;++i) {
        	for(int j=0;j<width;++j) {
        		if(map[i][j] == ' ') {
        			++answer;
        		}
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(new kakao2018b_block().solution(4, 5, input1));
	}
}
