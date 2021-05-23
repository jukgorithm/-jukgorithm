// Generate Parentheses
using namespace std;
class Solution {
public:
    set<string> s;
    
    void recurParen(int notClosedN, int n, string str){
        if(notClosedN == 0 && n == 0){
            s.insert(str);
            return;
        }
        
        
        for (int i = 1; i <= notClosedN; ++i) {
            if(notClosedN != 0 && notClosedN - i >= 0){
                recurParen(notClosedN - i, n, str + string(i, ')'));
            }else{
                break;
            }
        }
        
        for (int i = 1; i <= n; ++i) {
            if(n - i >= 0){
                recurParen(notClosedN+i, n-i, str + string(i, '('));
            }else{
                break;
            }
        }
    }
    
    vector<string> generateParenthesis(int n) {
        
        recurParen(0, n, "");
        
        vector<string> ans(s.begin(), s.end());
        
        return ans;
    }
};