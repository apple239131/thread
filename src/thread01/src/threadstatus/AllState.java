package thread01.src.threadstatus;

public class AllState {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           System.out.println("----------");
        });
        
        Thread.State state=t.getState();
        System.out.println(state);  //new

        t.start();
        state=t.getState();   //runnable
        System.out.println(state);
//        while (state!=Thread.State.TERMINATED) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            state=t.getState(); //timed_waiting
//            System.out.println(state);
//        }
//        state=t.getState(); //terminated
//        System.out.println("ssssss"+state);
        while (true) {
            //活动的线程数
            int num = Thread.activeCount();
            System.out.println(num);
            if (num == 1) {
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState(); //timed_waiting
            System.out.println(state);
        }
    }
}
