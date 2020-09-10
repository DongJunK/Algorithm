#include <iostream>
#include <vector>
using namespace std;

int n,cnt;
int arr[101];
int visit[101]={0,};
int valid[101]={0,};

vector<int> cycle_value;


void insert_valid()
{
    
    for(int i=0;i<cycle_value.size();++i)
    {
        if(cycle_value.at(i)<=100&&valid[cycle_value.at(i)]==0)
        {
            valid[cycle_value.at(i)]=1;
            ++cnt;
        }
    }
}


void dfs(int x)
{
    int next = arr[x];
    
    
    if(visit[next]==2)
    {
        for(int i=1;i<=n;++i)
        {
            if(visit[i]==2)
            {
                cycle_value.push_back(i);
            }
        }
        insert_valid();
        cycle_value.clear();
        fill_n(visit, n+1, 0);
        return ;
    }
    
    ++visit[next];
    dfs(next);
}


int main(int argc, const char * argv[]) {

    
    cin>>n;
    for(int i=1;i<=n;++i)
    {
        cin>>arr[i];
    }
    for(int i=1;i<=n;++i)
    {
        dfs(i);
    }
    
    cout<<cnt<<endl;
    for(int i=1;i<=n;++i)
    {
        if(valid[i]==1)
        {
            cout<<i<<endl;
        }
    }
    
    return 0;
}
