#include <iostream>
#include <vector>

using namespace std;

int solution(vector<int> num,int n){
    int cnt=0;
    
    while(1){
        if(num.size()==1){
            if(num.front() == 1){
                break;
            }else{
                ++cnt;
                break;
            }
            
        }
        vector<int> tmp;
        int same_num_cnt=1;
        int now_num = num.at(0);
        for(int i=1;i<num.size();++i){
            if(num.at(i) == now_num){
                ++same_num_cnt;
            }else{
                tmp.push_back(same_num_cnt);
                now_num = num.at(i);
                same_num_cnt = 1;
            }
            if(i == num.size()-1){
                tmp.push_back(same_num_cnt);
            }
        }
        num = tmp;
        ++cnt;
    }
    return cnt;
}

int main(void) {
    int n;
    cin>>n;
    vector<int> num;
    
    for(int i=0;i<n;++i){
        int insert_num;
        cin>>insert_num;
        num.push_back(insert_num);
    }
    cout<<solution(num,n)<<endl;
    return 0;
}