#include <iostream>
#include <cmath>

using namespace std;

int map[101][101];
int side;
int degree;
int answer = 0;
bool visit[101] = {0,};

void initialization()
{
    cin >> side >> degree;
    for (int i = 0; i < side; ++i)
    {
        for (int j = 0; j < side; ++j)
        {
            cin >> map[i][j];
        }
    }
}
bool degreeCheck(int y, int x,int direction,int advance)
{
    int cnt = degree-1;
    
    if(direction==0){
        if(visit[x]) return false;
        int before = map[y][x];
        visit[x] = true;
        for(int i=x+advance;0<cnt;i+=advance){
            int now = map[y][i];
            if(i<0 || side<=i || visit[i] == true || before != now) return false;
            visit[i] = true;
            --cnt;
            before = now;
        }
    } else if(direction==1){
        if(visit[y]) return false;
        int before = map[y][x];
        visit[y] = true;
        for(int i=y+advance;0<cnt;i+=advance){
            int now = map[i][x];
            if(i<0 || side<=i || visit[i] == true || before != now) return false;
            visit[i] = true;
            --cnt;
            before = now;
        }
    }
    return true;
}


// 0 = horizontal 1 = vertical
int roadCheck(int start, int direction)
{
    int before_land, now_land,y,x;

    for(int i=0;i<side;++i) visit[i] = 0;
    
    if(direction==0) before_land = map[start][0];
    else if(direction==1) before_land = map[0][start];

    for (int i = 1; i < side; ++i)
    {
        if (direction == 0){
            now_land = map[start][i];
            y = start;
            x = i;
        }
        else if(direction==1){
            now_land = map[i][start];
            y = i;
            x = start;
        }

        if(before_land != now_land){
            if(abs(before_land-now_land) != 1) return 0;
            if(now_land<before_land){
                if(!degreeCheck(y, x,direction,1)) return 0;
            }else if(before_land<now_land){
                if(direction==0){
                    if(!degreeCheck(y,x-1,direction,-1)) return 0;
                }else if(direction==1){
                    if(!degreeCheck(y-1,x,direction,-1)) return 0;
                }
            }
        }

        before_land = now_land;
    }
    
    return 1;
}

void solution()
{
    for (int i = 0; i < side; ++i)
    {
        answer += roadCheck(i, 0);
        answer += roadCheck(i, 1);
    }
    cout << answer << endl;
}

int main()
{
    initialization();
    solution();

    return 0;
}