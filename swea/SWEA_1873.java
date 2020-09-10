import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	static int height;
	static int width;
	static char[][] map;
	static String command;
	static int commandN;
	static int nowY = -1;
	static int nowX = -1;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		for(int t=1;t<=TC;++t) {
			st = new StringTokenizer(br.readLine());
			nowY = -1;
			nowX = -1;
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			map = new char[height][width];
			
			for(int i=0;i<height;++i) {
				map[i] = br.readLine().toCharArray();
				
				for(int j=0;j<width;++j) {
					if(nowY != -1) break;
					
					if(map[i][j] != '*' && map[i][j] != '#' && map[i][j] != '.'&&map[i][j] != '-') {
						nowY = i;
						nowX = j;
					}
				}
			}
			commandN = Integer.parseInt(br.readLine());
			command = br.readLine();
			
			run();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for(int i=0;i<height;++i) {
				for(int j=0;j<width;++j) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb.toString());
		}
		
		
		
	}
	static boolean check_range(int x, int y) {
		return 0<=x&&x<width&&0<=y&&y<height;
	}
	static void shoot() {
		int direction = 0;
		
		switch(map[nowY][nowX]){
			case '<':
				direction = 1;
				break;
			case '>':
				direction = 0;
				break;
			case '^':
				direction = 2;
				break;
			case 'v':
				direction = 3;
				break;
		}
		int nextX = nowX + dx[direction];
		int nextY = nowY + dy[direction];
		while(true) {
			if(!check_range(nextX,nextY)) break;
			else if(map[nextY][nextX] == '#') {
				break;
			}
			else if(map[nextY][nextX] == '*') {
				map[nextY][nextX] = '.';
				break;
			}
			
			nextX += dx[direction];
			nextY += dy[direction];
		}
	}
	static void moveTank(int direction) {
		int nextX = nowX + dx[direction];
		int nextY = nowY + dy[direction];
		
		if(!check_range(nextX,nextY) || map[nextY][nextX] != '.') return;
		map[nextY][nextX] = map[nowY][nowX];
		map[nowY][nowX] = '.';
		nowX = nextX;
		nowY = nextY;
	}
	static void controlTank(int commandIdx) {
		switch(command.charAt(commandIdx)) {
		case 'S':
			shoot();
			break;
		case 'U':
			map[nowY][nowX] = '^';
			moveTank(2);
			break;
		case 'D':
			map[nowY][nowX] = 'v';
			moveTank(3);
			break;
		case 'R':
			map[nowY][nowX] = '>';
			moveTank(0);
			break;
		case 'L':
			map[nowY][nowX] = '<';
			moveTank(1);
			break;
		}
	}
	
	static void run() {
		for(int i=0;i<commandN;++i) {
			controlTank(i);
		}
	}
}
