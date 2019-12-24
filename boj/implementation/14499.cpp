#include <iostream>

using namespace std;
int vx[5] = {0,0,0,-1,1};
int vy[5] = {0,1,-1,0,0};
int n,m,x,y,k;
int map[21][21];
int dice[6]={0,}; //바닥 동 서 남 북 위

bool safe(int _x,int _y){
    return 0<=_x&&_x<n&&0<=_y&&_y<m;
}
void solution(){
    for(int i=0;i<k;++i){
        int move;
        cin>>move;
        x += vx[move];
        y += vy[move];
        int tmp_dice[6];
        if(!safe(x,y)){
            x -= vx[move];
            y -= vy[move];
            continue;
        }
        if(move==1){
            tmp_dice[0] = dice[1];
            tmp_dice[1] = dice[5];
            tmp_dice[2] = dice[0];
            tmp_dice[3] = dice[3];
            tmp_dice[4] = dice[4];
            tmp_dice[5] = dice[2];
        }else if(move==2){
            tmp_dice[0] = dice[2];
            tmp_dice[1] = dice[0];
            tmp_dice[2] = dice[5];
            tmp_dice[3] = dice[3];
            tmp_dice[4] = dice[4];
            tmp_dice[5] = dice[1];
        }else if(move==3){
            tmp_dice[0] = dice[4];
            tmp_dice[1] = dice[1];
            tmp_dice[2] = dice[2];
            tmp_dice[3] = dice[0];
            tmp_dice[4] = dice[5];
            tmp_dice[5] = dice[3];
        }else if(move==4){
            tmp_dice[0] = dice[3];
            tmp_dice[1] = dice[1];
            tmp_dice[2] = dice[2];
            tmp_dice[3] = dice[5];
            tmp_dice[4] = dice[0];
            tmp_dice[5] = dice[4];
        }
        for(int j=0;j<6;++j){
            dice[j] = tmp_dice[j];
        }
        
        if(map[x][y]==0){
            map[x][y] = dice[0];
        }else{
            dice[0] = map[x][y];
            map[x][y] = 0;
        }

        cout<<dice[5]<<endl;
    }
}

int main(){
    cin>>n>>m>>x>>y>>k;
    for(int i=0;i<n;++i){
        for(int j=0;j<m;++j){
            cin>>map[i][j];
        }
    }
    solution();
    return 0;
}