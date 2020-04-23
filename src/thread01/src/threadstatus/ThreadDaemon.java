package thread01.src.threadstatus;

/**
 * 守护线程：为用户线程服务；JVM停止不用等待守护线程执行完毕
 *默认用户线程
 */
public class ThreadDaemon {
    public static void main(String[] args) {
        God god=new God();
        You2 you2=new You2();
        Thread t=new Thread(god);
        t.setDaemon(true);//用户线程设置为守护线程
        t.start();
        new Thread(you2).start();
    }
}
class You2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 36; i++) {
            System.out.println("happy ----");
        }
        System.out.println(">>>>>>>>>");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 600; i++) {
            System.out.println("liar---------");
        }
        System.out.println("<<<<<<<<<<<");
    }
}
