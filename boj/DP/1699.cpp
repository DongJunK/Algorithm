#include <iostream>

using namespace std;

int dp[100001] = {0,};
int main()
{
	int n;
	cin>>n;

	for(int i=1;i*i<=n;++i)
	{
		for(int j=i*i;j<=n;++j)
		{
			if(dp[j-i*i]+1<dp[j] || dp[j] == 0) 
			{
				dp[j] = dp[j-i*i] + 1;
			}
		}
	}

	cout<<dp[n]<<endl;
	return 0;
}
