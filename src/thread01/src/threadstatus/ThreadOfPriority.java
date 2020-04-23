package thread01.src.threadstatus;

/**
 * 线程优先级,优先级高的有比较大的概率被先执行
 * NORM_PRIORITY 5
 * MIN_PRIORITY 1
 * MAX_PRIORITY 10
 */
public class ThreadOfPriority {
    public static void main(String[] args) {
        MyPriority myPriority=new MyPriority();
        Thread t1=new Thread(myPriority);
        Thread t2=new Thread(myPriority);
        Thread t3=new Thread(myPriority);
        Thread t4=new Thread(myPriority);
        Thread t5=new Thread(myPriority);
        Thread t6=new Thread(myPriority);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        t4.setPriority(6);
        t5.setPriority(8);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }

}
class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"------>"+Thread.currentThread().getPriority());
    }
}