package thread01.src.thread03;

/**
 * ThreadLocal可以存放一个线程级别的变量，其本身能够被多个线程共享使用，而且可以达到线程安全的目的，
 * 在多线程环境下保证成员变量的安全
 * get/set/initialValue方法
 */
public class ThreadLocalTest01 {
    //private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
    //main--->null

    //更改初始化值
//    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
//        protected Integer initialValue() {
//            return 200;
//        };//main--->200
//    };
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 200);

    public static void main(String[] args) {
        //获取值
        System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
        //设置值
        threadLocal.set(77);
        System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());

        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable {

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 99));
            System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
            //每个线程有自己的存储空间，运行互不影响
            //main--->200
            //main--->77
            //Thread-0--->34
            //Thread-2--->51
            //Thread-1--->79
        }
    }

}
