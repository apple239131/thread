package thread01.src.threadstatus;

/**
 * 终止线程
 * 1.正常执行完毕--》次数
 * 2.外部干涉--》加入标识
 */
public class TermateThread extends Thread {
    //加入标识
    private boolean flag = true;
    private String name;

    public TermateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //关联标识
        int i = 0;
        while (flag) {
            System.out.println(name + "---" + i++);
        }
    }

    //对外提供方法改变标识
    public void terminate() {
        this.flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        TermateThread thread1 = new TermateThread("apple");
        Thread.sleep(10);
        thread1.start();

        for (int i = 0; i <= 100; i++) {
            if (i == 14) {
                thread1.terminate();
                System.out.println("thread stop");
            }
            System.out.println("main-->" + i);
        }
    }

}
