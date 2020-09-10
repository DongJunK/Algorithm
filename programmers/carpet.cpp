#include <string>
#include <vector>

using namespace std;

bool check_brown(int brown, int width, int height)
{
    return (width * 2) + (height * 2) + 4 == brown;
}


vector<int> solution(int brown, int red) {
    vector<int> answer;

    for(int width=1;width <= red; ++width)
    {
        bool flag = true;
        for(int height=1; height<=width;++height)
        {
            if(height * width != red)
            {
                continue;
            }
            if(check_brown(brown, width, height))
            {
                if(width == 6 && height == 4){
                    
                }
                answer.push_back(width+2);
                answer.push_back(height+2);
                flag = false;
                break;
            }
        }
        if(!flag){
            break;
        }
    }
    return answer;
}