package thread01.src.thread02;

public class Cinema01 {
    public static void main(String[] args) {
        Cinema cinema=new Cinema(4,"华谊兄弟");
        new Thread(new Customer(cinema,3),"apple").start();
        new Thread(new Customer(cinema,3),"2391").start();
    }

    //可用位置为：20
    //可用位置为：20
    //2391购票成功
    //apple购票成功


    //可用位置为：4
    //apple购票成功
    //可用位置为：1
    //2391购票失败

}

class Customer implements Runnable{
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema){
            boolean flag=cinema.buyTickets(seats);
            if (flag) {
                System.out.println(Thread.currentThread().getName()+"购票成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"购票失败");
            }
        }
    }
}
class Cinema{
    int available; //余票
    String name; //名称

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean buyTickets(int seats) {
        System.out.println("可用位置为："+available);
        if (seats > available) {
            return false;
        }
        available-=seats;
        return true;
    }
}
