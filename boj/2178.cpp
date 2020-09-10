#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

bool map[101][101];
int vy[4] = {0, 0, 1, -1};
int vx[4] = {1, -1, 0, 0};
int x, y;
int answer = 123456789;

class Point
{
    public:
        int x;
        int y;
        int count;
};

void initialize()
{
    cin>> y >> x;
    for(int i = 1; i <= y; ++i)
    {
        string str;
        cin>> str;
        for(int j = 1; j <= str.length(); ++j)
        {
            map[i][j] = str[j-1] - '0';
        }
    }
}

bool range_check(int _x, int _y)
{
    return 1 <= _x && _x <= x && 1 <= _y && _y <= y;
}

int bfs()
{
    queue<Point> q;
    Point p;
    p.x = 1;
    p.y = 1;
    p.count = 1;

    q.push(p);

    while(1)
    {
        if(q.empty()){
            break;
        }
        Point now_p = q.front();
        q.pop();
        int now_x = now_p.x;
        int now_y = now_p.y;
        int now_ans = now_p.count;

        if(now_x == x && now_y == y)
        {
            answer = now_ans;
            break;
        }
        map[now_y][now_x] = 0;
        for(int i = 0; i < 4; ++i)
        {
            Point next_p;
            next_p.x = now_x + vx[i];
            next_p.y = now_y + vy[i];
            next_p.count = now_ans + 1;

            if(range_check(next_p.x, next_p.y) && map[next_p.y][next_p.x] == 1)
            {
                q.push(next_p);
                map[next_p.y][next_p.x] = 0;
            }
        }
    }
    return answer;
}


int main()
{
    initialize();
    cout << bfs() << endl;

    return 0;
}