#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
bool map[20001][20001];
int visit[20001];

void init_map(int n, vector<vector<int> > edge)
{
    for(int i=1;i<=n;++i)
    {
        for(int j=1;j<=n;++j)
        {
            map[i][j] = false;
        }
    }
    for(int i=0;i<edge.size();++i)
    {
        vector<int> _edge = edge[i];
        map[_edge[0]][_edge[1]] = true;
        map[_edge[1]][_edge[0]] = true;
    }
}

void init_visit(int n)
{
    for(int i=1;i<=n;++i)
    {
        visit[i] = 0;
    }
}

void bfs(int n, vector<vector<int> > edge)
{
    queue<int> q;
    q.push(1);

    while(true)
    {
        if(q.empty())
        {
            break;
        }
        int now_node = q.front();
        q.pop();
        for(int i=1;i<=n;++i)
        {
            if(map[now_node][i])
            {

                if(visit[i] != 0)
                {
                    visit[i] = min(visit[i], visit[now_node] + 1);
                }
                else
                {
                    visit[i] = visit[now_node] +  1;
                    q.push(i);
                }
            }
        }
    }
}

int check_max(int n)
{
    int max_num = 0;
    for(int i=2;i<=n;++i)
    {
        max_num = max(max_num,visit[i]);
    }
    return max_num;
}

int solution(int n, vector<vector<int> > edge) {
    int answer = 0;
    init_map(n,edge);
    bfs(n,edge);
    int max_num = check_max(n);
    for(int i = 2; i <= n; ++i)
    {
        if(max_num == visit[i])
        {
            ++answer;
        }
    }
    return answer;
}