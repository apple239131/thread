package thread01.src.thread03;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("-------start--------");
        System.out.println("Hello World!-"+new Date());
        System.out.println("-------end---------");
    }
}
