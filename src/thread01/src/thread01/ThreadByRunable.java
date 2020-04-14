package thread01.src.thread01;

public class ThreadByRunable implements Runnable {

    /**
     * 实现Runnable接口，重写run方法
     * 启动：创建实现类对象+Thread.start()
     *避免单继承的局限性，方便共享资源
     */

    public static void main(String[] args) {
        ThreadByRunable t2=new ThreadByRunable();
        Thread thread=new Thread(t2);
        thread.start();
       // new Thread(new ThreadByRunable()).start();
        for (int i = 0; i < 10; i++) {
            System.out.println("play");
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("吃饭");
        }
    }
}
