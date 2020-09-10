#include <vector>
using namespace std;


void dfs(vector<int> numbers, int taget, int index, int result, int *answer)
{
    if(index == numbers.size())
    {
        if(taget == result)
        {
            ++(*answer);
            return;
        }
        else
        {
            return;
        }
    }
    dfs(numbers, taget, index + 1, result + numbers.at(index), answer);
    dfs(numbers, taget, index + 1, result - numbers.at(index), answer);
}

int solution(vector<int> numbers, int target) {
    int answer = 0;

    dfs(numbers, target, 0, 0, &answer);


    return answer;
}