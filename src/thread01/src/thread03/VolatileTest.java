package thread01.src.thread03;

/**
 * volatile保证线程变量的可见性，只保证数据同步
 * 线程对变量进行修改后要立刻写回主内存
 * 线程对变量读取时，要从主内存中读，而不是缓存
 * 不能保证原子性
 * 各线程的工作内存间彼此独立，互不可见，线程启动时虚拟机为每个内存分配一块工作内存，
 * 不仅包含线程内部定义的局部变量，也包含了线程需要使用的共享变量的副本，为了提高执行效率
 */
public class VolatileTest {
    //private static int num=0;//循环不停，线程没空去同步num
    //加上volatile才可以停止
    private volatile static int num = 0;

    public static void main(String[] ags) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {//此处为空

            }
        }).start();

        Thread.sleep(2000);
        num = 1;
    }
}
