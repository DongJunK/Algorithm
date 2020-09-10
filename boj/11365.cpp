#include <iostream>
#include <vector>
using namespace std;

string solution(string str)
{
    string tmp = str;
    for(int i=0;i<str.length();++i)
    {
        tmp[i] = str[(str.length()-1)-i];
    }
    return tmp;
}

int main()
{
    vector<string> plainText;
    while(1)
    {
        string str;
        getline(cin,str);
        
        if(str == "END")
        {
            break;
        }
        str = solution(str);
        plainText.push_back(str);
    }
    for(int i=0;i<plainText.size();++i)
    {
        cout<<plainText.at(i)<<endl;
    }
    return 0;
}