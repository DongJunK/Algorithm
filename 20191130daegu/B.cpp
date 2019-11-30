#include <iostream>
#include <algorithm>
using namespace std;

int vx[4] = {-1,1,0,0};
int vy[4] = {0,0,-1,1};
int map[1001][1001];
int area[26] = {0,};
int ex_area[26] = {0,};
bool visit[1001][1001] = {0,};
int x,y;

void dfs(int now_y,int now_x){
    if(map[now_y][now_x] == -1 || visit[now_y][now_x]==true){
        return;
    }
    ++ex_area[map[now_y][now_x]];
    visit[now_y][now_x] = true;
    for(int i=0;i<4;++i){
        int next_x = now_x + vx[i];
        int next_y = now_y + vy[i];

        if(0<=next_x && next_x < x &&
        0<=next_y && next_y < y){
            dfs(next_y,next_x);
        }
    }
}

int check_max(){
    int max_area = -1;
    int _area;
    for(int i=0;i<26;++i){
        if(max_area <= ex_area[i]){
            _area = i;
            max_area = ex_area[i];
        }
    }
    return _area;
}

void expand_area(int max_area){
    for(int i=0;i<26;++i){
        if(ex_area[i]<ex_area[max_area]){
            area[max_area] += ex_area[i];
            area[i] -= ex_area[i];
        }
    }
}

void clear_ex_area(){
    for(int i=0;i<26;++i){
        ex_area[i]=0;
    }
}

int solution(){
    int result_max=-1;
    for(int i=0;i<y;++i){
        for(int j=0;j<x;++j){
            if(map[i][j] != -1 && visit[i][j] == false){
                dfs(i,j);
                int max_area = check_max();
                expand_area(max_area);
                clear_ex_area();
            }
        }
    }
    for(int i=0;i<26;++i){
        result_max = max(result_max,area[i]);
    }
    return result_max;
}

int main(){
    cin>>y>>x;
    for(int i=0;i<y;++i){
        string _input;
        cin>>_input;
        for(int j=0;j<x;++j){
            if(_input[j]=='.'){
                map[i][j] = -1;
            }else{
                map[i][j] = _input[j] - 'A';
                ++area[map[i][j]];
            }
            visit[i][j] = false;
        }
    }
    cout<<solution()<<endl;
    return 0;
}