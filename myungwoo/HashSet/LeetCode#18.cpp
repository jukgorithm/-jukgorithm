using namespace std;
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(begin(nums), end(nums));
        return kSum(nums, target, 0, 4);
    }
    vector<vector<int>> kSum(vector<int>& nums, int target, int start, int k) {
        vector<vector<int>> res;
        // not valid case
        if (start == nums.size() || nums[start] * k > target || target > nums.back() * k)
            return res;
        // can find pair using O(n)
        if (k == 2)
            return twoSum(nums, target, start);
        
        for (int i = start; i < nums.size(); ++i) {
            if(i == start || nums[i-1] != nums[i]){
                auto subRes = kSum(nums, target-nums[i], i+1, k-1);
                for(auto& seq : subRes){
                    res.push_back({nums[i]});
                    res.back().insert(end(res.back()), begin(seq), end(seq));
                }
            }
        }
        return res;
    }
    
    vector<vector<int>> twoSum(vector<int>& nums, int target, int start) {
        vector<vector<int>> res;
        
        unordered_set<int> completeSet;
        
        for(int i = start; i < nums.size(); i++){
            if(res.empty() || res.back()[1] != nums[i]){
                int complete = target - nums[i];
                if(completeSet.find(complete) != completeSet.end()){
                    res.push_back({complete, nums[i]});
                }
            }
            completeSet.insert(nums[i]);
        }
        return res;
    }
};