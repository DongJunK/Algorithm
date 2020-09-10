#include <iostream>
#include <algorithm>

using namespace std;

int least_multiple(int num1,int num2){
    int num = min(num1,num2);
    int result;
    for(int i=1;i<=num;++i){
        if(num1%i == 0&&num2%i == 0){
            result = i;
        }
    }
    return result;
}
int greatest_divisor(int num1,int num2, int multiple){
    int result;
    int num = max(num1,num2);
    while(1){
        if(num%num1 == 0 && num%num2 == 0){
            result = num;
            break;
        }
        ++num;
    }
    return result;
}

int main(){
    int num1,num2;
    cin>>num1>>num2;
    int multiple = least_multiple(num1,num2);
    int divisor = greatest_divisor(num1,num2,multiple);

    cout<<multiple<<endl<<divisor<<endl;
    return 0;
}