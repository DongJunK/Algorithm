#include <iostream>
using namespace std;
int arr[51];

int main(){
    int n,k,result=0;
    cin>>n>>k;
    long long num=1;
    for(int i=0;i<n;++i){
        num*=2;
    }
    for(int i=1;i<=num;++i){
        if(i%3==0){
            int cnt=0;
            int tmp = i;
            while(1){
                if(tmp%2==1){
                    ++cnt;
                }
                tmp/=2;
                if(tmp==0) break;
            } 
            if(cnt==k){
                ++result;
            }
        }
    }
    cout<<result<<endl;
    return 0;
}