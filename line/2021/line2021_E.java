public class line2021_E {
	int idx = 0;
	int[] cards;
	int answer;
	public void start() {
		
		int playerSum = 0;
		int dealerSum = 0;
		try {
			int card = 0;
			if(cards[idx]==1) {
				card = 11;
				++idx;
			}else {
				card = cards[idx++];
			}
			playerSum = card;
			if(cards[idx]==1) {
				card = 11;
				++idx;
			}else {
				card = cards[idx++];
			}
			dealerSum = card;
			
			if(cards[idx]==1 && playerSum + 11 <=21) {
				card = 11;
				++idx;
			}else {
				card = cards[idx++];
			}
			playerSum += card;
			
			if(cards[idx]==1 && dealerSum + 11 <= 21) {
				card = 11;
				++idx;
			}else {
				card = cards[idx++];
			}
			dealerSum += card;
			int dealerOpen = card;
			if(playerSum == 21) {
				if(dealerSum == 21) {
					return;
				}else {
					answer += 3;
					return;
				}
			}

			if( dealerOpen == 1 || dealerOpen == 11 || 7<=dealerOpen) {
				while(true) {
					if(17<=playerSum) break;
					if(cards[idx] == 1 && playerSum+11<=21) {
						playerSum += 11;
						continue;
					}
					playerSum += cards[idx++];
				}
				
			}else if(dealerOpen == 2 || dealerOpen == 3) {
				while(true) {
					if(12<=playerSum) break;
					if(cards[idx] == 1 && playerSum+11<=21) {
						playerSum += 11;
						continue;
					}
					playerSum += cards[idx++];
				}
			}
			if(21<playerSum) {
				answer -=2;
				return;
			}
			while(true) {
				if(17<=dealerSum)break;
				if(cards[idx] == 1 && dealerSum+11<=21) {
					dealerSum += 11;
					continue;
				}
				dealerSum += cards[idx++];
			}
			if(21<dealerSum) {
				answer +=2;
			}else if(dealerSum<playerSum){
				answer +=2;
			}else {
				answer -=2;
			}
		}catch(Exception e) {
			return;
		}
	}
	public int solution(int[] cards) {
        answer = 0;
        this.cards = cards;
        for(int i=0;i<cards.length;++i) {
        	if(10<cards[i]) {
        		cards[i] = 10;
        	}
        }
        while(idx<cards.length) {
        	start();
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new line2021_E().solution(new int[] {1, 4, 10, 6, 9, 1, 8, 13}));
	}

}
