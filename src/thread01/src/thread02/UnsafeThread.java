package thread01.src.thread02;

/**
 * 线程不安全，同一对象被多个线程同时操作
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
