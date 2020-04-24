package thread01.src.thread02;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全：容器操作
 */
public class UnsafeThread03 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size()); //9283
    }

}
