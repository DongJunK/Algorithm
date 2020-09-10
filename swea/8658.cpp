#include <cstdio>
#include <algorithm>

using namespace std;

int n;
int max_value, min_value;

int sum_value(int value){
    int value_sum = 0;
    while(value){
        value_sum += value%10;
        value/=10;
    }
    return value_sum;
}
void solution(int cnt){
    for(int i=0;i<10;++i){
        int value;
        scanf("%d",&value);
        int value_sum = sum_value(value);
        min_value = min(min_value,value_sum);
        max_value = max(max_value,value_sum);
    }
    printf("#%d %d %d\n",cnt,max_value,min_value);
}
void initialization(){
    scanf("%d",&n);
    for(int i=1;i<=n;++i){
        max_value = 0;
        min_value = 100;
        solution(i);
    }
}
int main(){
    initialization();
    return 0;
}