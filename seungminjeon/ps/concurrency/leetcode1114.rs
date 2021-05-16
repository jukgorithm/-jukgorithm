use crossbeam_epoch::{self as epoch, Atomic};
use epoch::Owned;
use std::sync::atomic::*;

pub struct Foo {
    cnt: Atomic<u64>,
}

impl Foo {
    pub fn new() -> Self {
        Self {
            cnt: Atomic::new(0),
        }
    }

    pub fn first(&self) {
        let guard = &epoch::pin();
        unsafe { while self.cnt.load(Ordering::Relaxed, guard).deref() != &0 {} }
        println!("first");
        self.cnt.store(Owned::new(1), Ordering::Relaxed);
    }

    pub fn second(&self) {
        let guard = &epoch::pin();
        unsafe { while self.cnt.load(Ordering::Relaxed, guard).deref() != &1 {} }
        println!("second");
        self.cnt.store(Owned::new(2), Ordering::Relaxed);
    }

    pub fn third(&self) {
        let guard = &epoch::pin();
        unsafe { while self.cnt.load(Ordering::Relaxed, guard).deref() != &2 {} }
        println!("third");
        self.cnt.store(Owned::new(3), Ordering::Relaxed);
    }
}

#[cfg(test)]
mod test {
    use crossbeam_utils::thread;
    use std::{thread::sleep, time::Duration};

    #[test]
    fn solve() {
        let foo = super::Foo::new();
        thread::scope(|scope| {
            scope.spawn(|_| {
                foo.second();
            });

            scope.spawn(|_| {
                foo.third();
            });

            scope.spawn(|_| {
                sleep(Duration::from_secs(3));
                foo.first();
            });
        })
        .unwrap();
    }
}
