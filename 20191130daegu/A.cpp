#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n;
int arr[100001];
int result_max = -1;
int result_min = 123456789;

void plus_minus(int start,int end){
    int score_max=-1;
    if(end-start == 0){
        result_max = max(result_max,1);
        result_min = min(result_min,0);
        return;
    }
    for(int i=start;i<end;++i){
        if(score_max<=arr[i]-arr[i+1]){
            result_max = max(result_max,i+1-start);
            result_min = min(result_min,end-i);
            score_max = max(score_max,arr[i]-arr[i+1]);
        }
    }
}
void sort_arr(){
    for(int i=0;i<n/2;++i){
        int tmp = arr[i];
        arr[i] = arr[(n-1)-i];
        arr[(n-1)-i] = tmp;
    }
}

void solution(){
    int a_n,b_n,c_n;

    a_n = n * 0.3;
    b_n = n * 0.7 - a_n;
    c_n = n - a_n - b_n;

    plus_minus(0,a_n-1);
    plus_minus(a_n,a_n+b_n-1);
    plus_minus(a_n+b_n,n-1);

    cout<<result_max<<" "<<result_min<<endl;
}
int main(){
    cin>>n;
    for(int i=0;i<n;++i){
        cin>>arr[i];
    }
    sort(arr,arr+n);
    sort_arr();
    solution();
    return 0;
}