#include <iostream>

using namespace std;

int main()
{
    int n;
    cin>>n;
    int cnt=0;
    int num = 666;
    int result;
    while(1)
    {
        int flag_cnt = 0;
        if(cnt==n)
        {
            break;
        }
        int copy = num;
        while(copy!=0)
        {
            
            int tmp = copy%10;

            if(tmp == 6)
            {
                ++flag_cnt;
            }
            else
            {
                flag_cnt = 0;
            }
            if(flag_cnt==3)
            {
                ++cnt;
                result = num;
                break;
            }
            copy/=10;
        }
        ++num;
    }
    cout << result << endl;
    return 0;
}