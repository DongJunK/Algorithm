#include <string>
#include <vector>
#include <set>
using namespace std;

int height = 10;
int width = 10;
int map[11][11];
set<string> visit;
int vx[4] = {1,-1,0,0};
int vy[4] = {0,0,1,-1};



bool check_range(int x, int y)
{
    return 0<=x && x <= width && 0 <= y && y <= height;
}

int solution(string dirs) {
    int answer = 0;
    int now_x = 5;
    int now_y = 5;
    
    for(int i=0; i<dirs.length(); ++i)
    {
        int next_x;
        int next_y;
        switch (dirs[i])
        {
            case 'U':
                next_x = now_x + vx[3];
                next_y = now_y + vy[3];
                break;
            case 'D':
                next_x = now_x + vx[2];
                next_y = now_y + vy[2];
                break;
            case 'L':
                next_x = now_x + vx[1];
                next_y = now_y + vy[1];
                break;
            case 'R':
                next_x = now_x + vx[0];
                next_y = now_y + vy[0];
                break;
        }
        if(!check_range(next_x,next_y)) continue;
        
        char key[500];
        sprintf(key,"%d,%d,%d,%d",now_x, now_y, next_x, next_y);
        visit.insert(key);
        sprintf(key,"%d,%d,%d,%d",next_x, next_y, now_x, now_y);
        visit.insert(key);
        now_x = next_x;
        now_y = next_y;
    }
    answer = visit.size()/2;

    return answer;
}
