#include <iostream>
#include <algorithm>
using namespace std;

int arr[1001];
int dp[1001];

int solution(int n)
{
	for(int i=1;i<=n;++i)
	{
		for(int j=i;j<=n;++j)
		{
			dp[j] = max(dp[j-i]+arr[i],dp[j]);
		}
	}
	int maxValue=0;
	for(int i=1;i<=n;++i)
	{
		maxValue = max(maxValue,dp[i]);
	}
	return maxValue;
}

int main()
{
	int n;
	cin>>n;

	dp[0] = 0;
	for(int i=1;i<=n;++i)
	{
		cin>>arr[i];
		dp[i] = 0;
	}
	cout<<solution(n)<<endl;
	return 0;
}
