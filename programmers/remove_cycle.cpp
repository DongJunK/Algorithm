#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool map[5001][5001];
bool visit[5001];
vector<vector<int> > removed_node;
void init_map(int n, vector<vector<int> > edges)
{
    for(int i=0;i<edges.size();++i)
    {
        map[edges[i][0]][edges[i][1]] = true;
        map[edges[i][1]][edges[i][0]] = true;
    }
}
void init_visit(int n)
{
    for(int i=1;i<=n;++i)
    {
        visit[i] = false;
    }
}

void remove_one_node(int node,int n)
{
    for(int i=1;i<=n;++i)
    {
        for(int j=1;j<=n;++j)
        {
            if(map[i][j] && (i == node || j == node))
            {
                map[i][j] = false;
                vector<int> removing_node;
                removing_node.push_back(i);
                removing_node.push_back(j);
                removed_node.push_back(removing_node);
            }
        }
    }
}

void insert_removed_node(int n)
{
    for(int i=0;i<removed_node.size();++i)
    {
        map[removed_node[i][0]][removed_node[i][1]] = true;
    }
    removed_node.clear();
}
void dfs(int now, bool *flag, int n, int previous)
{
    int cnt = 0;
    visit[now] = true;
    if(*flag) return;
    
    for(int i = 1;i<=n;++i)
    {
        if(i != now && previous != i && map[now][i] )
        {
            if(!visit[i])
            {
                dfs(i, flag, n, now);
            }
            else if(visit[i])
            {
                *flag = true;
                return;
            }
        }
    }
}

bool check_cycle(int n,int node)
{
    bool flag = false;
    dfs(node, &flag, n, 0);
    return flag;
}

int solution(int n, vector<vector<int> > edges) {
    int answer = 0;
    init_map(n,edges);
    for(int i=1;i<=n;++i)
    {
        init_visit(n);
        remove_one_node(i, n);
        if(!check_cycle(n,((i + 1) % n) + 1))
        {
            answer += i;
        }
        insert_removed_node(n);
    }

    return answer;
}

int main()
{
    vector<vector<int> > v;
    vector<int> tmp;
    tmp.push_back(1);
    tmp.push_back(2);
    v.push_back(tmp);
    tmp.clear();
    tmp.push_back(1);
    tmp.push_back(3);
    v.push_back(tmp);
    tmp.clear();
    tmp.push_back(2);
    tmp.push_back(3);
    v.push_back(tmp);
    tmp.clear();
    tmp.push_back(2);
    tmp.push_back(4);
    v.push_back(tmp);
    tmp.clear();
    tmp.push_back(3);
    tmp.push_back(4);
    v.push_back(tmp);
    cout<<solution(4,v)<<endl;
    return 0;
}