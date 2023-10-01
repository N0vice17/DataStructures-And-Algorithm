use std::cmp::Ordering;

pub fn find<U: AsRef<[T]>, T: Ord>(array: U, key: T) -> Option<usize> {
    let array = array.as_ref();
    let mut start = 0;
    let mut end = array.len();

    while start < end {
        let mid = start + (end - start) / 2;
        match array[mid].cmp(&key) {
            Ordering::Equal => return Some(mid),
            Ordering::Less => start = mid + 1,
            Ordering::Greater => end = mid,
        }
    }

    None
}

fn main() {
    let array = vec![1, 2, 3, 4, 5, 6, 7, 8, 9];
    let key = 5;

    match find(&array, &key) {
        Some(index) => println!("Found {} at index {}", key, index),
        None => println!("{} not found in the array", key),
    }
}
