package thread01.src.thread03;

import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务定时调度，定时启动某个线程
 */
public class TimerTest01 {
    public static void main(String[] args) {
        //定义计时器
        Timer t1=new Timer();
        //定义任务
        MyTask task1=new MyTask();

        //3秒后执行
        //t1.schedule(task1,3000);

        //5秒后开始执行，每隔二秒执行一次
        //t1.schedule(task1,5000,2000);

        //指定时间运行
        GregorianCalendar calendar=new GregorianCalendar(2020,5,7,22,41,0);
        t1.schedule(task1,calendar.getTime(),2000);


    }

}

/**
 * 自定义线程继承TimerTask类
 */
class MyTask extends TimerTask {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("good good study ->day"+i);
        }
        System.out.println("-------end");
    }
}
