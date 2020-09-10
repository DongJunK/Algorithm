#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int check_number(vector<int> array, int start, int end, int k)
{
    int result = -1;
    vector<int> tmp_array;
    for(int i=start-1;i<end;++i)
    {
        tmp_array.push_back(array[i]);
    }
    sort(tmp_array.begin(),tmp_array.end());
    return tmp_array[k-1];
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    for(int i=0;i<commands.size();++i)
    {
        answer.push_back(check_number(array,commands[i][0],commands[i][1],commands[i][2]));
    }
    return answer;
}