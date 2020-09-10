#include <iostream>

using namespace std;

int arr[101];
int cnt[301]={0,};

int main()
{
    int num;
    cin>>num;
    for(int i=0;i<num;++i)
    {
        int n;
        cin>>n;
        ++cnt[n+100];
    }
    int show;
    cin>>show;
    cout<<cnt[show+100]<<endl;
    
    return 0;
}