#include <iostream>
#include <algorithm>

using namespace std;

typedef struct robot{
    int x;
    int y;
    int sight;
}robot;

int vx[4] = {0,1,0,-1};
int vy[4] = {-1,0,1,0};

int map[51][51];
int map_x_size, map_y_size;
robot robot_info;

bool range_check(int x, int y){
    return 0<=x&&x<map_x_size&&0<=y&&y<map_y_size;
}

int solution(){
    int result = 0;
    
    while(1){
        if(map[robot_info.y][robot_info.x]==0){
            ++result;
            map[robot_info.y][robot_info.x] = 2;
        }
        int next_y;
        int next_x;
        int sight = robot_info.sight;
        if(sight==0){
            sight = 3;
            next_y = robot_info.y + vy[sight];
            next_x = robot_info.x + vx[sight];
            
        }else{
            sight -= 1;
            next_y = robot_info.y + vy[sight];
            next_x = robot_info.x + vx[sight];
        }
 
        if(map[next_y][next_x] == 0){
            robot_info.y = next_y;
            robot_info.x = next_x;
            robot_info.sight = sight;
        }else{
            if(robot_info.sight <2){
                    next_y = robot_info.y + vy[robot_info.sight+2];
                    next_x = robot_info.x + vx[robot_info.sight+2];
            }else{
                    next_y = robot_info.y + vy[robot_info.sight-2];
                    next_x = robot_info.x + vx[robot_info.sight-2];
            }
            bool flag=false;
            for(int i=0;i<4;++i){
                if(map[robot_info.y+vy[i]][robot_info.x+vx[i]] == 0){
                    flag=true;
                }
            }
            if(!range_check(robot_info.x,robot_info.y) || (!flag && map[next_y][next_x]==1)){
                    break;
            }
            if(flag){ // 조건 2.c, 2.d
                robot_info.sight = sight;
            }
            else{
                robot_info.y = next_y;
                robot_info.x = next_x;
            }
        }
    }

    return result;
}

int main(){
    cin>>map_y_size>>map_x_size;
    cin >> robot_info.y >> robot_info.x >> robot_info.sight;
    for(int i=0;i<map_y_size;++i){
        for(int j=0;j<map_x_size;++j){
            cin>>map[i][j];
            
        }
    }
    cout<<solution()<<endl;

    return 0;
}