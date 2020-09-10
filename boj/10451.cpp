#include <iostream>
using namespace std;
int arr[1001];
bool visit[1001];

void cycle_check(int now){
    if(visit[now]){
        return;
    }
    visit[now] = true;
    cycle_check(arr[now]);
}

int solution(int n){
    int cycle_n = 0;
    for(int i=1;i<=n;++i){
        if(!visit[i]){
            cycle_check(i);
            ++cycle_n;
        }
    }
    return cycle_n;
}

int main(){
    int test_case;
    cin>>test_case;
    while(test_case--){
        int n;
        cin>>n;
        for(int i=1;i<=n;++i){
            cin>>arr[i];
            visit[i] = false;
        }
        cout<<solution(n)<<endl;
    }
    return 0;
}