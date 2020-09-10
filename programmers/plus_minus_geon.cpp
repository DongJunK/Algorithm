#include <vector>
#include <string>
#include <algorithm>
#include <limits.h>

using namespace std;

int DPMAX(int start, int end, vector<string> arr);
int DPMIN(int start, int end, vector<string> arr);

int DPMIN(int start, int end, vector<string> arr){
    int answer = INT_MAX;
    
    if(start == end){
        return stoi(arr[start]);
    }
    
    for(int i=start; i<=end; ++i){
        if(arr[i] == "+"){
            answer = min(DPMAX(start,i-1,arr) + DPMAX(i+1,end,arr),answer);
            
        }
        else if(arr[i] == "-"){
            answer = min(DPMAX(start,i-1,arr) - DPMIN(i+1,end,arr),answer);
        }
        else
            continue;
    }
    
    return answer;
}

int DPMAX(int start, int end, vector<string> arr){
    int answer = INT_MIN;
    
    if(start == end){
        return stoi(arr[start]);
    }
    
    for(int i=start; i<=end; ++i){
        if(arr[i] == "+"){
            answer = max(DPMAX(start,i-1,arr) + DPMAX(i+1,end,arr),answer);
            
        }
        else if(arr[i] == "-"){
            answer = max(DPMAX(start,i-1,arr) - DPMIN(i+1,end,arr),answer);
        }
        else
            continue;
    }
    
    return answer;
}


int solution(vector<string> arr)
{
    int answer = DPMAX(0,arr.size()-1,arr);
    
    return answer;
}