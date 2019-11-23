#include <iostream>
#include <algorithm>

using namespace std;
int a_players, b_players, a_yellow_card, b_yellow_card, total_yellow_card;

int min_leaves_players()
{
    int yellow_card;
    yellow_card = a_players * (a_yellow_card-1) + b_players * (b_yellow_card-1);
    if(total_yellow_card <= yellow_card)
    {
        return 0;
    }
    else if( a_players + b_players <= total_yellow_card - yellow_card)
    {
        return a_players + b_players;
    }
    else if(total_yellow_card - yellow_card <= 0)
    {
        return 0;
    }
    else
    {
        return total_yellow_card - yellow_card;
    }
    
}

int leaves_players(int *now_yellow_card, int players, int yellow_card)
{
    int leaves_cnt=0;
    for(int i=0;i<players;++i)
    {
        if(*now_yellow_card - yellow_card < 0)
        {
            return leaves_cnt;
        }

        *now_yellow_card -= yellow_card;
        ++leaves_cnt;
    }
    return leaves_cnt;
}

int max_leaves_players()
{
    int now_yellow_card = total_yellow_card;
    int leaves_cnt = 0;
    if(a_yellow_card < b_yellow_card)
    {
        leaves_cnt += leaves_players(&now_yellow_card, a_players, a_yellow_card);
        if(0 <= now_yellow_card - b_yellow_card)
        {
            leaves_cnt += leaves_players(&now_yellow_card, b_players, b_yellow_card);
        }
        return leaves_cnt;
    }
    else{
        leaves_cnt += leaves_players(&now_yellow_card, b_players, b_yellow_card);
        if(0 <= now_yellow_card - a_yellow_card)
        {
            leaves_cnt += leaves_players(&now_yellow_card, a_players, a_yellow_card);
        }
        return leaves_cnt;
    }
}



int main()
{
    cin>>a_players>>b_players>>a_yellow_card>>b_yellow_card>>total_yellow_card;
    
    cout<<min_leaves_players()<<" "<<max_leaves_players()<<endl;

    return 0;
}