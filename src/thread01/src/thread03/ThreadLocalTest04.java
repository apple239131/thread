package thread01.src.thread03;

/**
 * InheritableThreadLocal:继承上下文环境的数据，将数据拷贝一份给子线程
 */
public class ThreadLocalTest04 {
    private static ThreadLocal<Integer> threadLocal=new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(222);
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        //线程由main线程开辟
        new Thread(()->{
            threadLocal.set(23333);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }).start();

        //main-->222
        //Thread-0-->222

        //main-->222
        //Thread-0-->23333
    }
}
