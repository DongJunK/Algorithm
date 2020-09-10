#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> remaining_days;
    for(int i=0;i<progresses.size();++i)
    {
        int remaining_day = ((100 - progresses[i]) / speeds[i]) + (((100 - progresses[i]) % speeds[i]) == 0 ? 0 : 1);
        remaining_days.push_back(remaining_day);
    }

    int cnt = 1;
    int distribute = 0;
    for(int i=1;i<remaining_days.size();++i,++cnt)
    {
        if(remaining_days[distribute] < remaining_days[i])
        {
            answer.push_back(cnt);
            cnt = 0;
            distribute = i;
        }
    }
    int total = 0;
    for(int i=0;i<answer.size();++i)
    {
        total += answer[i];
    }
    if(total != progresses.size())
    {
        answer.push_back(cnt);
    }

    return answer;
}