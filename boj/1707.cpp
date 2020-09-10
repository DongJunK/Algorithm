#include <iostream>
#include <cstring>
#include <vector>

using namespace std;

vector<int> node[20001];
int colored[20001];
int flag = true;
void dfs(int n,int color)
{

    if(colored[n] == 0 )
    {
        colored[n] = color;
    }
    else if(colored[n] != color)
    {
        flag = false;
        return;
    }
    for(int i=0;i<node[n].size();++i)
    {
        int nextColor = colored[node[n].at(i)];
        if(nextColor == 0 || nextColor != -color )
        {
            dfs(node[n].at(i),-color);
        }
        
    }
}

int main()
{
    int T;
    cin>>T;
    while(T--)
    {
        int v,e;
        memset(colored,0,sizeof(colored));
        flag = true;
        cin>>v>>e;
        for(int i=1;i<=v;++i)
        {
            node[i].clear();
        }
        for(int i=0;i<e;++i)
        {
            int v1,v2;
            cin>>v1>>v2;
            node[v1].push_back(v2);
            node[v2].push_back(v1);
        }
        for(int i=1;i<=v;++i)
        {
            if(colored[i]==0)
            {
                dfs(i,1);
            }
            
        }
        if(flag == true)
        {
            cout << "YES" << endl;
        }
        else{
            cout << "NO" << endl;
        }
    }
    return 0;
}