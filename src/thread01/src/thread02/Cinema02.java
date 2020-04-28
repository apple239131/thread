package thread01.src.thread02;

import java.util.ArrayList;
import java.util.List;

public class Cinema02 {
    public static void main(String[] args) {
        List<Integer> available=new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(5);
        available.add(6);

        List<Integer> seats1=new ArrayList<>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2=new ArrayList<>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);
        Cinema00 cinema00=new Cinema00(available,"华谊兄弟");
        new Thread(new Customer00(cinema00,seats1),"2391").start();
        new Thread(new Customer00(cinema00,seats2),"apple").start();
    }

}

class Customer00 implements Runnable{
    Cinema00 cinema;
    List<Integer> list;

    public Customer00(Cinema00 cinema, List<Integer> list) {
        this.cinema = cinema;
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag=cinema.buyTicket(list);
            if (flag) {
                System.out.println("出票成功"+Thread.currentThread().getName()+">>"+list);
            }else{
                System.out.println("出票失败"+Thread.currentThread().getName()+">>"+list);
            }
        }
    }
}
class Cinema00{
    List<Integer> available;
    String name;

    public Cinema00(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean buyTicket(List<Integer> seats) {
        System.out.println("可用位置为："+available);
        List<Integer> temp=new ArrayList<>();
        temp.addAll(available);

        temp.remove(seats);
        if (available.size() - temp.size() != seats.size()) {
            return false;
        }
        available=temp;
        return true;
    }
}