package thread01.src.thread02;

public class SynTest01 implements Runnable {
    int ticketsNum=100;
    boolean flag=true;
    @Override
    public void run() {
        while (flag){
            test();
        }
    }

    public static void main(String[] args) {
        SynTest01 buy=new SynTest01();
        new Thread(buy,"a").start();
        new Thread(buy,"b").start();
        new Thread(buy,"c").start();
    }

    //buy 被锁，锁的是对象的资源
    //线程安全 同步
    public synchronized void test() {
        if (ticketsNum <= 0) {
            flag=false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"---->"+ticketsNum--);
    }
}
