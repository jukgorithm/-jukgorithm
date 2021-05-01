pub fn solve(nums: Vec<i32>) -> Vec<i32> {
    let mut ans = vec![nums[0]];
    for n in 1..nums.len() {
        ans.push(ans[n-1]+nums[n]);
    }
    ans
}