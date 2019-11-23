#include <iostream>

using namespace std;

int arr[101];
int count[301]={0,};

int main()
{
    int num;
    cin>>num;
    for(int i=0;i<num;++i)
    {
        int n;
        cin>>n;
        ++count[n+100];
    }
    int show;
    cin>>show;
    cout<<count[show+100]<<endl;
    
    return 0;
}