using namespace std;
class Solution {
public:
    
    vector<int> ans;
    int Target;
    
    void findSeq(int idx, vector<int>& seq, vector<int>& nums){
        if(ans.size() || idx >= nums.size()) return;
        
        seq.push_back(idx);
        if(seq.size() == 2){
            int sum = nums[seq[0]] + nums[seq[1]];
            
            if(sum == Target){
                ans = seq;
            }
        }else{
            for (int i = idx+1; i < nums.size(); i++) {
                findSeq(i, seq, nums);
            }
        }
        
        
        seq.pop_back();
    }
    
    vector<int> twoSum(vector<int>& nums, int target) {
        Target = target;
        for (int i = 0; i < nums.size(); i++) {
            vector<int> tempSeq;
            findSeq(i, tempSeq, nums);
        }
            
        return ans;
    }
};