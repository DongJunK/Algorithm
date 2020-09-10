#include <string>
#include <vector>

using namespace std;

vector<int> solve(vector<int> answer)
{
    vector<int> result;
    for(int i=0;i<answer.size();++i)
    {
        result.push_back(answer[i]);
    }
    result.push_back(0);
    for(int i=answer.size()-1;0<=i;--i)
    {
        result.push_back(abs(answer[i]-1));
    }
    return result;
}

vector<int> solution(int n) {
    vector<int> answer;
    
    answer.push_back(0);
    
    for(int i=0;i<n-1;++i)
    {
        answer = solve(answer);    
    }
    return answer;
}