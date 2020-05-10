package thread01.src.thread03;

/**
 * ThreadLocal:分析上下文环境的起点
 * 构造器：哪里调用，就属于哪里
 * run方法：本线程自己的
 */
public class ThreadLocalTest03 {
    private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);

    public static void main(String[] args) {
        new Thread(new MyRun()).start();

        //main-->1
        //Thread-0->>1

        //main-->222
        //Thread-0-->1

    }

    public static class MyRun implements Runnable{

        public MyRun() { //由main线程发起
           // threadLocal.set(222);  //只改变main线程的值
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }
    }
}
