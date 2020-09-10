#include <iostream>
#include <vector>

using namespace std;

int n;
vector<int> arr;
int sort_cnt;

void initiation(){
    cin>>n;
    for(int i=0;i<n;++i){
        int value;
        cin>>value;
        arr.push_back(value);
    }
    cin>>sort_cnt;
}

void solve(){
    int now=0;
    while(now < n && sort_cnt){
        int max_index = now;
        for(int i=now;i<n;++i){
            if(arr[max_index] < arr[i] && i-now <= sort_cnt){
                max_index = i;
            }
        }
        arr.insert(arr.begin()+now,arr[max_index]);
        arr.erase(arr.begin()+max_index+1);
        sort_cnt -= max_index - now;
        ++now;
    }
}

void solution(){
    solve();
    for(int i=0;i<n;++i){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

int main(){
    initiation();
    solution();
    return 0;
}