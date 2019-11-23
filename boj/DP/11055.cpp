#include <iostream>
#include <algorithm>

using namespace std;

int dp[1001] = {0,};
int arr[1001];
int main()
{
	int n,value;
	cin>>n;
	
	for(int i=0;i<n;++i)
	{
		cin>>arr[i];
		dp[i] = arr[i];
	}
	for(int i=0;i<n;++i)
	{
		for(int j=i-1;0<=j;--j)
		{
			if(arr[j]<arr[i])
				dp[i] = max(dp[i],dp[j]+arr[i]);
		}
	}
	int maxValue=0;
	for(int i=0;i<n;++i)
	{
		maxValue = max(maxValue,dp[i]);
	}
	cout<<maxValue<<endl;

	return 0;
}
