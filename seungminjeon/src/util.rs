//! Global utils

pub mod input {
    pub fn get_line() -> String {
        let mut line = String::new();
        std::io::stdin().read_line(&mut line).unwrap();
        line
    }
}

pub mod parse {
    // e.g 3, 4, 5: String -> [3, 4, 5]: Vec<i32> 
    pub fn string_to_vec_i32(string: String) -> Vec<i32> {
        string.trim().split(", ").map(|str| {
            str.parse().unwrap()
        }).collect::<Vec<i32>>()
    }
}