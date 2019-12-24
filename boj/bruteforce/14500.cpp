#include <iostream>
#include <algorithm>

using namespace std;

int width, height;
int map[501][501];

int vx[4] = {1,0,-1,0};
int vy[4] = {0,1,0,-1};
int answer=0;

void initialize(){
    cin>>height>>width;
    for(int i=0;i<height;++i){
	for(int j=0;j<width;++j){
	    cin>>map[i][j];
	}
    }
}
bool safe(int y,int x){
    return 0<=y&&y<height&&0<=x&&x<width;
}

void shape1Check(int y,int x,int direction,int depth,int result){
    if(depth==4){
	answer = max(answer,result);
	return;
    }
    if(!safe(y,x)) return;

    result += map[y][x];
    int nextY = y + vy[direction];
    int nextX = x + vx[direction];
    shape1Check(nextY,nextX,direction,depth+1,result);
}

void shape2Check(int y,int x,int direction,int depth,int result){
    if(depth==4){
	answer = max(answer,result);
	return;
    }
    if(!safe(y,x)) return;

    result += map[y][x];
    int nextY = y + vy[direction];
    int nextX = x + vx[direction];
    shape2Check(nextY,nextX,(direction+1)%4,depth+1,result);
}

void shape3Check(int y,int x,int direction,int depth,int result){
    if(depth==4){
	answer = max(answer,result);
	return;
    }
    if(!safe(y,x)) return;

    result += map[y][x];
    if(depth==1){
	shape3Check(y + vy[(direction+1)%4],x + vx[(direction+1)%4],direction,depth+1,result);
	shape3Check(y + vy[(direction+3)%4],x + vx[(direction+3)%4],direction,depth+1,result);
	return;
    }
    int nextY = y + vy[direction];
    int nextX = x + vx[direction];
    shape3Check(nextY,nextX,direction,depth+1,result);
}

void shape4Check(int y,int x,int direction,int depth,int result){
    if(depth==4){
	answer = max(answer,result);
	return;
    }
    if(!safe(y,x)) return;

    result += map[y][x];
    int nextY = y + vy[direction];
    int	nextX = x + vx[direction];
    if(depth==1){
	int addY = y + vy[(direction+1)%4];
	int addX = x + vx[(direction+1)%4];
	if(safe(addY,addX)){
	    shape4Check(nextY,nextX,direction,depth+2,result + map[addY][addX]);
	    return;
	}
	addY = y + vy[(direction+3)%4];
	addX = x + vx[(direction+3)%4];
	if(safe(addY,addX)){
	    shape4Check(nextY,nextX,direction,depth+2,result + map[addY][addX]);
	    return;
	}
    }
    shape4Check(nextY,nextX,direction,depth+1,result);
}

void shape5Check(int y,int x,int direction,int depth,int result){
    if(depth==4){
	answer = max(answer,result);
	return;
    }
    if(!safe(y,x)) return;

    result += map[y][x];
    int nextY = y + vy[direction];
    int nextX = x + vx[direction];
    if(depth==2){
	shape5Check(y + vy[(direction+1)%4],x + vx[(direction+1)%4],direction,depth+1,result);
	shape5Check(y + vy[(direction+3)%4],x + vx[(direction+3)%4],direction,depth+1,result);
	return;
    }
    shape5Check(nextY,nextX,direction,depth+1,result);
}

void shapeCheck(int y,int x){
    for(int i=0;i<4;++i){
	shape1Check(y,x,i,0,0);
	shape2Check(y,x,i,0,0);
	shape3Check(y,x,i,0,0);
	shape4Check(y,x,i,0,0);
	shape5Check(y,x,i,0,0);
    }
}

void solution(){
    for(int i=0;i<height;++i){
	for(int j=0;j<width;++j){
	    shapeCheck(i,j);
	}
    }
    cout<<answer<<endl;
}

int main(){
    initialize();
    solution();
    return 0;
}