#include <iostream>
#include <algorithm>
using namespace std;

typedef struct{
	int time;
	int pay;
}schedule;

class Company
{
	int N;
	schedule baekjoon[16];
	int maxProfit;
public:
	Company()
	{
		cin>>N;
		for(int i=0;i<N;++i) cin>>baekjoon[i].time>>baekjoon[i].pay;
		maxProfit = 0;
	}
	void quit(int i,int profit)
	{
		if(i>=N) 
		{
			maxProfit = max(profit,maxProfit);
			return;
		}
		if(i+1<=N)quit(i+1,profit);
		if(i+baekjoon[i].time<=N)quit(i+baekjoon[i].time,profit+baekjoon[i].pay);
	}
	int getMaxProfit(){
		return maxProfit;
	}
};

int main()
{
	Company consultingCompany;
	consultingCompany.quit(0,0);
	cout<<consultingCompany.getMaxProfit()<<endl;
	return 0;
}