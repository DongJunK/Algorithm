#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n,result;
    cin >>n;
    for(int i=0;i<n;++i)
    {
        int str,inte,exp;
        cin>>str>>inte>>exp;
        if(str + exp <= inte)
        {
            cout << "0" << endl;
        }
        else if(exp ==0)
        {
            cout<<"1"<<endl;
        }
        else{
            cout << min(exp+1, (str + exp - inte +1)/2 ) << endl;
        }
        
    }
    return 0;
}