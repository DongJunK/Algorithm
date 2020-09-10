#include <iostream>
#include <algorithm>

using namespace std;

int width,height,ladder_n;
bool ladder[11][31];
int answer=4;

void initialization(){
    cin>>width>>ladder_n>>height;
    for(int i=0;i<=width;++i){
        for(int j=0;j<=height;++j){
            ladder[i][j] = false;
        }
    }

    for(int i=0;i<ladder_n;++i){
        int location, who_ladder;
        cin>>location>>who_ladder;
        ladder[who_ladder][location] = true;
    }
}

bool play_ladder(int ladder_num){
    int now_location = 1;
    int ladder_check = ladder_num;
    
    while(now_location<=height){
        if(ladder_check < width && ladder[ladder_check][now_location]){
            ladder_check +=1;
        }else if(1 < ladder_check && ladder[ladder_check-1][now_location]){
            ladder_check -=1;
        }
        ++now_location;
    }
    if(ladder_num != ladder_check){
        return false;
    }
    return true;
}
bool opinion_ladder(int cur, int cnt,int target){
    if(cnt==target){
        for(int i=1;i<=width;++i){
            if(!play_ladder(i)){
                return false;
            }
        }
        return true;
    }

    for(int i=1;i<=width;++i){
        for(int j=cur;j<=height;++j){
            if(ladder[i][j]) continue;
            if((i<width&&ladder[i+1][j])||(1<i&&ladder[i-1][j])){
                continue;
            }
            ladder[i][j] = true;
            if(opinion_ladder(j,cnt+1,target)) return true;
            ladder[i][j] = false;
        }
    }
    return false;
}
void solution(){
    for(int i=0;i<4;++i){
        if(opinion_ladder(1,0,i)){
            cout<<i<<endl;
            return;
        }
    }
    cout<<-1<<endl;
}

int main(){    
    initialization();
    solution();
    return 0;
}