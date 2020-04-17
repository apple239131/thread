package thread01.src.threadstatus;

/**
 * join合并线程，插队线程
 */
public class BlockedJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda---"+i);
            }
        });
        t.start();
        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0) {
                t.join(); //插队main被阻塞
            }
            System.out.println("main---"+i);
        }

    }
}
