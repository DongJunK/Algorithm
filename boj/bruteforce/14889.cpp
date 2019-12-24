#include <iostream>
#include <algorithm>
using namespace std;

int team[21][21];
int team_size;
int result=123456789;
bool join_team[21]={0,};

void dfs(int team_num, int cnt){
    if(cnt==team_size/2){
        int start=0;
        int link=0;
        for(int i=0;i<team_size;++i){
            for(int j=0;j<team_size;++j){
                if(i==j) continue;
                if(join_team[i] && join_team[j]){
                    start +=team[i][j];
                }else if(!join_team[i] && !join_team[j]){
                    link += team[i][j];
                }
            }
        }
        result = min(result,abs(start-link));
        return;
    }
    for(int i=team_num;i<team_size;++i){
        if(join_team[i] == false){
            join_team[i] = true;
            dfs(i,cnt+1);
            join_team[i] = false;
        }
    }
}

int main(){
    cin>>team_size;

    for(int i=0;i<team_size;++i){
        for(int j=0;j<team_size;++j){
            cin>>team[i][j];
        }
    }
    dfs(0,0);
    cout<<result<<endl;
    return 0;
}