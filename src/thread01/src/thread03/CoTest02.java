package thread01.src.thread03;

/**
 * 协作模型：生产者消费者实现方式2：信号灯法
 * 借助标志位
 */
public class CoTest02 {
    public static void main(String[] args) {
        Tv tv=new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

class Player extends Thread{
    Tv tv;
    public Player(Tv tv) {
        this.tv=tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            if (i % 2 == 0) {
                this.tv.play("火影");
            }else{
                this.tv.play("犬夜叉");
            }
        }
    }
}
//消费者 观众
class Watcher extends Thread{
    Tv tv;
    public Watcher(Tv tv) {
        this.tv=tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}
//电视
class Tv{
    String voice;
    //信号灯true 节目准备，观众等待,false 观众观看，节目等待
    boolean flag=true;
    //表演
    public synchronized void play(String voice) {
    //节目准备
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //表演
        System.out.println("播放了"+voice);
        this.voice=voice;
        //唤醒
        this.notifyAll();
        this.flag=!this.flag;
    }
    //观看
    public synchronized void watch() {
        //观众等待
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了："+voice);
        //唤醒
        this.notifyAll();
        //切换标志
        this.flag=!this.flag;
    }
}
