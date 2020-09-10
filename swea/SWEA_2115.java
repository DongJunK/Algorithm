import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import sun.security.provider.certpath.CollectionCertStore;

public class SWEA_2115 {
	static int n;
	static int select;
	static int maxHoney;
	static int[][] map;
	static boolean[][] visit;
	static int answer;
	static List<Integer> aHoney;
	static List<Integer> bHoney;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=TC;++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			select = Integer.parseInt(st.nextToken());
			maxHoney = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			
			for(int i=0;i<n;++i) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			
			aHoney = new ArrayList<Integer>();
			bHoney = new ArrayList<Integer>();
			visit = new boolean[n][n];
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					aHoney.clear();
					
					selectHoney(j,i,0,aHoney);
					for(int k=i;k<n;++k) {
						for(int l=0;l<n;++l) {
							if(visit[k][l]||(i==k&&l<=j))continue;
							selectHoney(l,k,0,bHoney);
							calc();
							visit = new boolean[n][n];
							bHoney.clear();
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	static void combi(int idx, int honey,int sum, List<Integer> list,int type) {
		if(idx == list.size()) {
			if(type == 0) {
				aMax = Math.max(aMax, sum);
			}else {
				bMax = Math.max(bMax, sum);
			}
			
			return;
		}
		if(honey+list.get(idx)<=maxHoney) {
			combi(idx+1,honey+list.get(idx),sum+(int)Math.pow(list.get(idx), 2),list,type);
		}
		combi(idx+1,honey,sum,list,type);
	}
	static int aMax;
	static int bMax;
	static void calc() {
		aMax = 0;
		bMax = 0;
		combi(0,0,0,aHoney,0);
		combi(0,0,0,bHoney,1);
		answer = Math.max(answer, aMax+bMax);
		//System.out.println("a "+Arrays.toString(aHoney.toArray()));
		//System.out.println("b "+Arrays.toString(bHoney.toArray()));
		//System.out.println(list.size()+" "+aHoney.size()+" "+bHoney.size());
		
	}
	static boolean checkRange(int x,int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	static void selectHoney(int x, int y,int cnt,List<Integer> honey) {
		if(!checkRange(x,y)||select<=cnt||visit[y][x]) return;
		visit[y][x] = true;
		honey.add(map[y][x]);
		selectHoney(x+1,y,cnt+1,honey);
		
	}

}
