#include <iostream>
#include <vector>

using namespace std;

int len;
string without_space;
vector<int> result;
bool flag = false;
bool visit[51] = {0,};

void dfs(int idx){

    if(idx == without_space.length()){
        flag = true;
        return;
    }
    string number = "";

    for(int i=idx;i<=idx+1;++i){
        number += without_space[i];
        int num = stoi(number);
        
        if(visit[num]) continue;
        if(len < num) continue;
        
        visit[num] = true;
        result.push_back(num);
        dfs(i+1);
        if(flag) return;
        visit[num] = false;
        result.pop_back();
        
    }
}

int main(){
    cin>>without_space;
    if(without_space.length()<10){
        len = without_space.length();
    }else{
        len = (without_space.length()-9)/2 + 9;
    }
    dfs(0);
    for(int i=0;i<result.size();++i){
        cout<<result.at(i)<<" ";
    }
    cout<<endl;

    return 0;
}