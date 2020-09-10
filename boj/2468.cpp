#include <iostream>
#include <algorithm>
using namespace std;

int map[101][101];
int visit[101][101];

int vx[4] = {1,-1,0,0};
int vy[4] = {0,0,1,-1};
int answer = 1;
int max_height = -1;
int n;

bool range_check(int x, int y)
{
    return 0 <= x && x < n && 0 <= y && y < n;
}

void initialize()
{
    cin>>n;
    for(int i = 0; i < n; ++i)
    {
        for(int j = 0; j < n; ++j)
        {
            cin>>map[i][j];
            max_height = max(max_height, map[i][j]);
        }
    }
}
void init_visit()
{
    for(int i = 0; i < n; ++i)
    {
        for(int j = 0; j < n; ++j)
        {
            visit[i][j] = 0;
        }
    }
}

void dfs(int x, int y, int rain)
{
    if(!range_check(x,y) || visit[y][x] || map[y][x] - rain <= 0)
    {
        return;
    }
    visit[y][x] = 1;
    for(int i=0;i<4;++i)
    {
        dfs(x+vx[i],y+vy[i],rain);
    }
    
}

void solve()
{
    for(int i=1; i <= max_height;++i)
    {
        init_visit();
        int count = 0;
        for(int j=0; j<n; ++j)
        {
            for(int k=0; k<n; ++k)
            {
                if(0 < map[j][k] - i && !visit[j][k])
                {
                    dfs(k,j,i);
                    ++count;
                }
            }
        }
        answer = max(answer,count);
    }
}

int main()
{
    initialize();
    solve();
    cout<<answer<<endl;
    return 0;
}