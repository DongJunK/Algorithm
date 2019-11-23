#include <iostream>

using namespace std;

int dp[101][11];
int modValue = 1000000000;
int solution(int n)
{
	dp[1][0] = 0;
	for(int i=1;i<10;++i)
	{
		dp[1][i] = 1;
	}

	for(int i=2;i<=n;++i)
	{
		dp[i][0] = dp[i-1][1];
		dp[i][9] = dp[i-1][8];
		for(int j=1;j<9;++j)
		{
			dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%modValue;
		}
	}
	
	int result = 0;
	for(int i=0;i<10;++i)
	{
		result = (result + dp[n][i]) % modValue;
	}
	return result;
}

int main()
{
	int n;
	cin>>n;

	cout<<solution(n)<<endl;
	
	return 0;
}
