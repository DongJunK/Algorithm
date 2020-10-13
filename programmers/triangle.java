public class triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i=1;i<triangle.length;++i){
            for(int j=0;j<triangle[i].length;++j){
                if(j == 0 ){
                    triangle[i][0] += triangle[i-1][0];
                }else if(j == triangle[i].length-1){
                    triangle[i][triangle[i].length-1] += triangle[i-1][triangle[i-1].length-1];
                }else{
                    int maxValue = Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                    triangle[i][j] += maxValue;
                }
            }
        }
        for(int i=0;i<triangle[triangle.length-1].length;++i){
            answer = Math.max(answer,triangle[triangle.length-1][i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new triangle().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
