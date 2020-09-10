#include <iostream>
#include <queue>
using namespace std;

int vx[4] = {1,0,-1,0};
int vy[4] = {0,1,0,-1};

int map_size;
int apple_n;
int change_n;
int map[101][101];
int turn[10001]={0,};
int now_direction = 0;
queue< pair<int,int> > snake;


int solution(){
    snake.push(pair<int,int>(1,1));
    int result = 0;
    int now_x=1,now_y=1;
    map[1][1] = -1;
    for(int i = 1;i<10001;++i){
        ++result;
        now_direction += turn[i];
        if(now_direction==-1){
            now_direction = 3;
        }else if(now_direction==4){
            now_direction = 0;
        }

        now_x += vx[now_direction];
        now_y += vy[now_direction];
        
        if(!(0<now_x&&now_x<=map_size 
        && 0<now_y&&now_y<=map_size)
        || (map[now_y][now_x] == -1)){
            break;
        }

        if(map[now_y][now_x]!=1){
            pair<int,int> tail;
            tail = snake.front();
            snake.pop();
            map[tail.second][tail.first] = 0;
        }
        snake.push(pair<int,int>(now_x,now_y));
        map[now_y][now_x] = -1;
        
    }
    return result;
}

int main(){
    cin>>map_size >> apple_n;
    for(int i=1;i<=map_size;++i){
        for(int j=1;j<=map_size;++j){
            map[i][j] = 0;
        }
    }
    for(int i=0;i<apple_n;++i){
        int apple_x,apple_y;
        cin>>apple_y>>apple_x;
        map[apple_y][apple_x] = 1;
    }
    cin>>change_n;
    for(int i=0;i<change_n;++i){
        int change_time;
        char direction;
        cin>>change_time>>direction;
        if(direction=='L'){
            turn[change_time+1] = -1;
        }else if(direction=='D'){
            turn[change_time+1] = 1;
        }
    }
    cout<<solution()<<endl;

    return 0;
}