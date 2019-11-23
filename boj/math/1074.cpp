#include <iostream>
#include <vector>
using namespace std;
int max_num = 250000;
bool pn[250000];

void prime_num()
{
    for(int i=0;i<max_num;++i) pn[i] = true;

    for(int i=2;i<max_num;++i)
    {
        int cnt=2;
        for(int j=i*2;j<max_num;j = i*cnt)
        {
            pn[j] = false;
            ++cnt;
        }
    }
}

void solution()
{
    prime_num();
    
    while(1)
    {
        int cnt=0;
        int num;
        cin>>num;
        if(num==0) break;
        for(int i=num+1;i<=2*num;++i)
        {
            if(pn[i]) ++cnt;
        }
        cout<<cnt<<endl;
    }
}

int main()
{
    
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    solution();
    
    return 0;
}