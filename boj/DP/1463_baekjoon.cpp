/*
*BeakJoon ID : skdltm357
*Quesion = https://www.acmicpc.net/problem/1463
*
*ID = DongjunK
*Github = https://github.com/DongJunK/BeakJoon
*/

#include <iostream>
int DP[1000001];
using namespace std;

int main(){
	int n;
	cin>>n;
	DP[1]=0;
	for(int i=2;i<=n;i++){
		DP[i]=DP[i-1]+1; 
		if(i%2==0&&DP[i/2]<DP[i-1]){
			DP[i]=DP[i/2]+1;
		}
		if(i%3==0&&DP[i/3]<DP[i-1]){
			DP[i]=DP[i/3]+1;
		}
	}
	cout<<DP[n]<<endl;
	return 0;
}
