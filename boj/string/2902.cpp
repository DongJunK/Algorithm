#include <iostream>

using namespace std;

int main()
{
    string str,result = "";
    cin>>str;
    for(int i=0;i<str.length();++i)
    {
        if(65 <= str[i] && str[i] <= 90 )
        {
            result += str[i];
        }
    }

    cout<<result<<endl;

    return 0;
}