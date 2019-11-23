#include <iostream>

using namespace std;

int n;
char ticket_num[200001];

void mono(int index,int *left,int *right)
{
    if(index < n/2)
    {
        if(*left < *right)
        {
            ticket_num[index] = '0';
        }
        else
        {
            ticket_num[index] = '9';
        }
    }
    else
    {
        if(*left < *right)
        {
            ticket_num[index] = '9';
        }
        else
        {
            ticket_num[index] = '0';
        }
    }
}

void bi(int index,int *left, int *right)
{
    if(index < n/2)
    {
        if(*left < *right)
        {
            if(9<=*right - *left)
            {
                ticket_num[index] = '9';
            }
            else{
                ticket_num[index] = *right-*left;
            }
        }
        else
        {
            ticket_num[index] = '9';
        }
    }
    else
    {
        if(*left < *right)
        {
            ticket_num[index] = '9';
        }
        else
        {
            ticket_num[index] = '0';
        }
    }
}


string solution(int n)
{
    int left=0;
    int right=0;
    int cnt=0;
    for(int i=0;i<n;++i)
    {
        if(arr[i]!='?')
        {
            if(i<n/2)
            {
                left+=arr[i]-'0';
            }
            else
            {
                right+=arr[i]-'0';
            }
        }
    }
    for(int i=0;i<n;++i)
    {
        if(arr[i]== '?')
        {
            if(cnt%2==0)
            {
                mono(i,&left,&right);
                ++cnt;
            }
            else
            {
                bi(i,&left,&right);
                ++cnt;
            }
        }
    }
    if(left == right) return "Bicarp";
    else return "Monocarp"
}

int main()
{
    cin>>n;
    for(int i=0;i<n;++i)
    {
        cin>>ticket_num[i];
    }
    
    cout<<solution(n)<<endl;

    return 0;
}