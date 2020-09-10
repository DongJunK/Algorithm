#include <iostream>
#include <algorithm>

using namespace std;

int dot[300001][2];
int dot_num;

int solution(){
    int min_count = 200000000;
    for(int i=0;i<dot_num-2;++i){
        bool red = false;
        bool blue = false;
        bool green = false;
        for(int j=i;j<dot_num;++j){
            if(dot[j][1]==1){
                red = true;
            }else if(dot[j][1]==2){
                green = true;
            }else if(dot[j][1]==3){
                blue = true;
            }
            if(red && blue && green){
                min_count = min(min_count,dot[j][0]-dot[i][0]);
                break;
            }
        }
    }
    return min_count;
}

int main(void) {
    cin>>dot_num;
    for(int i=0;i<dot_num;++i){
        cin>>dot[i][0]>>dot[i][1];
    }
    cout<<solution()<<endl;
    return 0;
}
