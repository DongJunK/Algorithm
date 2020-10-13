import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class im꽃나라반 {
    static String n;
    static int cardSetN;
    static int[] cardSet;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;++t){
            n = br.readLine();
            cardSetN = 0;
            cardSet = new int[9];
    
            for(int i=0;i<n.length();++i){
                int nowNum = n.charAt(i)-'0';
                if(nowNum == 9){
                    if(0<cardSet[6]){
                        --cardSet[6];
                    }else{
                        buyCard();
                        --cardSet[6];
                    }
                }else if(0<cardSet[nowNum]){
                    --cardSet[nowNum];
                }else{
                    buyCard();
                    --cardSet[nowNum];
                }
            }
            System.out.println("#"+t+" "+cardSetN);
        }
    }
    static void buyCard(){
        ++cardSetN;
        for(int i=0;i<9;++i){
            ++cardSet[i];
        }
        ++cardSet[6];
    }
}