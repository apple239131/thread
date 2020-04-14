package thread01.src.threadstatus;

/**
 * 运行--->就绪 暂停线程 重回调度器等待调度
 */
public class Yield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"--end");
    }

    public static void main(String[] args) {
//        Yield yield=new Yield();
//        new Thread(yield,"a").start();
//        new Thread(yield,"b").start();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                System.out.println("---lambda---"+i);
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                Thread.yield();
            }
            System.out.println("main==="+i);
        }
    }
}
