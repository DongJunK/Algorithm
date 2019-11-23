#include <iostream>
#include <string>
using namespace std;

int main(int argc, const char * argv[]) {
    string str;
    cin>>str;
    int cnt=0;
    for(int i=0;i<str.length();++i)
    {
        if(str[i]=='c' && (str[i+1]=='=' || str[i+1]=='-'))
        {
            ++i;
        }
        else if(str[i]=='d')
        {
            if(str[i+1]=='-') ++i;
            else if(str[i+1]=='z'&&str[i+2]=='=')
            {
                i+=2;
            }
        }
        else if((str[i]=='l'||str[i]=='n')&&str[i+1]=='j')
        {
            ++i;
        }
        else if((str[i]=='s'||str[i]=='z')&&str[i+1]=='=')
        {
            ++i;
        }
        ++cnt;
    }
    
    cout<<cnt<<endl;
    return 0;
}
