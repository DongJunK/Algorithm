#include <iostream>
using namespace std;

int x,y;
int map[11][11];
int red[2];
int blue[2];

int solution(){
    
}

int main(){
    cin>>x>>y;
    for(int i=0;i<y;++i){
        for(int j=0;j<x;++j){
            cin>>map[i][j];
            if(map[i][j] == 'R'){
                red[0] = j;
                red[1] = i;
                map[i][j] = '.';
            }else if(map[i][j] == 'B'){
                blue[0] = j;
                blue[1] = i;
                map[i][j] = '.';
            }
        }
    }
    cout<<solution()<<endl;;
    return 0;
}