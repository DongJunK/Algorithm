#include <iostream>

using namespace std;

int n;
int in_order[100001];
int post_order[100001];
int idx[100001];
void preOrder(int in_begin, int in_end, int post_begin, int post_end)
{
    if(in_end < in_begin || post_end < post_begin)
    {
        return;
    }

    int root = post_order[post_end];
    cout << root << " ";
    //left
    preOrder(in_begin,idx[root]-1,post_begin,post_begin+(idx[root]-in_begin)-1);
    //rigth
    preOrder(idx[root]+1,in_end,post_begin+(idx[root]-in_begin),post_end-1);
}

int main()
{
    cin>>n;
    for(int i=0;i<n;++i)
    {
        cin>>in_order[i];
        idx[in_order[i]] = i;
    }
    for(int i=0;i<n;++i)
    {
        cin>>post_order[i];
    }
    preOrder(0,n-1,0,n-1);
    cout<<endl;
    return 0;
}