package thread01.src.thread03;

/**
 * ThreadLocal：每个线程有自己的存储区域，更改不会影响其他线程
 */
public class ThreadLocalTest02 {
    private static ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRun()).start();
        }
        //Thread-0目前有1
        //Thread-2目前有1
        //Thread-2剩下0
        //Thread-3目前有1
        //Thread-3剩下0
        //Thread-1目前有1
        //Thread-1剩下0
        //Thread-0剩下0
        //Thread-4目前有1
        //Thread-4剩下0

    }
    public static class MyRun implements Runnable{
        @Override
        public void run() {
            Integer left=threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"目前有"+threadLocal.get());
            threadLocal.set(left-1);
            System.out.println(Thread.currentThread().getName()+"剩下"+threadLocal.get());
        }
    }
}
