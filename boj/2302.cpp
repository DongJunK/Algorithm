#include <iostream>

using namespace std;

int dp[41] = {0,};

int main()
{
	int n,m;
	
	cin>>n>>m;
	for(int i=0;i<m;++i)
	{
		cin>>dp[i];
	}
	int result=1;
	result = result*(dp[0]-1)*(n-dp[m-1]);
	
	for(int i=1;i<m;++i)
	{
		result *= (dp[i]-dp[i-1]-1);
	}
	cout<<result<<endl;
	return 0;
}
