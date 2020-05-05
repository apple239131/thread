package thread01.src.thread03;

/*
协作模型:生产者消费者实现1：管程法，借助缓冲区
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container=new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
    //未加锁
    //Exception in thread "Thread-1" java.lang.ArrayIndexOutOfBoundsException: -1
    //	at thread01.src.thread03.SynContainer.pop(CoTest01.java:58)
    //	at thread01.src.thread03.Consumer.run(CoTest01.java:41)
    //Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: -1
}

//生产者
class Producer extends Thread{
    SynContainer container;

    public Producer(SynContainer container) {
        super();
        this.container=container;
    }
    //生产
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("生产第"+i+"个");
            container.push(new Steambun(i));
        }

    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        super();
        this.container=container;
    }
    //消费
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("消费第"+container.pop().id+"个馒头");
        }
    }
}
//缓冲区
class SynContainer{
  Steambun[] buns=new Steambun[10];//存储容器
  int count=0;//计数器

    //存储，生产
    public synchronized void push(Steambun bun) {

        if (count == buns.length) {
            try {
                this.wait();//容器已满，消费者通知生产解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count]=bun;
        count++;
        //有数据了通知消费
        this.notifyAll();
    }
    //获取 消费
    public synchronized Steambun pop(){
        //没有数据，等待
        if (count == 0) {
            try {
                this.wait();//线程阻塞 等生产者通知消费解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Steambun bun=buns[count];
        this.notifyAll(); //存在空间了，唤醒生产者
        return bun;
    }
}

//产品
class Steambun {
    int id;

    public Steambun(int id) {
        this.id = id;
    }
}

