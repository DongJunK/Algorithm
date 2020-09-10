#include <iostream>

using namespace std;

int main()
{
    int E,S,M;
    int nE = 0,nS = 0, nM = 0;
    int year = 1;
    cin>>E>>S>>M;
    
    while(1)
    {
        nE = ++nE % 15; 
        nS = ++nS % 28; 
        nM = ++nM % 19;
        if(nE == 0 ) nE = 15;
        if(nS == 0 ) nS = 28;
        if(nM == 0 ) nM = 19;

        if(nE == E && nS == S && nM == M)
        {
            break;
        }
        
        ++year;
    }
    cout<<year<<endl;
    return 0;
}