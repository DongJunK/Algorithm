#include <iostream>

using namespace std;

int main()
{
    string str;
    string compare_str;
    getline(cin,str);
    getline(cin,compare_str);
    int answer = 0;

    int loop = str.length() - compare_str.length();
    for(int i = 0;i <= loop;++i)
    {
        if(compare_str == str.substr(i, compare_str.length()))
        {
            ++answer;
            i += compare_str.length() - 1;
        }
    }
    cout << answer << endl;
    return 0;
}