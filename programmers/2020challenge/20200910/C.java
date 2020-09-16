public class C {
    public int solution(int[] a) {
        int answer = 0;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        leftMin[0] = a[0];
        
        for(int i=1;i<a.length;++i){
            leftMin[i] = Math.min(leftMin[i-1],a[i]);
        }
        rightMin[a.length-1] = a[a.length-1];
        for(int i=a.length-2;0<=i;--i){
            rightMin[i] = Math.min(rightMin[i+1],a[i]);
        }
        answer = 2;
        for(int i=1;i<a.length-1;++i){
            if(leftMin[i-1]<a[i] && rightMin[i+1]<a[i]){
                continue;
            }
            ++answer;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new C().solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }
}
