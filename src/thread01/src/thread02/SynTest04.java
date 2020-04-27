package thread01.src.thread02;

import java.util.ArrayList;
import java.util.List;

public class SynTest04 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //为list上锁
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        //主线程跑太快
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
