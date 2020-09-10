#include <vector>
#include <string>
#include <algorithm>
#include <map>
#include <utility>
using namespace std;

int dpMax(int start_index, int end_index, vector<string> arr);
int dpMin(int start_index, int end_index, vector<string> arr);

map<pair<int,int>,int> min_dp;
map<pair<int,int>,int> max_dp;

int dpMax(int start_index, int end_index, vector<string> arr)
{
    int result = -123456789;

    pair<int,int> now_pair(start_index, end_index);
    if(max_dp.find(now_pair) != max_dp.end())
    {
        return max_dp[now_pair];
    }

    if(start_index == end_index)
    {
        return stoi(arr[start_index]);
    }

    for(int i=start_index + 1;i < end_index; i+=2)
    {
        
        if(arr[i] == "-")
        {
            result = max(result, dpMax(start_index,i-1,arr) - dpMin(i+1,end_index,arr));
        }
        else
        {
            result = max(result, dpMax(start_index,i-1,arr) + dpMax(i+1,end_index,arr));
        }
    }
    max_dp.insert(make_pair(now_pair,result));

    return result;
}

int dpMin(int start_index, int end_index, vector<string> arr)
{
    int result = 123456789;

    pair<int,int> now_pair(start_index, end_index);
    if(min_dp.find(now_pair) != min_dp.end())
    {
        return min_dp[now_pair];
    }

    if(start_index == end_index)
    {
        return stoi(arr[start_index]);
    }

    for(int i=start_index + 1;i < end_index; i+=2)
    {
        if(arr[i] == "-")
        {
            result = min(result, dpMin(start_index,i-1,arr) - dpMax(i+1,end_index,arr));
        }
        else
        {
            result = min(result, dpMin(start_index,i-1,arr) + dpMin(i+1,end_index,arr));
        }
    }
    min_dp.insert(make_pair(now_pair,result));
    
    
    return result;
}

int solution(vector<string> arr)
{
    map<pair<int,int>,int> ins_map;
    int answer = dpMax(0,arr.size()-1,arr);
    
    return answer;
}