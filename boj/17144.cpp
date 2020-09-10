#include <iostream>
#include <queue>
using namespace std;

int map[51][51];
int width,height,T;
int next_map[51][51];

int vx[4] = {-1,1,0,0};
int vy[4] = {0,0,1,-1};
pair<int,int> air_cleaner_top;
pair<int,int> air_cleaner_bottom;

void initialization(){
    bool flag = true;
    cin>>height>>width>>T;
    for(int i=0;i<height;++i){
        for(int j=0;j<width;++j){
            cin>>map[i][j];
            if(map[i][j]==-1){
                if(flag){
                    air_cleaner_top.first = i;
                    air_cleaner_top.second = j;
                    flag = false;
                }else{
                    air_cleaner_bottom.first = i;
                    air_cleaner_bottom.second = j;
                }
            }
        }
    }
}

bool safe(int y, int x){
    return 0<=y&&y<height&&0<=x&&x<width;
}

// topOrBottom -> 1 : top / 0 : bottom
int check_air_direction(int topOrBottom,int y,int x,int direction){
    int result;
    int nextY = y + vy[direction];
    int nextX = x + vx[direction];

    if(safe(nextY,nextX)) return direction;

    if(topOrBottom){  
        switch (direction)
        {
            case 0:
                result = 2;
                break;
            case 1:
                result = 3;
                break;
            case 2:
                result = 1;
                break;
            case 3:
                result = 0;
                break;
        }
    }else{
        switch (direction)
        {
            case 0:
                result = 3;
                break;
            case 1:
                result = 2;
                break;
            case 2:
                result = 0;
                break;
            case 3:
                result = 1;
                break;
        }
    }
    return result;
}

void air_cleaner(int topOrbottom,int startY,int startX,int direction){
    int nowY = startY;
    int nowX = startX;
    queue<int> move_dust;
    move_dust.push(0);
    while(1){
        direction = check_air_direction(topOrbottom,nowY,nowX,direction);
        int nextY = nowY + vy[direction];
        int nextX = nowX + vx[direction];
        if(startY == nextY && startX == nextX) break;
        move_dust.push(map[nextY][nextX]);
        map[nextY][nextX] = move_dust.front();
        move_dust.pop();
        nowY = nextY;
        nowX = nextX;
    }
}


void air_cleaner_run(){
    air_cleaner(1,air_cleaner_top.first,air_cleaner_top.second,1);
    air_cleaner(0,air_cleaner_bottom.first,air_cleaner_bottom.second,1);
}

void copy_map(int apply_map[][51],int assign_map[][51]){
    for(int i=0;i<height;++i){
        for(int j=0;j<width;++j){
            apply_map[i][j] = assign_map[i][j];
        }
    }
}

void spread_dust_around(int y,int x){
    int amount_spread_dust = map[y][x]/5;
    int spread_n = 0;

    for(int i=0;i<4;++i){
        int nextY = y+vy[i];
        int nextX = x+vx[i];
        if(safe(nextY,nextX) && map[nextY][nextX] != -1){
            next_map[nextY][nextX] += amount_spread_dust;
            ++spread_n;
        }
    }

    next_map[y][x] += map[y][x] - (amount_spread_dust * spread_n);
}



void spread_dust(){
    for(int i=0;i<height;++i){
        for(int j=0;j<width;++j){
            if(map[i][j]==-1){
                next_map[i][j] = -1;
                continue;
            }
            next_map[i][j] = 0;
        }
    }

    for(int i=0;i<height;++i){
        for(int j=0;j<width;++j){
            if(0 < map[i][j]) spread_dust_around(i,j);
        }
    }
    copy_map(map,next_map);
}

int check_dust(){
    int result = 0;
    for(int i=0;i<height;++i){
        for(int j=0;j<width;++j){
            if(map[i][j]==-1) continue;
            result += map[i][j];
        }
    }
    return result;
}

void solution(){
    while(T--){
        spread_dust();
        air_cleaner_run();
    }
    cout<<check_dust()<<endl;
}

int main(){
    initialization();
    solution();
    
    return 0;
}