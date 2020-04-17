package thread01.src.threadstatus;

public class BlockedJoin02 {
    public static void main(String[] args) {
        System.out.println("风和日丽的一天");
        new Thread(new Me()).start();
    }

}
class Me extends Thread{
    @Override
    public void run() {
        System.out.println("我想喝果汁，你去买榨汁机回来");
        Thread t=new Thread(new You());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("找你");
        }
        System.out.println("开始榨果汁");
    }
}

class You extends Thread{
    @Override
    public void run() {
        System.out.println("出门买榨汁机");
        System.out.println("出门迷路了");
        for (int i = 0; i < 10; i++) {
            System.out.println(i+"秒过去了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("跑路");
                e.printStackTrace();
            }
        }
        System.out.println("高德导航给力");
        System.out.println("买回来了");
    }
}
