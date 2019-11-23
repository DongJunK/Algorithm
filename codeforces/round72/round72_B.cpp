#include <iostream>
#include <algorithm>
using namespace std;


int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        int n,head, cnt;
        cin>>n>>head;
        int maxDamage= 0, maxAttack = 0 ;
        for(int i=0;i<n;++i)
        {
            int attack,growHead;
            cin>>attack>>growHead;
            maxDamage = max(maxDamage,attack - growHead);
            maxAttack = max(maxAttack,attack);
        }

        if(maxDamage <= 0)
        {
            cout << -1 <<endl;
        }
        else if(maxAttack>=head)
        {
            cout << 1 << endl;
        }
        else
        {
            cout << (head - maxAttack - 1) / maxDamage + 2 << endl;
        }
        
    }

    return 0;
}