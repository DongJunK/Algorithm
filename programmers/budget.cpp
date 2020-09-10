#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long dp[100001];

void insert_dp(vector<int> budgets)
{
    int result = 0;
    dp[0] = 0;
    for(int i=0;i<budgets.size();++i)
    {
        result += budgets[i];
        dp[i+1] = result;
    }
}

int find_optimal_upper_limit(vector<int> budgets, int country_budget)
{
    int upper_limit;
    for(int i=budgets.size()-1;1<=i;--i)
    {
        int budget = dp[i] + ((budgets.size() - i) * budgets[i]);
        if(budget <= country_budget)
        {
            upper_limit = budgets[i] + (country_budget - budget)/(budgets.size() - i - 1);
            break;
        }
    }
    return upper_limit;
}

int solution(vector<int> budgets, int M) {
    int answer = 0;
    
    sort(budgets.begin(),budgets.end());
    insert_dp(budgets);
    answer = find_optimal_upper_limit(budgets, M);
    return answer;
}

int main()
{
    int z[] = {120,110,140,150};
    vector<int> budget;
    budget.assign(z+0,z+4);
    cout << solution(budget,485) << endl;

    return 0;
}