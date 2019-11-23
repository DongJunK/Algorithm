#include <iostream>
#include <cstring>
using namespace std;
int dp[101][1001];
int arr[101];
int main()
{
	memset(dp,0,sizeof(dp));	

	int n,s,m;
	cin>>n>>s>>m;
	dp[0][s] = 1;
	for(int i=0;i<n;++i)
	{
		cin>>arr[i];
	}

	for(int i=0;i<n;++i)
	{
		for(int j=0;j<=m;++j)
		{
			if(dp[i][j] != 0)
			{
				if(0<=j-arr[i])
				{
					dp[i+1][j-arr[i]] = 1;
				}
				if(j+arr[i]<=m)
				{
					dp[i+1][j+arr[i]] = 1;
				}
			}
		}
	}
	for(int i=m;0<=i;--i)
	{
		if(dp[n][i]!=0)
		{
			cout<<i<<endl;
			return 0;
		}
	}
	cout<<-1<<endl;
	return 0;
}
