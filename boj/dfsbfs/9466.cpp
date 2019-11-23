#include <iostream>
#include <cstring>
using namespace std;

int stu[100001];
bool visit[100001];
bool done[1000001];
bool cycleStart = false;
int cnt;

// 사이클 구하는 재귀함수
void solution(int n)
{
    if(done[n] == true)
    {
        return ;
    }
    if(visit[n] == false)
    {
        visit[n] = true;
    }
    else if(cycleStart == false)
    {
        cycleStart = true;
        ++cnt;
        done[n] = true;
    }
    else
    {
        ++cnt;
    }
    solution(n);
    done[n] = true;
}

int main()
{
    int T;
    cin>>T;
    for(int testcase=0;testcase<T;++testcase)
    {
        int n;
        cin>>n;
        
        memset(done,false,sizeof(done));
        memset(visit,false,sizeof(visit));
        cnt = 0;

        for(int i=1;i<=n;++i)
        {
            cin>>stu[i];
        }
        for(int i=1;i<=n;++i)
        {
            if(visit[i] == false){
                cycleStart = false;
                solution(i);
            }
        }
        cout << n - cnt << endl;
    }
    return 0;
}