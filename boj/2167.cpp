#include <iostream>

using namespace std;

int DP[301][301];

int main()
{
	int x,y,n;
	cin>>y>>x;
	for(int i=0;i<=y;++i)
	{
		DP[i][0] = 0;
	}
	for(int i=0;i<=x;++i)
	{
		DP[0][i] = 0;
	}

	for(int i=1;i<=y;++i)
	{
		for(int j=1;j<=x;++j)
		{
			int value;
			cin>>value;
			DP[i][j] = DP[i][j-1] + DP[i-1][j] - DP[i-1][j-1] + value;
		}
	}
	
	cin>>n;
	for(int t=0;t<n;++t)
	{
		int startY,startX,endY,endX;
		cin>>startY>>startX>>endY>>endX;
		
		cout<< DP[endY][endX] - DP[endY][startX-1] - DP[startY-1][endX] + DP[startY-1][startX-1]<<endl;
	}

	return 0;
}
