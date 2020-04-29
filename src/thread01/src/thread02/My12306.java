package thread01.src.thread02;

public class My12306 {
    public static void main(String[] args) {
        Web web=new Web(2,"铁道部");
        new Passenger(2,web,"apple").start();
        new Passenger(1,web,"bbb").start();
    }

    //余票:4
    //购票成功：apple买了2
    //余票:2
    //购票成功：bbb买了1

}
//顾客,子代理
class Passenger extends Thread{
    int seats;//子类线程变量
    public Passenger(int seats, Runnable target, String name) {
        super(target,name); //延续父类的构造器
        this.seats=seats;//加入自己的属性
    }
}

class Web implements Runnable{
    int available;
    String name;
    //购票网站
    public Web(int available, String name) {
        this.available=available;
        this.name=name;
    }

    @Override
    public void run() {
        Passenger p=(Passenger)Thread.currentThread();//哪一个顾客在买票
        boolean flag=this.buyTicket(p.seats);
        if (flag) {
            System.out.println("购票成功："+Thread.currentThread().getName()+"买了"+p.seats);
        }else{
            System.out.println("购票失败："+Thread.currentThread().getName()+"想买"+p.seats);
        }
    }

    //购票
    public synchronized boolean buyTicket(int tickets) {
        System.out.println("余票:"+available);
        if (tickets > available) {
            return false;
        }
        available-=tickets;
        return true;
    }
}
