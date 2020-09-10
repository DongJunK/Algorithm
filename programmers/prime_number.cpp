#include <string>
#include <vector>

using namespace std;

int length;
bool prime[10000000] = {0,};
bool visit_prime[10000000] = {0,};
bool visit[7] = {0,};
int result = 0;

void init_prime()
{
    for(int i=2;i<10000000;++i)
    {
        prime[i] = true;
    }
    for(int i=2;i<10000000;++i)
    {
        if(prime[i])
        {
            for(int j=2;i*j<10000000;++j)
            {
                prime[i*j] = false;
            }
        }
    }
}

void dfs(string maked_num,string numbers)
{
    int now_num = stoi(maked_num);
    if(prime[now_num] && !visit_prime[now_num]){
        ++result;
        visit_prime[now_num] = true;
    }
    for(int i=0;i<length;++i)
    {
        if(!visit[i])
        {
            visit[i] = true;
            maked_num += numbers[i];
            dfs(maked_num,numbers);
            visit[i] = false;
            maked_num.erase(maked_num.size()-1);
        }
    }
}

int solution(string numbers) {
    int answer = 0;
    length = numbers.length();
    init_prime();
    for(int i=0;i<numbers.length();++i)
    {
        if(numbers[i] != '0')
        {
            string num = "";
            num += numbers[i];
            visit[i] = true;
            dfs(num,numbers);
            visit[i] = false;
            num.erase(0);
        }
    }
    answer = result;
    return answer;
}