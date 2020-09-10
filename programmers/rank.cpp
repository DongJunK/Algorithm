#include <string>
#include <vector>

using namespace std;

bool map[101][101];
bool visit[101];
void init_map(int n,vector<vector<int> > results)
{
    for(int i=1;i<=n;++i)
    {
        for(int j = 1;j<=n;++j)
        {
            map[i][j] = false;
        }
    }
    for(int i=0;i<results.size();++i)
    {
        map[results[i][0]][results[i][1]] = true;
    }
}

void init_visit(int n)
{
    for(int i = 1; i <= n ; ++i)
    {
        visit[i] = false;
    }
}

void up_dfs(int now, int n)
{
    visit[now] = true;
    for(int i = 1; i <= n;++i)
    {
        if(map[i][now] && !visit[i])
        {
            up_dfs(i, n);
        }
    }
}
void down_dfs(int now, int n)
{
    visit[now] = true;
    for(int i = 1;i <= n;++i)
    {
        if(map[now][i] && !visit[i])
        {
            down_dfs(i,n);
        }
    }
}
bool check_visit(int n)
{
    for(int i=1;i<=n;++i)
    {
        if(!visit[i])
        {
            return false;
        }
    }
    return true;
}


int solution(int n, vector<vector<int> > results) {
    int answer = 0;
    init_map(n,results);
    for(int i = 1;i<=n;++i)
    {
        init_visit(n);
        up_dfs(i,n);
        down_dfs(i,n);
        answer += check_visit(n);
    }
    return answer;
}
