package thread01.src.threadstatus;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时
 */
public class SleepThread {
    public static void main(String[] args) throws InterruptedException {
        Date endTime=new Date(System.currentTimeMillis()+1000*10);
        long end=endTime.getTime();
        while (true) {
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(endTime));
            endTime=new Date(endTime.getTime()-1000);
            if (end - 10000 > endTime.getTime()) {
                break;
            }
        }
    }
}
