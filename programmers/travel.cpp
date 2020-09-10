#include <string>
#include <iostream>
#include <vector>

using namespace std;


vector<string> now_answer;

vector<string> compare_alpabet(vector<string> _now_answer, vector<string> _answer)
{
    vector<string> result;
    for(int i=0;i<_now_answer.size(); ++i){
        if(_now_answer.at(i) == _answer.at(i))
        {
            continue;
        }
        else if(_now_answer.at(i) > _answer.at(i))
        {
            result = _answer;
            break;
        }
        else
        {
            result = _now_answer;
            break;
        }
    }
    if(result.size() == 0)
    {
        result = _now_answer;
    }
    return result;
}

void dfs(vector<string> answer, vector<vector<string> > tickets, int target_length)
{
    if(tickets.empty() && answer.size() == target_length)
    {
        if(now_answer.size() == 0)
        {
            now_answer = answer;
        }
        else
        {
            now_answer = compare_alpabet(now_answer, answer);
        }
        return;
    }
    for(int i=0;i<tickets.size();++i)
    {
        vector<string> now_ticket = tickets.at(i);
        if(answer.at(answer.size() - 1) == now_ticket[0]){
            tickets.erase(tickets.begin() + i);
            answer.push_back(now_ticket[1]);
            dfs(answer,tickets, target_length);
            answer.pop_back();
            tickets.insert(tickets.begin() + i,now_ticket);
        }
    }
}


vector<string> solution(vector<vector<string> > tickets) {
    vector<string> answer;
    for(int i=0;i<tickets.size();++i)
    {
        if(tickets[i][0] == "ICN")
        {
            answer.push_back(tickets[i][0]);
            dfs(answer,tickets, tickets.size() + 1);
            answer.pop_back();
        }
    }
    answer = now_answer;
    return answer;
}

void print_tickets(vector<string> travel)
{
    for(int i=0;i<travel.size();++i)
    {
        cout<<travel[i]<<" ";
    }
    cout<<endl;
}

int main()
{
    vector<vector<string> > tickets;
    vector<string> insert;
    vector<string> result;
    insert.push_back("ICN");
    insert.push_back("COO");
    tickets.push_back(insert);
    insert.clear();
    insert.push_back("ICN");
    insert.push_back("BOO");
    tickets.push_back(insert);
    insert.clear();
    insert.push_back("COO");
    insert.push_back("ICN");
    tickets.push_back(insert);
    insert.clear();
    insert.push_back("BOO");
    insert.push_back("DOO");
    tickets.push_back(insert);
    /*
    insert.push_back("ICN");
    insert.push_back("SFO");
    tickets.push_back(insert);
    insert.clear();
    insert.push_back("ICN");
    insert.push_back("ATL");
    tickets.push_back(insert);
    insert.clear();
    insert.push_back("SFO");
    insert.push_back("ATL");
    tickets.push_back(insert);
    insert.clear();
    insert.push_back("ATL");
    insert.push_back("ICN");
    tickets.push_back(insert);
    insert.clear();
    insert.push_back("ATL");
    insert.push_back("SFO");
    tickets.push_back(insert);
    */

    result = solution(tickets);

    print_tickets(result);
    return 0;
}