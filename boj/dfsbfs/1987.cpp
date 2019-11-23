#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int vx[4] = {1,-1,0,0};
int vy[4] = {0,0,1,-1};

string alphabet[21];
int maxX,maxY;
int maxCnt = -1;
void dfs(int x,int y, bool visit[],int cnt)
{
    visit[alphabet[y][x]-'A'] = true;
    ++cnt;
    for(int i=0;i<4;++i)
    {
        int nextX = x + vx[i];
        int nextY = y + vy[i];
        if(0<=nextX && nextX < maxX &&
           0<=nextY && nextY < maxY )
        {
            if(visit[alphabet[nextY][nextX]-'A'] == false)
            {
                
                dfs(nextX,nextY,visit,cnt);
            }
        }
    }
    maxCnt = max(maxCnt,cnt);
    --cnt;
    visit[alphabet[y][x]-'A'] = false;
}


int main(int argc, const char * argv[]) {
    cin>>maxY>>maxX;
    for(int i=0;i<maxY;++i)
    {
        cin>>alphabet[i];
    }
    bool visit[26]={0,};
    dfs(0,0,visit,0);
    
    cout<<maxCnt<<endl;
    return 0;
}