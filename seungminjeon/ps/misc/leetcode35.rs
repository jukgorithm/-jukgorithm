pub fn solve(nums: Vec<i32>, target: i32) -> i32 {
    let (mut left, mut right) = (0, nums.len());

    loop {
        let mid = (left + right) / 2;
        if left == right || nums[mid] == target {
            return mid as i32;
        }
        match nums[mid] < target {
            true => left = mid + 1,
            false => right = mid,
        }
    }
}
