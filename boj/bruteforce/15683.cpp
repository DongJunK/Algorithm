#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int map[9][9];
int width,height;

int vx[4] = {0,1,0,-1};
int vy[4] = {-1,0,1,0};

int answer = 123456789;
vector<pair<int,int> > cctv;

bool safe(int y,int x){
    return 0<=x && x<width && 0<=y && y<height;
}

void check_cctv_zone(int nowY,int nowX,int direction){
    int nextY = nowY+vy[direction];
    int nextX = nowX+vx[direction];
    if(!safe(nextY,nextX) || map[nextY][nextX] == 6) return;
    
    if(map[nextY][nextX] == 0){
        map[nextY][nextX] = -1;
    }
    check_cctv_zone(nextY,nextX,direction);
}

int num_secret_area(){
    int result=0;
    for(int i=0;i<height;++i){
        for(int j=0;j<width;++j){
            if(map[i][j] == 0){
                ++result;
            }
        }
    }
    return result;
}
void change_map(int m1[][9],int m2[][9]){
    for(int i=0;i<height;++i){
        for(int j=0;j<width;++j){
            m1[i][j] = m2[i][j];
        }
    }
}

void dfs(int cnt){
    if(cctv.size() == cnt){
        answer = min(answer,num_secret_area());
        return;
    }
    int nowY = cctv.at(cnt).first;
    int nowX = cctv.at(cnt).second;

    int map2[9][9];
    change_map(map2,map);

    switch(map[nowY][nowX]){
        case 1:
            for(int i=0;i<4;++i){
                check_cctv_zone(nowY,nowX,i);
                dfs(cnt+1);
                change_map(map,map2);
            }
            break;
        case 2:
            for(int i=0;i<2;++i){
                check_cctv_zone(nowY,nowX,i);
                check_cctv_zone(nowY,nowX,i+2);
                dfs(cnt+1);
                change_map(map,map2);
            }
            break;
        case 3:
            for(int i=0;i<4;++i){
                check_cctv_zone(nowY,nowX,i);
                check_cctv_zone(nowY,nowX,(i+1)%4);
                dfs(cnt+1);
                change_map(map,map2);
            }
            break;
        case 4:
            for(int i=0;i<4;++i){
                check_cctv_zone(nowY,nowX,i);
                check_cctv_zone(nowY,nowX,(i+1)%4);
                check_cctv_zone(nowY,nowX,(i+2)%4);
                dfs(cnt+1);
                change_map(map,map2);
            }
            break;
        case 5:
            for(int i=0;i<4;++i){
                check_cctv_zone(nowY,nowX,i);
            }
            dfs(cnt+1);
            break;
    }
}

void solution(){
    dfs(0);
    cout<<answer<<endl;
}

void initialization(){
    cin>>height>>width;
    for(int i=0;i<height;++i){
        for(int j=0;j<width;++j){
            cin>>map[i][j];
            if(1<=map[i][j] && map[i][j]<=5) {
                cctv.push_back(make_pair(i,j));
            }
        }
    }
}

int main(){
    initialization();
    solution();
    
    return 0;
}