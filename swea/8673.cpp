#include <cstdio>
#include <vector>
#include <cmath>

using namespace std;

int T,K;
vector<int> value;


void solution(int cnt){
    int result = 0;
    for(int i=0;i<K;++i){
        vector<int> win_value;
        
        int cycle = value.size()/2;
        for(int j=0;j<cycle;++j){
            int first_value = value.back();
            value.pop_back();
            int second_value = value.back();
            value.pop_back();
            win_value.push_back(max(first_value,second_value));
            result += abs(first_value-second_value);
        }
        swap(value,win_value);
    }
    printf("#%d %d\n",cnt,result);
}

void initialization(){
    scanf("%d",&T);
    for(int i=1;i<=T;++i){
        scanf("%d",&K);
        for(int j=0;j<pow(2,K);++j){
            int insert_value;
            scanf("%d",&insert_value);
            value.push_back(insert_value);
        }
        solution(i);
    }
    

}
int main(){
    initialization();
    return 0;
}