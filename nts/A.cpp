#include <iostream>
#include <string>
#include <vector>

using namespace std;


int solution(int a, int b, int budget) {
    int answer = 0;
    for(int i=1;a*i<budget;++i){
        int leftover_budget = budget - a*i;
        if(0<=leftover_budget && leftover_budget%b==0){
            ++answer;
        }
    }
    return answer;
}

int main(){
    int a, b, budget;
    cin>>a>>b>>budget;
    cout<<solution(a,b,budget)<<endl;
    return 0;
}