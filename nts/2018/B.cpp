#include <iostream>
using namespace std;

int solution(long long n)
{
    long long n_tmp = n;
    bool arr[10]={0,};
	int answer = 0;
    while(n_tmp != 0){
        arr[n_tmp % 10] = true;
        n_tmp /= 10;
    }

    
    for(int i=1;i<10;++i){
        if(arr[i] == true && n % i == 0){
            ++answer;
        }
    }
	return answer;
}

int main(){
    long long n;
    cin>>n;
    cout<<solution(n)<<endl;
    
    return 0;
}