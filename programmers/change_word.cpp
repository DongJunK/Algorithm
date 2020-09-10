#include <string>
#include <vector>
#include <algorithm>
using namespace std;


void init_visit(vector<bool> *visit, int length)
{
    for(int i=0;i<length;++i)
    {
        (*visit).push_back(false);
    }
}

bool compare_word(string begin, string target)
{
    int count = 0;
    for(int i=0;i<begin.length();++i)
    {
        if(begin[i] != target[i])
        {
            ++count;
        }
    }

    if(count == 1)
    {
        return true;
    }
    else
    {
        return false;
    }
    
}

void dfs(string begin, string target, vector<string> words, vector<bool> visit, int count, int *answer)
{
    
    if(begin == target)
    {
        *answer = min(*answer, count);
    }

    if(count == words.size())
    {
        return;
    }

    for(int i = 0; i < words.size();++i)
    {
        if( !visit[i] && compare_word(begin, words[i]))
        {
            visit[i] = true;
            dfs(words[i], target, words, visit, count + 1, answer);
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    int answer = 123456789;
    vector<bool> visit;
    init_visit(&visit, words.size());
    
    dfs(begin, target, words, visit, 0, &answer);
    if(answer == 123456789)
    {
        answer = 0;
    }
    return answer;
}