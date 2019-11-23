#include <iostream>
#include <string>
#include <queue>
#include <algorithm>
using namespace std;

int vx[4] = {1,-1,0,0};
int vy[4] = {0,0,1,-1};
int grid[26][26];
vector<int> result;

int N,cnt=0;
void dfs(int y,int x)
{
    ++cnt;
    grid[y][x] = 0;
    for(int i=0;i<4;++i)
    {
        int nextX = x+vx[i];
        int nextY = y+vy[i];
        if(0<=nextX && nextX<N &&
           0<=nextY && nextY<N &&
           grid[nextY][nextX] == 1)
        {
            dfs(nextY,nextX);
        }
    }
}

void solution(){
    for(int i=0;i<N;++i){
        for(int j=0;j<N;++j){
            if(grid[i][j]==1){
                dfs(i,j);
                result.push_back(cnt);
                cnt=0;
            }
            
        }
    }
}

int main(){
    cin>>N;
    string danji;
    for(int i=0;i<N;++i){
        cin>>danji;
        for(int j=0;j<N;++j){
            grid[i][j] = danji[j]-'0';
            
        }
    }
    solution();
    
    cout<<result.size()<<endl;
    sort(result.begin(),result.end());
    for(vector<int>::size_type i = 0 ;i<result.size();++i){
        cout<<result.at(i)<<'\n';
    }
    return 0;
}
