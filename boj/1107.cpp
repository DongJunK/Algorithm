#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int channel;
bool broken_btn[10] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
int min_press  = 1000000;

void solution(int now_num,int pos)
{
    if(pos == 7)
    {
        return;
    }
    
    min_press = min(min_press,abs(now_num-channel)+pos);
    
    for(int i=0;i<10;++i)
    {
        if(broken_btn[i] == true)
        {
            solution(now_num*10+i,pos+1);
        }
    }
}

int main()
{
    
    int now = 100;
    int broken_btn_num;
    
    
    cin>>channel;
    cin>>broken_btn_num;
    for(int i = 0 ; i<broken_btn_num;++i)
    {
        int num;
        cin>>num;
        broken_btn[num] = 0;
    }

    min_press = min(min_press, abs(channel-now));
    for(int i=0;i<10;++i)
    {
        if(broken_btn[i] == true)
        {
            solution(i,1);
        }
        
    }
    cout<<min_press<<endl;

    
    return 0;
}