#include <iostream>
#include <algorithm>
using namespace std;
int inf=987654321;
int dp[501][501];
int matrix[501];
int n;
void init()
{
    for(int i=1;i<=n;++i)
    {
        dp[i][i] = 0;
    }
    for(int i=1;i<n;++i)
    {
        for(int j=1;j<=n-i;++j)
        {
            dp[j][j+i] = inf;
        }
    }
}

void solution()
{
    for(int i=1;i<n;++i)
    {
        for(int j=1;j<=n-i;++j)
        {
            int k=j+i;
            for(int l=j;l<k;++l)
            {
                dp[j][k] = min(dp[j][k],dp[j][l] + dp[l+1][k] + matrix[j] *matrix[l+1] * matrix[k+1]);
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    
    cin>>n;
    cin>>matrix[1]>>matrix[2];
    for(int i=2;i<=n;++i)
    {
        cin>>matrix[i]>>matrix[i+1];
    }
    init();
    solution();
    
    cout<<dp[1][n]<<endl;
    return 0;
}
