package thread01.src.thread03;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;


import java.util.Date;

public class QuartzTest {

    public void run() throws Exception {
        // 1、创建 Scheduler的工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //2、从工厂中获取调度器
        Scheduler scheduler = sf.getScheduler();
        // 3、创建JobDetail
        JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
        // 时间
        Date runTime = evenSecondDateAfterNow();
        // 4、触发条件
        //Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
        Trigger trigger  = newTrigger().withIdentity("trigger1", "group1").startAt(runTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(5).withRepeatCount(3)).build();
        // 5、注册任务和触发条件
        scheduler.scheduleJob(job, trigger);

        // 6、启动
        scheduler.start();


        try {
            // 100秒后停止
            Thread.sleep(100L * 1000L);
        } catch (Exception e) {
        }
        scheduler.shutdown(true);
    }

    public static void main(String[] args) throws Exception {

        QuartzTest example = new QuartzTest();
        example.run();
    }
}
