//! Palindrome Number

pub fn is_palindrome(x: i32) -> bool {
    if x < 0 {
        return false;
    }

    let mut reversed = 0;
    let mut target = x;
    while target != 0 {
        reversed = reversed * 10 + target % 10;
        target /= 10;
    }
    x == reversed
}
