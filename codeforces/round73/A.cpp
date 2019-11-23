#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;
int arr[20]={0,};

int exponent(int n)
{
    int i = 0;
 
    while ((n = n >> 1))
        ++i;
 
    return i;
}

void solution()
{
    while(arr[11]==0)
    {
        bool flag = false;
        for(int i=0;i<11;++i)
        {
            if(2 <= arr[i]){
                arr[i+1] += arr[i] / 2;
                arr[i] = arr[i] % 2;
                flag = true;
            }
        }
        if(flag == false) break;
    }
    if(1 <= arr[11] ) printf("YES\n");
    else printf("NO\n");
}

int main()
{
    int t;
    cin>>t;
    for(int test=0;test<t;++test)
    {
        int n;
        cin>>n;
        for(int i=0;i<=11;++i) arr[i] = 0;
        for(int i=0;i<n;++i)
        {
            int num;
            cin>>num;
            int exp = exponent(num);
            if(exp <= 11)
            {
                ++arr[exp];
            }
        }
        solution();
    }
    return 0;
}