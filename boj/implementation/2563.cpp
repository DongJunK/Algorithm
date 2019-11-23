#include <iostream>

using namespace std;
bool board[1000][1000];
int main()
{
    int n;
    cin>>n;
    for(int i=0;i<1000;++i)
    {
        for(int j=0;j<1000;++j)
        {
            board[i][j] = false;
        }
    }
    for(int i=0;i<n;++i)
    {
        int x,y;
        cin>>x>>y;
        for(int j=y;j<y+10;++j)
        {
            for(int k=x;k<x+10;++k)
            {
                board[j][k] = true;
            }
        }
    }
    int cnt = 0;
    for(int i=0;i<1000;++i)
    {
        for(int j=0;j<1000;++j)
        {
            if(board[i][j] == true)
            {
                ++cnt;
            }
        }
    }
    cout<<cnt<<endl;
    return 0;
}