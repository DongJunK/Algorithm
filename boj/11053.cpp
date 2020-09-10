#include <iostream>
#include <algorithm>
using namespace std;
int arr[1001];
int dp[1001];

int solution(int n)
{
	for(int i=1;i<n;++i)
	{
		for(int j=i-1;0<=j;--j)
		{
			if(arr[j]<arr[i]&&dp[i]<=dp[j])
			{
				dp[i] = dp[j] + 1;
			}
		}
	}
	int maxValue=0;
	for(int i=0;i<n;++i)
	{
		maxValue = max(maxValue,dp[i]);
	}
	return maxValue;
}
int main()
{
	int n;
	cin>>n;
	
	for(int i=0;i<n;++i)
	{
		cin>>arr[i];
		dp[i] = 1;
	}
	cout<<solution(n)<<endl;
	return 0;
}
