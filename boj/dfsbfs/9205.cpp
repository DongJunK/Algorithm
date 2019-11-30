#include <iostream>
#include <vector>
using namespace std;
vector<int> conv_x;
vector<int> conv_y;
int now[2];
int dest[2];
bool flag;
int convenience;

bool dist(int now_x,int now_y,int dest_x,int dest_y){
    return abs(dest_x-now_x)+abs(dest_y-now_y) <= 1000 ? true : false;
}

void dfs(int now_x,int now_y,int now){
    if(dist(now_x,now_y,dest[0],dest[1])){
        flag = true;
        return;
    }
    if(convenience < now){
        return;
    }
    for(int i=0;i<conv_x.size();++i){
        if(conv_x.at(i)!=40000&&conv_y.at(i)!=40000){
            if(dist(now_x,now_y,conv_x.at(i),conv_y.at(i))){
                int next_x = conv_x.at(i);
                int next_y = conv_y.at(i);
                conv_x.at(i) = 40000;
                conv_y.at(i) = 40000;
                dfs(next_x,next_y,now+1);
            }
        }
    }
}

void solution(){
    dfs(now[0],now[1],0);
    
    if(flag){
        cout<<"happy"<<endl;
    }else{
        cout<<"sad"<<endl;
    }
}

int main(){
    int test_case;
    cin>>test_case;
    for(int i=0;i<test_case;++i){  
        flag = false;
        
        cin>>convenience;
        cin>>now[0]>>now[1];
        
        for(int i=0;i<convenience;++i){
            int x,y;
            cin>> x>> y;
            conv_x.insert(conv_x.begin(),x);
            conv_y.insert(conv_y.begin(),y);
        }
        cin>>dest[0]>>dest[1];
        solution();
        conv_x.clear();
        conv_y.clear();
    }
    return 0;
}