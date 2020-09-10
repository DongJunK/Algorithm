#include <vector>

using namespace std;

vector<bool> visit;

void init_visit(int n)
{
    for(int i=0;i<n;++i)
    {
        visit.push_back(false);
    }
}

void dfs(int n, vector<vector<int> > computers, int now, int *answer)
{
    for(int i=0;i<n;++i)
    {
        if(!visit[i] && computers[now][i] == 1)
        {
            visit[i] = true;
            --(*answer);
            dfs(n, computers, i, answer);
        }
    }
}

int solution(int n, vector<vector<int> > computers)
{
    int answer = n;
    init_visit(n);
    for(int i=0;i<n;++i)
    {
        visit[i] = true;
        dfs(n,computers,i,&answer);
    }
    
    return answer;
}
