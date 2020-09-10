#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int vx[4] = {-1,1,0,0};
int vy[4] = {0,0,-1,1};
int map[21][21];
int n;
int result = 0;
queue<int> one_line;

void initialization(){
    cin>>n;
    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            cin>>map[i][j];
        }
    }
}

bool safe(int x,int y){
    return 0<=x&&x<n&&0<=y&&y<n;
}

void find_max_value(){
    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            result = max(result,map[i][j]);
        }
    }
}

void copy_array(int copied_map[][21],int copy_map[][21]){
    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            copied_map[i][j] = copy_map[i][j];
        }
    }
}

void insert_line(int start_x,int start_y,int direction){
    int now_x = start_x;
    int now_y = start_y;
    while(1){
        if(!safe(now_x,now_y)) break;

        if(!one_line.empty()){
            map[now_y][now_x] = one_line.front();
            one_line.pop();
        }else{
            map[now_y][now_x] = 0;
        }
        now_x += vx[direction];
        now_y += vy[direction];
    }
}

void check_line(int start_x,int start_y,int direction){
    int now_x = start_x;
    int now_y = start_y;
    while(1){
        if(!safe(now_x,now_y)) break;

        if(map[now_y][now_x]==0){
            now_x += vx[direction];
            now_y += vy[direction];
            continue;
        }
        int next_x = now_x;
        int next_y = now_y;
        while(1){
            next_x += vx[direction];
            next_y += vy[direction];

            if(!safe(next_x,next_y)){
                one_line.push(map[now_y][now_x]);
                break;
            }
            if(map[now_y][now_x]==map[next_y][next_x]){
                one_line.push(map[now_y][now_x] + map[next_y][next_x]);
                map[next_y][next_x] = 0;
                break;
            }
            else if(map[next_y][next_x] != 0){
                one_line.push(map[now_y][now_x]);
                break;
            }
            
        }
        now_x += vx[direction];
        now_y += vy[direction];
    }
    insert_line(start_x,start_y,direction);
}

void merge_block(int direction){
    if(direction==0){
        for(int i=0;i<n;++i){
            check_line(0,i,direction+1);
        }
    }else if(direction==1){
        for(int i=0;i<n;++i){
            check_line(n-1,i,direction-1);
        }
    }else if(direction==2){
        for(int i=0;i<n;++i){
            check_line(i,0,direction+1);
        }
    }else{
        for(int i=0;i<n;++i){
            check_line(i,n-1,direction-1);
        }
    }

}
void print_map(){
    cout<<endl;
    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            cout<<map[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
}

void play(int direction,int cnt){
    merge_block(direction);
    if(cnt==5){
        find_max_value();
        return;
    }
    int tmp_map[21][21];
    copy_array(tmp_map,map);

    for(int i=0;i<4;++i){
        play(i,cnt+1);
        copy_array(map,tmp_map);
    }
}

void solution(){
    int tmp_map[21][21];
    copy_array(tmp_map,map);
    for(int i=0;i<4;++i){
        play(i,1);
        copy_array(map,tmp_map);
    }
    cout<<result<<endl;
}

int main(){
    initialization();
    solution();

    return 0;
}