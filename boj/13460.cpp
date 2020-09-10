#include <iostream>
#include <algorithm>

using namespace std;

char map[11][11];
int vx[4] = {1,-1,0,0};
int vy[4] = {0,0,-1,1};
int height,width;
int result = 11;
pair<int,int> red_ball;
pair<int,int> blue_ball;

void initialization(){
    cin>>height>>width;
    for(int i=0;i<height;++i){
        for(int j=0;j<width;++j){
            cin>>map[i][j];
            if(map[i][j] == 'R'){
                red_ball.first = i;
                red_ball.second = j;
            }else if(map[i][j] == 'B'){
                blue_ball.first = i;
                blue_ball.second = j;
            }
        }
    }
}
void play(int direction,int cnt){
    
}
void solution(){
    
}
int main(){
    initialization();
    solution();
    return 0;
}