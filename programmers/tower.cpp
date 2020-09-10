#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    for(int i = 0; i < heights.size();++i)
    {
        bool flag = false;
        for(int j = i - 1; 0 <= j; --j)
        {
            if(heights[i]<heights[j])
            {
                answer.push_back(j+1);
                flag = true;
                break;
            }
        }
        if(!flag)
        {
            answer.push_back(0);
        }
    }
    return answer;
}