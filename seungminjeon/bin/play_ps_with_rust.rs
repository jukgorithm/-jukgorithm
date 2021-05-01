use play_ps_with_rust::*;
use util::{input::*, parse::*};

pub fn main() {
    let input = string_to_vec_i32(get_line());

    // calculate
    let output = misc::leetcode1480::solve(input);
    for (_ix, value) in output.iter().enumerate() {
        print!("{}, ", value);
    }
}