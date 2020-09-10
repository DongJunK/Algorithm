#include <iostream>
#include <vector>

using namespace std;

bool map[101][101];
int N;
int vx[4] = {1,0,-1,0};
int vy[4] = {0,-1,0,1};
int answer = 0;

bool check_square(int x,int y){
    if(map[y][x]&&map[y][x+1]&&map[y+1][x+1]&&map[y+1][x]) return true;
    else return false;
}

void draw_map(int x,int y,int direction,int dragon_curve){
    map[y][x] = true;
    int nextX = x + vx[direction];
    int nextY = y + vy[direction];
    map[nextY][nextX] = true;
    
    vector<int> direction_arr;
    direction_arr.push_back(direction);
    
    while(0<dragon_curve--){
        int direction_size = direction_arr.size();
        for(int i=direction_size-1;0<=i;--i){
            int next_direction = (direction_arr.at(i) + 1) % 4;
            nextX += vx[next_direction];
            nextY += vy[next_direction];
            map[nextY][nextX] = true;
            direction_arr.push_back(next_direction);
        }
    }
}

void solution(){
    for(int i=0;i<101;++i){
        for(int j=0;j<101;++j){
            map[i][j] = 0;
        }
    }
    cin>>N;
    for(int i=0;i<N;++i){
        int x,y,direction,dragon_curve;
        cin>>x>>y>>direction>>dragon_curve;
        draw_map(x,y,direction,dragon_curve);
    }
    for(int i=0;i<101-1;++i){
        for(int j=0;j<101-1;++j){
            if(check_square(j,i)) ++answer;
        }
    }
    
    cout<<answer<<endl;
}

int main(){
    solution();
    return 0;
}