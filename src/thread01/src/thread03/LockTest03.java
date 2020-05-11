package thread01.src.thread03;

/**
 * juc自带的可宠重用锁
 */

import java.util.concurrent.locks.ReentrantLock;

public class LockTest03 {
    ReentrantLock lock = new ReentrantLock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSom();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    public void doSom() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        //。。。
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest03 lockTest03=new LockTest03();
        lockTest03.a();
        //1
        //2
        //1
        //0
    }

}
