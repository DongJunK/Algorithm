#include <iostream>

using namespace std;

bool map[101][101];

void solution(int x1,int y1,int x2,int y2){
    for(int i=y1;i<y2;++i){
        for(int j=x1;j<x2;++j){
            map[i][j] = true;
        }
    }
}

void initialization(){
    for(int i=0;i<101;++i){
        for(int j=0;j<101;++j){
            map[i][j] = 0;
        }
    }
    for(int i=0;i<4;++i){
        int x1,y1,x2,y2;
        cin>>x1>>y1>>x2>>y2;
        solution(x1,y1,x2,y2);
    }
}
int answer(){
    int result = 0;
    for(int i=0;i<101;++i){
        for(int j=0;j<101;++j){
            if(map[i][j])++result;
        }
    }
    return result;
}
int main(){
    initialization();
    cout<<answer()<<endl;
    return 0;
}