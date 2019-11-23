#include <iostream>
#include <queue>
using namespace std;

int vx[4] = {1,-1,0,0};
int vy[4] = {0,0,1,-1};

int arr[101][101];
int dist_arr[101][101];
int n;
int dist=123456789;

void bfs(int y,int x,int area)
{
    queue<int> qY;
    queue<int> qX;
    qY.push(y);
    qX.push(x);
    while(!qX.empty())
    {
        int y = qY.front();
        int x = qX.front();
        qX.pop();
        qY.pop();
        
        for(int i=0;i<4;++i)
        {
            int nextY = y + vy[i];
            int nextX = x + vx[i];
            if(0<=nextY && nextY < n &&
               0<=nextX && nextX < n )
            {
                if(arr[nextY][nextX]!=0 && area != arr[nextY][nextX])
                {
                    dist = min(dist,dist_arr[y][x]);
                }
                else if(0<=nextY && nextY < n &&
                        0<=nextX && nextX < n &&
                        arr[nextY][nextX] == 0 &&
                        dist_arr[y][x]+1<dist_arr[nextY][nextX])
                {
                    if(arr[y][x]!=0)
                    {
                        dist_arr[nextY][nextX] = 1;
                    }
                    else{
                        dist_arr[nextY][nextX] = dist_arr[y][x] + 1;
                    }
                    
                    qY.push(nextY);
                    qX.push(nextX);
                    
                }
            }
            
        }
    }
}
void init()
{
    for(int i=0;i<n;++i)
    {
        for(int j=0;j<n;++j)
        {
            if(arr[i][j]==0)
            {
                dist_arr[i][j] = 987654321;
            }
        }
    }
}

void solution()
{
    
    for(int i=0;i<n;++i)
    {
        for(int j=0;j<n;++j)
        {
            if(0<arr[i][j])
            {
                bfs(i,j,arr[i][j]);
                init();
            }
        }
    }
}

void dfs(int y,int x,int cnt)
{
    arr[y][x] = cnt;
    for(int i=0;i<4;++i)
    {
        int nextY = y+vy[i];
        int nextX = x+vx[i];
        
        if(0<=nextY && nextY < n &&
           0<=nextX && nextX < n &&
           arr[nextY][nextX] == 1)
        {
            dfs(nextY,nextX,cnt);
        }
    }
}

void divisionArea()
{
    int cnt = 2;
    for(int i=0;i<n;++i)
    {
        for(int j=0;j<n;++j)
        {
            if(arr[i][j]==1)
            {
                dfs(i,j,cnt++);
            }
        }
    }
    
}

int main()
{
    cin>>n;
    for(int i=0;i<n;++i)
    {
        for(int j=0;j<n;++j)
        {
            cin>>arr[i][j];
            
            if(arr[i][j]!=1)
                dist_arr[i][j] = 987654321;
            else
            {
                dist_arr[i][j] = 0;
            }
        }
    }
    divisionArea();
    solution();
    
    cout<<dist<<endl;
    
    return 0;
}
