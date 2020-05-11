package thread01.src.thread03;

/**
 * 不可重入锁，锁不可以延续使用
 */
public class LockTest01 {
    Lock lock=new Lock();

    public void a() throws InterruptedException {
        lock.lock();
        doSome();
        lock.unlock();
    }
    //不可重入
    public void doSome() throws InterruptedException {
        lock.lock();
        //.....
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest01 test01=new LockTest01();
        test01.a();
        test01.doSome();
        //死循环
    }
}

//不可重入锁
class Lock{
    //是否占用
    private boolean isLocked=false;
    public synchronized void lock () throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked=true;
    }

    //释放锁
    public synchronized void unlock() {
        isLocked=false;
        notify();
    }
}
