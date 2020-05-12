package thread01.src.thread03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 锁分俩类
 * 1.悲观锁：synchronized是独占锁即悲观锁，会导致其他所有需要锁的线程挂起，等待持有锁的线程释放锁
 * 2.乐观锁：每次不加锁而是假设没有冲突去完成操作，如果因为冲突失败就重试，直到成功
 *
 * Compare and Swap比较并交换
 * 乐观锁的实现：
 * 有三个值：一个当前内存值V,旧的预期值A,将更新的值B.先获取到内存中当前的内存值V，再将内存值V与原值A比较，
 * 要是相等就修改为要修改的值B并返回true否则什么也不做，返回false.
 * CAS是一组原子操作，不会被打断；
 * 属于硬件级别的操作(利用CPU的CAS指令，同时借助JNI来完成的非阻塞算法，效率比加锁操作高)
 * ABA问题：如果变量V初次读取是A,并且在准备赋值时检查到仍然是A,那么能说明它的值没有被其他线程修改过吗
 * 如果期间曾经被改成B,又被改回A,那CAS操作就会被误认为它从来没有被修改过
 */
public class CASTest {
    private static AtomicInteger stock=new AtomicInteger(5);
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    //模拟网络延时
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //decrementAndGet 实现了CAS
                Integer left=stock.decrementAndGet();
                if (left < 1) {
                    System.out.println("--抢完了");
                    return;
                }
                System.out.print(Thread.currentThread().getName()+"抢到一个");
                System.out.println("--还剩"+left);
            }).start();
        }
        //Thread-1抢到一个抢完了
        //--还剩4
        //Thread-3抢到一个--还剩1
        //Thread-0抢到一个--还剩3
        //Thread-2抢到一个--还剩2

    }
}
