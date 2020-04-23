package thread01.src.threadstatus;

public class ThreadInfo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());
        //设置名称：真实角色+代理角色
        BaseInfo baseInfo=new BaseInfo("F35");
        Thread t=new Thread(baseInfo);
        t.setName("飞机");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());

    }
}
class BaseInfo implements Runnable{
    public BaseInfo(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+">>>>>"+name);
    }
}
