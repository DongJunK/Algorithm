#include <iostream>
#include <queue>
using namespace std;
bool prime_num[10][10][10][10] = {0,};
bool visit[10][10][10][10] = {0,};

void init()
{
    for(int i=1;i<10;++i)
    {
        for(int j=0;j<10;++j)
        {
            for(int k=0;k<10;++k)
            {
                for(int l=0;l<10;++l)
                {
                    visit[i][j][k][l]=0;
                }
            }
        }
    }
}
int bfs(int start,int end)
{
    queue<int> pQ;
    queue<int> cnt;
    if(start==end)
    {
        return 0;
    }
    pQ.push(start);
    cnt.push(0);
    while(!pQ.empty())
    {
        int now = pQ.front();
        int now_cnt = cnt.front();
        pQ.pop();cnt.pop();
        if(now==end)
        {
            return now_cnt;
        }
        int j=(now%1000)/100,k=now%100/10,l=now%10;
        for(int i=1;i<10;++i)
        {
            int now_tmp = i*1000+j*100+k*10+l;
            if(now_tmp!=start&&!prime_num[i][j][k][l]&&!visit[i][j][k][l])
            {
                pQ.push(now_tmp);
                cnt.push(now_cnt+1);
                visit[i][j][k][l] = 1;
            }
        }
        for(int i=0;i<10;++i)
        {
            if((now/1000)*1000+i*100+k*10+l!=start&&!prime_num[now/1000][i][k][l]&&!visit[now/1000][i][k][l])
            {
                pQ.push((now/1000)*1000+i*100+k*10+l);
                cnt.push(now_cnt+1);
                visit[now/1000][i][k][l] = 1;
            }
            if((now/1000)*1000+j*100+i*10+l!=start&&!prime_num[now/1000][j][i][l]&&!visit[now/1000][j][i][l])
            {
                pQ.push((now/1000)*1000+j*100+i*10+l);
                cnt.push(now_cnt+1);
                visit[now/1000][j][i][l] = 1;
            }
            if((now/1000)*1000+j*100+k*10+i!=start&&!prime_num[now/1000][j][k][i]&&!visit[now/1000][j][k][i])
            {
                pQ.push((now/1000)*1000+j*100+k*10+i);
                cnt.push(now_cnt+1);
                visit[now/1000][j][k][i] = 1;
            }
            
        }
    }
    return -1;
}
int main(int argc, const char * argv[]) {
    int n;
    cin>>n;
    for(int i=2;i<10000;++i)
    {
        for(int j=2;i*j<10000;++j)
        {
            if(1000<=i*j)
            {
                prime_num[(i*j)/1000][((i*j)%1000)/100][((i*j)%100)/10][(i*j)%10] = true;
            }
        }
    }
    
    for(int i=0;i<n;++i)
    {
        int start,end;
        cin>>start>>end;
        init();
        int result = bfs(start,end);
        if(result!=-1)
        {
            cout<<result<<endl;
        }
        else
        {
            cout<<"Impossible"<<endl;
        }
    }
    
    
    return 0;
}
