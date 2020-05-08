package thread01.src.thread03;

/**
 * 执行代码顺序可能与编写代码不一致，虚拟机优化代码顺序，指令重排
 */
public class HappenBefore {
    private static int a = 0;
    private static boolean flag = false;

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            a = 0;
            flag = false;
            //线程1修改数据
            Thread t1 = new Thread(() -> {
                a = 1;
                flag = true;
            });
            //线程2读取数据
            Thread t2 = new Thread(() -> {
                if (flag) {
                    a*=1;
                }
                if (a == 0) {
                    System.out.println("happen before a->" + a);
                }
            });
            t1.start();
            t2.start();

            //合并线程
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    //按预期顺序a=1,不会输出，出现了结果，表面发生了指令重排
    // happen before a->1
}
