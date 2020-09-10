import java.util.Arrays;

public class kakao2019b_failrate {
	public int[] solution(int N, int[] stages) {
        int[] answer = {};
        Stage[] stage = new Stage[N+1];
        stage[0] = new Stage(0);
        stage[0].failRate = -1;
        for(int i=1;i<=N;++i) {
        	stage[i] = new Stage(i);
        }
        for(int i=0;i<stages.length;++i) {

        	if(stages[i] == N+1) {
        		for(int j=1;j<stages[i];++j) {
            		++stage[j].playUser;
            	}
        		continue;
        	}
        	for(int j=1;j<=stages[i];++j) {
        		++stage[j].playUser;
        	}
        	++stage[stages[i]].leftover;
        }
        for(int i=1;i<stage.length;++i) {
        	if(stage[i].playUser == 0 || stage[i].leftover == 0) {
        		stage[i].failRate = 0;
        	}else {
        		stage[i].failRate = (double)stage[i].leftover/stage[i].playUser;
        	}
        }
        Arrays.sort(stage);
        answer = new int[N];
        for(int i=0;i<stage.length-1;++i) {
        	answer[i] = stage[i].number;
        }
        return answer;
    }
	class Stage implements Comparable<Stage>{
		int number;
		int playUser;
		int leftover;
		double failRate;
		
		Stage(int number) {
			this.number = number;
			playUser = 0;
			leftover = 0;
		}
		@Override
		public int compareTo(Stage o) {
			// TODO Auto-generated method stub
			if(o.failRate == this.failRate) {
				return this.number - o.number;
			}else if(this.failRate < o.failRate) {
					return 1;
			}	
			return -1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new kakao2019b_failrate().solution(4,new int[]{4,4,4,4,4})));
	}

}
