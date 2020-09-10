#include <iostream>
#include <string>
#include <stack>
#include <vector>

using namespace std;

bool bracket_check(char check, stack<char> bracket){
    char check_n;
    stack<char> tmp_bracket = bracket;
    switch(check){
        case ']':
            check_n = '[';
            break;
        case '}':
            check_n = '{';
            break;
        case ')':
            check_n = '(';
            break;
    }
    while(!tmp_bracket.empty()){
        if(tmp_bracket.top()==check_n){
            return true;
        }else if(tmp_bracket.top()==check){
            return false;
        }
        tmp_bracket.pop();
    }
    return false;
}
bool solution(string input) {
    bool answer = true;
    stack<char> brac;
    for(int i=0;i<input.length();++i){
        if(input[i] == '[' || input[i] == '{' || input[i] == '(')
        {
            brac.push(input[i]);
        }else if(input[i] == ']' || input[i] == '}' || input[i] == ')'){
            if(bracket_check(input[i],brac)){
                brac.pop();
            }else{
                answer = false;
                break;
            }
        }
    }
    return answer;
}

int main(){
    string str;
    cin>>str;
    cout<<solution(str)<<endl;
    return 0;
}