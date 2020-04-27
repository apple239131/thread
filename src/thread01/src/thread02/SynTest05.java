package thread01.src.thread02;

public class SynTest05 implements Runnable {
    int tickets = 100;
    boolean flag = true;

    public static void main(String[] args) {
        SynTest05 a = new SynTest05();
        new Thread(a, "aaa").start();
        new Thread(a, "bbb").start();
        new Thread(a, "ccc").start();
    }

    @Override
    public void run() {
        while (flag) {
            test04();
        }
    }

    //线程安全，范围太大，性能低下
    public void test01() {
        synchronized (this) {
            if (tickets <= 0) {
                flag = false;
                return;
            }
            try {
                //模拟延时
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + tickets--);
        }
        //bbb4
        //bbb3
        //bbb2
        //bbb1

    }

    public void test02() {
        //锁定失败，tickets对象在变，要锁地址不变的对象，而且flag没锁
        synchronized ((Integer) tickets) {
            if (tickets <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + tickets--);
        }
        //ccc1
        //bbb0
        //aaa-1
    }

    //线程不安全，
    public void test04() {
        if (tickets <= 0) {
            flag = false;
            return;
        }
        synchronized (this) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + tickets--);
        }
        //aaa2
        //aaa1
        //ccc0
        //bbb-1
    }

    //线程安全，尽可能锁定合理的数据范围
    //double checking
    public void test05() {
        if (tickets <= 0) { //考虑没票情况下
            flag = false;
            return;
        }
        synchronized (this) {
            if (tickets <= 0) { //考虑最后一张票
                flag = false;
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + tickets--);
        }

    }
}
