#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<string> result;

void combination(int num_1, int num_2, int num_3)
{
    string res;
    res += to_string(num_1);
    res += to_string(num_2);
    res += to_string(num_3);
    result.push_back(res);
}

void solution(int n, int *num)
{
    for(int i=0;i<3;++i)
    {
        for(int j=0;j<3;++j)
        {
            for(int k=0;k<3;++k)
            {
                if(i!=j && j!=k && i!=k)
                {
                    combination(num[i],num[j],num[k]);
                }
            }
        }
    }

    sort(result.begin(),result.end());
    cout << result.at(n-1)<<endl;
}




int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int n;
    int num[3];
    
    cin>>num[0]>>num[1]>>num[2];
    
    cin>>n;
    
    solution(n, num);
    
    return 0;
}