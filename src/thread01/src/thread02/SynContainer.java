package thread01.src.thread02;

import java.util.concurrent.CopyOnWriteArrayList;

public class SynContainer {
    public static void main(String[] args) {
        /**
         *CopyOnWriteArrayLis内部实现锁定
         */
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
