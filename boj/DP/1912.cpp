#include <iostream>
  
using namespace std;
int arr[100001];

int solution(int n)
{
    int dp = arr[0];
    int max = dp;

    for(int i=1;i<n;++i)
    {
        if(max<dp) max = dp;
        if(arr[i]<0&&dp+arr[i]<0)
        {
            dp = arr[i];
        }
        else if(dp<0)
        {
            dp = arr[i];
        }
        else
        {
            dp += arr[i];
        }
        if(max<dp) max = dp;
    }
    return max;
}

int main()
{
    int n;
    cin>>n;
    for(int i=0;i<n;++i)
    {
        cin>>arr[i];
    }

    cout << solution(n)<<endl;

    return 0;
}

