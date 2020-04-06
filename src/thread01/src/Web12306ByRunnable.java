package thread01.src;

public class Web12306ByRunnable implements Runnable{


    /**
     * 共享资源，并发
     */
    private int tickets=100;

    public static void main(String[] args) {
        //一份资源
        Web12306ByRunnable cattle=new Web12306ByRunnable();
        //多个代理
        new Thread(cattle,"黄牛1号").start();
        new Thread(cattle,"黄牛2号").start();
        new Thread(cattle,"黄牛3号").start();

    }
    @Override
    public void run() {
        while (true) {
            if (tickets <0) {
             break;
            }
            //run()方法不能对外throw异常，只能try-catch
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---->>"+tickets--);
        }
    }
}
