#include <iostream>

using namespace std;
int seat[20001];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin>>n;
    for(int i=0;i<n;++i)
    {
        cin>>seat[i];

        if(seat[i] == 0)
        {
            seat[i] = 20001;
        }
    }

    for(int i=0;i<n;++i)
    {
        if(seat[i] == 1)
        {
            for(int j=i-1;0<=j;--j)
            {
                if( j < 0 || seat[j] == 1) break;
                if(seat[j] == 0)
                {
                    seat[j] = seat[j+1]+1;
                }
                else if(seat[j+1]+1 < seat[j])
                {
                    seat[j] = seat[j+1]+1;
                }
                
            }
            for(int k=i+1;k<n;++k)
            {
                if( n <= k || seat[k] == 1) break;

                if(seat[k] == 0)
                {
                    seat[k] = seat[k-1]+1;
                }
                else if(seat[k-1] + 1 < seat[k])
                {
                    seat[k] = seat[k-1]+1;
                }
            }
        }
    }
    sort(seat,seat+n);
    
    if(seat[n-1] == 1 )
    {
        cout << '1' << endl;
    }
    else
    {
        cout<<seat[n-1]-1<<endl;
    }
    
    
    return 0;
}