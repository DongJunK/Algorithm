import java.util.Scanner;

public class SWEA_5215{
	static int T;
	static int N,L;
	static int arr[][];
	static int number[];
	static int answer;
	static boolean isSelected[];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        
		for(int tc=1;tc<=T;tc++) {
            N = sc.nextInt();//재료의수
            L = sc.nextInt();//칼로리제한
            number = new int[N];
            arr = new int [N][2];
            for(int i=0;i<N;i++) {
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            answer = Integer.MIN_VALUE;
            subset(0,0,0);
            System.out.println("#"+tc+" "+answer);
        }
    }
	
    private static void subset(int idx, int k, int score) {
        if(idx==N) {
            if(k<=L) {
                answer = Math.max(answer, score);
            }
            return;
        }
        subset(idx+1,k + arr[idx][1],score+arr[idx][0]);
        subset(idx+1,k,score);
    }
}