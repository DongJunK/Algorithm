#include <string>
#include <vector>

using namespace std;

bool check_possible_num(int num)
{
    string _number = to_string(num);
    if(_number[0] == _number[1] || _number[1] == _number[2] || _number[2] == _number[0] || _number[0] == '0' || _number[1] == '0' || _number[2] == '0')
    {
        return false;
    }
    return true;
}

bool check_strike_ball(vector<int> baseball, int prediction_num)
{
    string _number = to_string(baseball[0]);
    string _pred_num = to_string(prediction_num);
    int _ball_count = 0;
    int _strike_count = 0;

    if(!check_possible_num(prediction_num))
    {
        return false;
    }

    for(int i=0;i<3;++i)
    {
        for(int j=0;j<3;++j)
        {
            if(_number[i] == _pred_num[j] && i == j)
            {
                ++_strike_count;
                break;
            }
            else if(_number[i] == _pred_num[j] && i != j)
            {
                ++_ball_count;
                break;
            }
        }
    }
    if(_ball_count != baseball[2])
    {
        return false;
    }
    if(_strike_count != baseball[1])
    {
        return false;
    }

    return true;
}

int solution(vector<vector<int>> baseball) {
    int answer = 0;
    for(int prediction_num = 100 ; prediction_num<1000;++prediction_num)
    {
        bool flag = true;
        for(int i=0;i<baseball.size();++i)
        {
            if(!check_strike_ball(baseball.at(i), prediction_num))
            {
                flag = false;
                break;
            }
        }
        if(flag) answer+=1;
    }
    return answer;
}

int main()
{
    
    return 0;
}