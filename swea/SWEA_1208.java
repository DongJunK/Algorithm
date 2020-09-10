import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208 {
	int dumpN;
	int map[] = new int[100];
	
	void solve() {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;++t) {
			dumpN = sc.nextInt();
			for(int i=0;i<100;++i) {
				map[i] = sc.nextInt();
			}

			for(int i =0;i<dumpN;++i) {
				Arrays.sort(map);
				if(map[99]-map[0]<=1) break;
				boolean min_flag = false;
				int min_idx = 0;
				boolean max_flag = false;
				int max_idx = 99;
				for(int j=0;j<100;++j) {
					if(map[j]<100) {
						min_idx = j;
						min_flag = true;
						break;
					}
				}
				for(int j=99;0<=j;--j) {
					if(0<map[j]) {
						max_idx = j;
						max_flag = true;
						break;
					}
					
				}
				if(min_flag && max_flag) {
					++map[min_idx];
					--map[max_idx];
				}
			}
			Arrays.sort(map);
			int result = map[map.length-1]-map[0];
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SWEA_1208().solve();
	}
}