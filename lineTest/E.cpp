#include <iostream>

using namespace std;
int map[25][25];

int map_scale[2];
int coni[2];
int moon[2];
int cnt = 0;
int min_move;

void dfs(int x,int y, int move)
{
    if(x < 0 || coni[0] < x || 
       y < 0 || coni[1] < y )
    {
        return;
    }
    if(x == coni[0] && y == coni[1] )
    {
        ++cnt;
        min_move = move;
        return;
    }
    dfs(x+1,y,move+1);
    dfs(x,y+1,move+1);
}

int main()
{
    cin>>map_scale[0]>>map_scale[1];
    cin>>coni[0]>>coni[1];

    dfs(0,0,0);

    cout << min_move << endl;
    cout << cnt << endl;
    

    return 0;
}