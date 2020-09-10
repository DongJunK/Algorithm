import java.util.*;
public class BOJ_5585 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int m = 1000-sc.nextInt();
		int cnt=0;
		int a[]={500,100,50,10,5,1};
		
		for(int i=0;m!=0;i++){
                cnt+=m/a[i];
                m-=a[i]*(m/a[i]);
        }
        System.out.println(cnt);
    }
}