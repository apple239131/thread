package thread01.src.thread02;

/**
 * 线程不安全，同一对象被多个线程同时操作
 * 多个线程同时操作共享变量1时，会出现线程1更新共享变量1的值，但是其他线程获取到的是共享变量没有被更新之前的值。就会导致数据不准确问题。
 * 所有的变量都存放在主内存中，当线程使用变量时，会把主内存里面的变量复制到自己的工作空间或者叫作工作内存，线程读写变量时操作的是自己工作内存中的变量
 * 共享变量的内存不可见，也就是线程B写入的值对线程A不可见。
 */
public class UnsafeThread implements Runnable{
    int tickets=100;

    public static void main(String[] args) {
        UnsafeThread thread=new UnsafeThread();
        new Thread(thread,"a").start();
        new Thread(thread,"b").start();
        new Thread(thread,"c").start();
    }
    @Override
    public void run() {
        while(true){
            if (tickets < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+">>>"+tickets--);
        }
        //c>>>1
        //a>>>0
        //b>>>-1
        //c>>>-2

    }
}
