#include <iostream>
using namespace std;

int main(int argc, const char * argv[]) {
    int n,order[11];
    cin>>n;
    for(int i=0;i<n;++i)
    {
        order[i]=0;
    }
    for(int i=1;i<=n;++i)
    {
        int left;
        cin>>left;
        for(int j=0;j<n;++j)
        {
            
            if(order[j]==0&&left==0)
            {
                order[j] = i;
                break;
            }
            else if(order[j]==0)
            {
                --left;
            }
            
        }
    }
    for(int i=0;i<n;++i)
    {
        cout<<order[i]<<" ";
    }
    cout<<endl;
    return 0;
}
