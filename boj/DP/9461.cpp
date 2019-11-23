#include <iostream>

using namespace std;
int dp[1001];

int main()
{
	int testcase;
	cin>>testcase;
	
	dp[1] = dp[2] = dp[3] = 1;
	
	for(int t=0;t<testcase;++t)
	{
		int n;
		cin>>n;
		for(int i=4;i<=n;++i)
    	{   
        	dp[i] = dp[i-3]+dp[i-2];
    	}
    	cout<< dp[n]<<endl;
	}

	return 0;
}
