#include <iostream>
#include <cstdio>

using namespace std;

bool arr[2000001] = {0,};

int main(){
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;++i){
        int ins;
        scanf("%d",&ins);
        ins += 1000000;
        arr[ins] = true;
    }
    for(int i=2000000;0<=i;--i){
        if(arr[i]) printf("%d\n",i-1000000);
    }
    return 0;
}