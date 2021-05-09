#include <iostream>
#include <algorithm>
#include <ctype.h>
#include <vector>
#define LL long long int
#define loop(n) for(int I = 0; I < n; ++I)
#define sz(x) (int)x.size()
#define ALPHA 26
#define pii pair<int,int>
const int MAX = 987654321;
const int MIN = -987654321;
const char endL = '\n';

using namespace std;
class Solution {
public:
    vector<vector<char>> chList = {
        {},
        {},
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'},
        {},
        {},
        {},
    };
    
    vector<string> ans;
    
    void recFindCombination(string finded, string remain){
        if(remain == "") return;
        
        int curNum = remain[0]-'0';
        
        for(char ch : chList[curNum]){
            if(remain.length() == 1){
                ans.push_back(finded + ch);
            }else{
                recFindCombination(finded+ch, remain.substr(1));
            }
        }
    }
    
    vector<string> letterCombinations(string digits) {
        recFindCombination("", digits);
        
        return ans;
    }
};

int main(int argc, const char * argv[]) {
    Solution solution;
    vector<string> ans = solution.letterCombinations("");
    for(string s : ans){
        cout << s << endL;
    }
    return 0;
}


