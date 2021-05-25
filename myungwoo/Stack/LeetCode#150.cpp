// Evaluate Reverse Polish Notation

using namespace std;
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        if(tokens.size() == 1) return stoi(tokens.back());
        
        vector<int> st;
        
        for(auto str : tokens){
            if(str != "+" && str != "-" && str != "*" && str != "/"){
                st.push_back(stoi(str));
            }else{
                int a = st.back();
                st.pop_back();
                int b = st.back();
                st.pop_back();
                
                string op = str;
                int res = 0;
                if(op == "+"){
                     res = b + a;
                }else if(op == "-"){
                    res = b - a;
                }else if(op == "*"){
                    res = b * a;
                }else{
                    res = trunc(b/a);
                }
                st.push_back(res);
            }
        }
        
        return st.back();
    }
};