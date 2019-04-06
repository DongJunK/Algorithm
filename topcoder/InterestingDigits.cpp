/*
* BeakJoon ID : skdltm357
* TOPCODER PRACTICE
*
* Github ID = DongjunK
* Github = https://github.com/DongJunK/topcoder
*/
#include <iostream>
#include <vector>
using namespace std;
class InterestingDigits{
	public:vector<int> digits(int base){
		int tmp,tmpresult=0;
		vector<int> result;
		vector<int> digit;
		for(int i=2;i<base;i++){
			bool flag=true;
			int j=0;
			while(++j<10000){
				tmp=j*i;
				while(true){
					if(tmp/base==0){
						digit.push_back(tmp%base);
						break;
					}else{
						digit.push_back(tmp%base);
						tmp/=base;
					}
				}
				for(int i=0;i<digit.size();i++){
					tmpresult+=digit[i];
				}
				if(tmpresult%i!=0){
					flag=false;
					digit.clear();	
					tmpresult=0;
					break;
				}
				digit.clear();	
				tmpresult=0;
			}
			if(flag) result.push_back(i);
		}
		return result;
	}
};
int main(){
	int base;
	vector<int> result;
	InterestingDigits a;
	cin >> base;
	result = a.digits(base);
	for(int i =0;i<result.size();i++){
		cout<<result[i]<<endl;
	}
	return 0;
}
