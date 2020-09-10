#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int toilet[151] = {0,};


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin>>n;
    while(n--)
    {
        int start,end;
        cin>>start>>end;
        for(int i=start;i<end;++i)
        {
            ++toilet[i];
        }
    }
    
    sort(toilet,toilet+151);
    cout << toilet[150] << endl;
    return 0;
}