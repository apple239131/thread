package thread01.src.thread02;

/**
 * 死锁
 * 同步造成相互不释放资源，相互等待，一般因为同步中持有多个对象的锁
 *
 * 避免：不要同一代码块同时持有多个对象锁
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp m1=new MakeUp(1,"aaa");
        MakeUp m2=new MakeUp(0,"bbb");
        m1.start();
        m2.start();

        //aaa得到了镜子
        //bbb得到了口红



        //bbb得到了口红
        //aaa得到了镜子
        //aaa得到口红，化妆
        //bbb得到镜子，化妆
    }
}
//镜子
class Mirror{

}
//口红
class Lipstic{

}
//化妆
class MakeUp extends Thread{
    static Lipstic lipstic=new Lipstic();
    static Mirror mirror=new Mirror();
    int choice;
    String name;

    public MakeUp(int choice, String name) {
        this.choice=choice;
        this.name=name;
    }

    public void run() {
        //化妆
        makeup();
    }

    //相互持有对方的锁 可能死锁
    private void makeup() {
        if (choice == 0) {
            synchronized (lipstic) {
                System.out.println(this.name+"得到了口红");
                //想拥有镜子
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                synchronized (mirror) {
//                    System.out.println(this.name+"得到镜子，化妆");
//                }
            }
            synchronized (mirror) {
                System.out.println(this.name+"得到镜子，化妆");
            }
        }else {
            synchronized (mirror) {
                System.out.println(this.name+"得到了镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                synchronized (lipstic) {
//                    System.out.println(this.name+"得到口红，化妆");
//                }
            }
            synchronized (lipstic) {
                System.out.println(this.name+"得到口红，化妆");
            }
        }
    }

}
