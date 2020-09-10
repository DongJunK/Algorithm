#include <iostream>
#include <cstdio>
using namespace std;

int arr[10001] = {0,};

int main(){
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;++i){
        int ins;
        scanf("%d",&ins);
        ++arr[ins];
    }
    for(int i=0;i<10001;++i){
        for(int j=0;j<arr[i];++j){
            printf("%d\n",i);
        }
    }
    return 0;
}