#include <iostream>
#include <queue>
using namespace std;

int cnt=0;
int year=0;
int map[301][301];
int sink[301][301]={0,};
bool visit[301][301];
int vx[4]= {1,-1,0,0}; // 좌 우
int vy[4]= {0,0,1,-1}; // 상 하
int n,m;

int sea_check(int next_y,int next_x)
{
    if(map[next_y][next_x]==0)
    {
        return 1;
    }
    return 0;
}

void sink_calculate()
{
    for(int i=0;i<n;++i)
    {
        for(int j=0;j<m;++j)
        {
            map[i][j] -= sink[i][j];
            if(map[i][j]<0)
            {
                map[i][j] = 0;
            }
            // 초기화
            sink[i][j] = 0;
            visit[i][j] = false;
        }
    }
}

// 대륙을 발견했을 때 대륙 확인.
void dfs(int y,int x)
{
    visit[y][x] = true;

    int cnt = 0;
    for(int i=0;i<4;++i)
    {
        int next_x = x + vx[i];
        int next_y = y + vy[i];

        cnt += sea_check(next_y,next_x); // 바다 인지 체크 

        if( 0 <= next_x && next_x < m &&
            0 <= next_y && next_y < n )
        {
            
            if(0 < map[next_y][next_x] && 
            visit[next_y][next_x] == false)
            {
                dfs(next_y,next_x);
            }
        }
    }
    sink[y][x] = cnt; // 주변 바다 개수 입력
}


// 맵 전체 dfs
int dfs_loop()
{
    int cnt =0;
    for(int i=0;i<n;++i)
    {
        for(int j=0;j<m;++j)
        {
            if(0<map[i][j] && visit[i][j] == false)
            {
                dfs(i,j);
                ++cnt;
            }
        }
    }
    
    sink_calculate();
    return cnt;
}

int solution()
{
    int year = 0; // 년 수
    int continent; // 대륙 개수
    while(1)
    {
        continent = dfs_loop(); // 대륙 갯수 계산
        if(continent==0)
        {
            return 0;
        }
        if(1 < continent) // 대륙 갯수 2개 이상일 경우
        {
            break;
        }
        
        ++year;
        
    }
    return year;
}

int main(int argc, const char * argv[]) {
    
    cin>>n>>m;
    for(int i=0;i<n;++i)
    {
        for(int j=0;j<m;++j)
        {
            cin>>map[i][j];
            visit[i][j] = false;
        }
    }
    cout<<solution()<<endl;
    return 0;
}
