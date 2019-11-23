#include <iostream>
#include <algorithm>
using namespace std;

int dp[10001] = {0,};
int coin[101];

int main()
{
	int n,k,coin;
	cin>>n>>k;
	
	for(int i=1;i<=k;++i)
	{
		dp[i] = 100001;
	}

	for(int i=0;i<n;++i)
	{
		cin>>coin;
		for(int j=coin;j<=k;++j)
		{
			dp[j] = min(dp[j],dp[j-coin]+1);
		}
	}

	int result = dp[k] != 100001 ? dp[k] : -1;
	
	cout << result << endl;
	return 0;
}
