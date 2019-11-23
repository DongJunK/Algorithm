#include <iostream>
#include <algorithm>
using namespace std;

void solution()
{
    int c,m,x;
    cin>>c>>m>>x;
    cout << min(min(c,m),(c+m+x)/3)<<endl;
}

int main()
{
    int n;
    cin>>n;
    while(n--) solution();
    return 0;
}