#include <algorithm>
#include <string>
#include <vector>

using namespace std;

bool desc(int a, int b)
{
    return a > b;
}


int solution(vector<int> citations) {
    int answer = 0;
    sort(citations.begin(),citations.end(),desc);
    
    for(int i=0;i<citations.size();++i)
    {
        if(i+1 <= citations[i] && citations.size() - (i + 1) <= i + 1)
        {
            answer = max(answer, i+1);
        }
    }
    return answer;
}