#include <vector>
#include <queue>
using namespace std;

int height;
int width;
int vx[4] = {1,-1,0,0};
int vy[4] = {0,0,1,-1};

bool range_check(int x, int y)
{
    return 0<= x && x < width && 0 <= y && y < height;
}

void init(vector<vector<int> > maps)
{
    height = maps.size();
    width = maps[0].size();
}

int bfs(vector<vector<int> > maps)
{
    queue<int> qx;
    queue<int> qy;
    qx.push(0);
    qy.push(0);

    while (true)
    {
        if(qx.empty())
        {
            break;
        }
        int now_x = qx.front();
        int now_y = qy.front();
        qx.pop(); qy.pop();
        if(now_y == height -1 && now_x == width -1)
        {
            return maps[height-1][width-1];
        }

        for(int i=0; i<4; ++i)
        {
            int next_x = now_x + vx[i];
            int next_y = now_y + vy[i];
            if(range_check(next_x,next_y)
            && maps[next_y][next_x] == 1)
            {
                qx.push(next_x);
                qy.push(next_y);
                maps[next_y][next_x] = maps[now_y][now_x] + 1;
            }
        }
        
    }
    return -1;
}

int solution(vector<vector<int> > maps)
{
    int answer = 0;

    init(maps);
    answer = bfs(maps);
    return answer;
}