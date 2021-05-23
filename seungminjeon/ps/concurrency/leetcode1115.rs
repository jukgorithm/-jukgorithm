use crossbeam_epoch::{self as epoch, Atomic};
use epoch::Owned;
use std::sync::atomic::*;

pub struct Foo {
    n: Atomic<u64>,
}

impl Foo {
    pub fn new(n: u64) -> Self {
        Self {
            n: Atomic::new(n * 2),
        }
    }

    pub fn foo(&self) {
        loop {
            let guard = &epoch::pin();
            let n_foo = unsafe { self.n.load(Ordering::Relaxed, guard).deref() };

            if n_foo == &0 {
                break;
            };
            if n_foo % 2 == 0 {
                print!("foo");
                self.n.store(Owned::new(n_foo - 1), Ordering::Relaxed);
            }
        }
    }

    pub fn bar(&self) {
        loop {
            let guard = &epoch::pin();
            let n_bar = unsafe { self.n.load(Ordering::Relaxed, guard).deref() };

            if n_bar == &0 {
                break;
            };
            if n_bar % 2 == 1 {
                println!("bar");
                self.n.store(Owned::new(n_bar - 1), Ordering::Relaxed);
            }
        }
    }
}

#[cfg(test)]
mod test {
    use crossbeam_utils::thread;

    #[test]
    fn solve() {
        let foo = super::Foo::new(20);
        thread::scope(|scope| {
            scope.spawn(|_| {
                foo.bar();
            });
            scope.spawn(|_| {
                foo.foo();
            });
        })
        .unwrap();
    }
}
