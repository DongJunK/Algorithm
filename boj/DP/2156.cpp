#include <iostream>
#include <algorithm>
using namespace std;
int arr[10001];
int dp[10001][3];

int solution(int n)
{
	dp[0][0] = arr[0];
	dp[0][1] = arr[0];
	int maxValue = dp[0][0];
	if(1<=n)
	{
		dp[1][0] = arr[1];
		dp[1][1] = arr[0]+arr[1];
		maxValue = dp[1][1];
	}
	for(int i=2;i<n;++i)
	{
		dp[i][0] = arr[i] + max({dp[i-2][0],dp[i-2][1],dp[i-2][2]});
		dp[i][1] = dp[i-1][0] + arr[i];
		maxValue = max({dp[i][0],dp[i][1],maxValue});
		dp[i][2] = maxValue;
	}
	cout<<maxValue<<" " << dp[n-1][2]<<endl;
	return maxValue;
}

int main()
{
	int n;
	cin>>n;
	
	for(int i=0;i<n;++i)
	{
		cin>>arr[i];
	}

	cout<<solution(n)<<endl;
	return 0;
}
