#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int map[51][51];
bool chicken[51][51];
int side;
int max_chicken;
vector< pair<int,int> > chicken_house;

int answer = 123456789;

void initialization(){
    cin>>side>>max_chicken;
    for(int i=0;i<side;++i){
        for(int j=0;j<side;++j){
            cin>>map[i][j];
            chicken[i][j] = false;
            if(map[i][j] == 2){
                chicken_house.push_back(make_pair(i,j));
            }
        }
    }
}
bool safe(int y,int x){
    return 0<=y&&y<side&&0<=x&&x<side;
}
int house_chicken_distance(int y,int x){
    int distance = 123456789;
    for(int i=0;i<chicken_house.size();++i){
        int chicken_y = chicken_house.at(i).first;
        int chicken_x = chicken_house.at(i).second;
        if(chicken[chicken_y][chicken_x]){
            distance = min(distance,abs(chicken_y-y) + abs(chicken_x-x));
        }
    }
    return distance;
}

void solve(int cur,int cnt){
    if(cnt == max_chicken){
        int result = 0;
        for(int i=0;i<side;++i){
            for(int j=0;j<side;++j){
                if(map[i][j] == 1){
                    result += house_chicken_distance(i,j);
                }
            }
        }
        answer = min(answer,result);
        return;
    }
    for(int i=cur;i<chicken_house.size();++i){
        int chicken_y = chicken_house.at(i).first;
        int chicken_x = chicken_house.at(i).second;
        chicken[chicken_y][chicken_x] = true;
        solve(i+1,cnt+1);
        chicken[chicken_y][chicken_x] = false;
    }
}


void solutoin(){
    solve(0,0);
    cout<<answer<<endl;
}

int main(){
    initialization();
    solutoin();
    return 0;
}