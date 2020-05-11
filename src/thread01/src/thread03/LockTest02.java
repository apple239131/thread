package thread01.src.thread03;

/**
 * 手动实现一个可重入锁：锁可以延续使用+计数器
 */
public class LockTest02 {
    ReLock reLock = new ReLock();

    public void a() throws InterruptedException {
        reLock.lock();
        System.out.println(reLock.getHoldCount());
        doSom();
        reLock.unlock();
        System.out.println(reLock.getHoldCount());
    }

    public void doSom() throws InterruptedException {
        reLock.lock();
        System.out.println(reLock.getHoldCount());
        //......
        reLock.unlock();
        System.out.println(reLock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest02 lockTest02 = new LockTest02();
        lockTest02.a();
        //1
        //2
        //1
        //0
    }

}

class ReLock {
    //是否占用
    private boolean isLocked = false;
    //存储当前线程
    private Thread lockedBy = null;
    //计数器
    private int holdCount = 0;

    public int getHoldCount() {
        return holdCount;
    }

    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        //判断是不是已锁定的线程
        while (isLocked && lockedBy != t) {
            wait();
        }
        isLocked = true;
        lockedBy = t;
        holdCount++;
    }

    //释放锁
    public synchronized void unlock() {
        if (Thread.currentThread() == lockedBy) {
            holdCount--;
            if (holdCount == 0) {
                isLocked = false;
                notify();
                lockedBy = null;
            }
        }
    }
}