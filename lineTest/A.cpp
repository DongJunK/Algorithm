#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int consumer[10]={0,};

queue<int> q;

void enter_msg(int msg_n)
{
    for(int i=0;i<msg_n;++i)
    {
        int msg;
        cin>>msg;
        q.push(msg);
    }
}

void solution(int msg_n,int consumer_n)
{
    for(int i=0;i<msg_n;++i)
    {
        consumer[0] += q.front();
        q.pop();
        sort(consumer,consumer + consumer_n);
    }
    cout << consumer[consumer_n-1] << endl;
}

int main()
{
    int msg_n,consumer_n;
    cin >> msg_n >> consumer_n;
    
    enter_msg(msg_n);

    solution(msg_n,consumer_n);

    return 0;
}