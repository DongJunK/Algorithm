#include <iostream>
#include <vector>
using namespace std;

bool pn[10000];
int max_num = 10000;
bool flag = false;
void prime_num()
{
    for(int i=0;i<max_num;++i) pn[i] = true;

    for(int i=2;i<max_num;++i)
    {
        int cnt=2;
        for(int j=i*2;j<max_num;j = i*++cnt)
        {
            pn[j] = false;
        }
    }
}



void solution(int num)
{
    int mid = num/2;
    int i,j;
    for(i=j=mid;i<num;--i,++j)
    {
        if(pn[i] == true && pn[j] == true)
        {
            if(i+j == num)
            {
                cout << i << " " << j << endl;
                break;
            }
        }
    }

    

}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    prime_num();
    int n;
    cin>>n;
    while(n--)
    {
        int num;
        cin>>num;
        
        solution(num);
    }

    return 0;
}