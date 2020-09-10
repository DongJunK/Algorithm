#include <iostream>

using namespace std;
int n;
int arr[500001];
int tmp_arr[500001];

void initiation(){
    cin>>n;
    for(int i=0;i<n;++i){
        cin>>arr[i];
    }
}

long long solve(int start, int end){
    if(start==end) return 0;
    int mid = (end + start) / 2;
    long long answer = solve(start,mid) + solve(mid+1,end);

    int i = start;
    int j = mid + 1;
    int index = start;
    while(i<=mid || j<=end){
        if(i<=mid && (end<j || arr[i] <= arr[j])){
            tmp_arr[index++] = arr[i++];
        } else {
            tmp_arr[index++] = arr[j++];
            answer += mid - i + 1;
        }
    }
    for(int i=start;i<=end;++i){
        arr[i] = tmp_arr[i];
    }
    
    return answer;
}

long long solution(){
    long long answer;
    answer = solve(0,n-1);
    return answer;
}

int main(){
    initiation();
    cout<<solution()<<endl;
    return 0;
}
