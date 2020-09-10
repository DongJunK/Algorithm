#include <cstdio>
#include <iostream>

using namespace std;

void hanoi(int from, int to, int n)
{
    if(n==0) return ;
    hanoi(from,6-from-to,n-1);
    printf("%d %d"\n",from,to);
    hanoi(6-from-to,to,n-1);
}

int main()
{
    int n;
    cin>>n;
    cout << (1<<n) -1 << endl;

    hanoi(1,3,n);
    return 0;
}