#include <iostream>
#include <algorithm>
using namespace std;
int board_x, board_y;
string board[50];

int check(int y, int x)
{
    if(board_y <= y + 7 || board_x <= x + 7)
    {
        return 64;
    }

    int white_start = 0;
    int black_start = 0;
    for(int i = y ; i < y + 8 ; ++i)
    {
        for(int j = x ; j < x + 8 ; ++j)
        {
            if( (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1) )
            {
                if(board[i][j] != 'W')
                {
                    ++white_start;
                }
                if(board[i][j] != 'B')
                {
                    ++black_start;
                }
            }
            else
            {
                if(board[i][j] != 'B')
                {
                    ++white_start;
                }
                if(board[i][j] != 'W')
                {
                    ++black_start;
                }
            }
            
        }
    }
    return min(white_start, black_start);
}
int main()
{

    int min_paint = 64;
    cin>>board_y>>board_x;

    for(int i=0;i<board_y;++i)
    {
        cin>>board[i];
    }
    for(int i=0;i<board_y;++i)
    {
        for(int j=0;j<board_x;++j)
        {
            min_paint = min(min_paint, check(i,j));
        }
    }
    cout<<min_paint<<endl;
    return 0;
}