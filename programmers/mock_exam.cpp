#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int> > math_give_up;

void init_answer_order()
{
    vector<int> insert;
    for(int i=1;i<=5;++i)
    {
        insert.push_back(i);
    }
    math_give_up.push_back(insert);
    insert.clear();
    insert.push_back(2);
    insert.push_back(1);
    insert.push_back(2);
    insert.push_back(3);
    insert.push_back(2);
    insert.push_back(4);
    insert.push_back(2);
    insert.push_back(5);
    math_give_up.push_back(insert);
    insert.clear();
    insert.push_back(3);
    insert.push_back(3);
    insert.push_back(1);
    insert.push_back(1);
    insert.push_back(2);
    insert.push_back(2);
    insert.push_back(4);
    insert.push_back(4);
    insert.push_back(5);
    insert.push_back(5);
    math_give_up.push_back(insert);
}

int compare_max(int result[3])
{
    int max_result = 0;
    for(int i=0;i<3;++i)
    {
        max_result = max(max_result,result[i]);
    }
    return max_result;
}



vector<int> solution(vector<int> answers) {
    vector<int> answer;
    init_answer_order();
    int result[3] = {0,0,0};
    int now_answer[3] = {0,0,0};

    for(int i = 0; i < answers.size();++i)
    {
        for(int j=0;j<3;++j)
        {
            if(now_answer[j] == math_give_up[j].size()){
                now_answer[j] = 0;
            }
            if(math_give_up[j][now_answer[j]] == answers[i])
            {
                ++result[j];
            }
            ++now_answer[j];
        }
    }
    int min_result = compare_max(result);
    for(int i=0;i<3;++i)
    {
        if(result[i] == min_result)
        {
            answer.push_back(i+1);
        }
    }
    return answer;
}