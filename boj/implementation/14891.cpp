#include <iostream>
#include <deque>
#include <cmath>

using namespace std;
deque<int> gear[5];
int turn[101][2];
int tmp_turn[5]={0,};
int turn_n;

void turn_gear(int now, int turn_direction){
    if(turn_direction == 0 ) return;

    if(turn_direction==1){
        int change = gear[now].back();
        gear[now].pop_back();
        gear[now].push_front(change);
    }else{
        int change = gear[now].front();
        gear[now].pop_front();
        gear[now].push_back(change);
    }
}

void check_and_turn(int now,int check_direction,int turn_direction){
    if(now  < 1 || 4 < now ) return;
    int position;
    int check_position;
    if(check_direction==1){
        position = 6;
        check_position = 2;
    }else{
        position = 2;
        check_position = 6;
    }
    
    if(gear[now + (check_direction * -1)].at(check_position) != gear[now].at(position)){
        tmp_turn[now] = turn_direction;
        check_and_turn(now + check_direction, check_direction, turn_direction * -1);
    }
}

int solution(){
    
    for(int i=0;i<turn_n;++i){
        tmp_turn[turn[i][0]] = turn[i][1];
        check_and_turn(turn[i][0]-1,-1, turn[i][1] * -1);
        check_and_turn(turn[i][0]+1,1, turn[i][1] * -1);
        for(int j=1;j<=4;++j){
            turn_gear(j,tmp_turn[j]);
            tmp_turn[j] = 0;
        }
    }
    int result = 0;
    for(int i=1;i<=4;++i){
        result += gear[i].front() * pow(2,i-1);
    }
    return result;
}

int main(){
    for(int i=1;i<=4;++i){
        string pole;
        cin>>pole;
        for(int j=0;j<8;++j){
            gear[i].push_back(pole[j]-'0');
        }
    }
    cin>>turn_n;
    for(int i=0;i<turn_n;++i){
        cin>>turn[i][0]>>turn[i][1];
    }
    
    cout<<solution()<<endl;
    return 0;
}