#include <iostream>

using namespace std;

int dp_top[1001];
int dp_bottom[1001];

int main()
{
	int n,k,bottom=1,top=1;
	cin>>n>>k;
	for(int i=0;i<k;++i)
	{
		dp_top[i] = n--;
		dp_bottom[i] = i+1;
	}
	for(int i=0;i<k;++i)
	{
		
	}

	cout<<top/bottom<<endl;
	return 0;
}
