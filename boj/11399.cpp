#include <iostream>
#include <algorithm>

int arr[1001];
int n;
using namespace std;

int main(){
    int result=0, answer = 0;
    cin>>n;
    for(int i=0;i<n;++i){
        cin>>arr[i];
    }
    sort(arr,arr+n);
    for(int i=0;i<n;++i){
        result = result + arr[i];
        answer += result;
    }
    cout<<answer<<endl;

    return 0;
}