#include <iostream>

using namespace std;

int alpha[27] = {0,};
int tmp_alpha[27] = {0,};

void init()
{
    for(int i=0;i<27;++i)
    {
        tmp_alpha[i] = 0;
    }
}

int main()
{
    int n;
    string main_str;
    string tmp_str;
    
    cin>>n;
    cin>>main_str;
    
    for(int i=0;i<main_str.length();++i)
    {
        ++alpha[main_str[i]-'A'];
    }
    int result=0;
    for(int i=0;i<n-1;++i)
    {
        int pcnt=0;
        int mcnt=0;
        bool flag = true;
        cin>>tmp_str;
        for(int i=0;i<tmp_str.length();++i)
        {
            ++tmp_alpha[tmp_str[i]-'A'];
        }
        for(int i=0;i<26;++i)
        {
            
            if(tmp_alpha[i]==alpha[i]){
                continue;
            }
            else if(tmp_alpha[i]+1 == alpha[i] )
            {
                ++pcnt;
            }
            else if( tmp_alpha[i]-1 == alpha[i] )
            {
                ++mcnt;
            }
            else
            {
                flag = false;
                break;
            }

            if(1<pcnt || 1<mcnt)
            {
                flag = false;
                break;
            }

        }
        init();
        if(flag) ++result;
        else if(mcnt == 1 && pcnt == 1 && tmp_str.length() == main_str.length()) ++result;
    }
    cout<<result<<endl;
    return 0;
}