#include <iostream>
#include <string>
using namespace std;

string solution(string word)
{
    string a,b,c,answer="";
    for(int i=1;i<word.length()-1;++i)
    {
        for(int j=1;j<word.length()-i;++j)
        {
            a = word.substr(0,i);
            b = word.substr(i,j);
            c = word.substr(i+j);
            reverse(a.begin(),a.end());
            reverse(b.begin(),b.end());
            reverse(c.begin(),c.end());
            if(answer=="")
            {
                answer = a+b+c;
            }
            else if(a+b+c<answer)
            {
                answer = a+b+c;
            }
        }
    }
    return answer;
}

int main(int argc, const char * argv[]) {
    string word;
    cin>>word;
    cout<<solution(word)<<endl;
    
    return 0;
}