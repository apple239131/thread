package thread01.src.thread03;

/**
 * 可重入锁
 * 线程试图获取一个已经由他持有的锁时，请求会立刻成功，并且会将这个锁的计数器值+1，
 * 当线程退出同步代码块时，计数器会递减，当计数值等于0时，锁释放。如果没有可重入锁支持，第二次试图获得锁时将进入死锁状态。
 */
public class LockTest {
    public static void main(String[] args) {
        new LockTest().test();
        //ReentrantLock
        //ReentrantLock
        //ReentrantLock
        //ReentrantLock
        // ......
    }

    public void test() {
        synchronized (this) {
            while (true) {
                //第二次获得同样的锁
                synchronized (this) {
                    System.out.println("ReentrantLock");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
