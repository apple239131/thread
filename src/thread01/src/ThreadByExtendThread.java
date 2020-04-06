package thread01.src;

/**
 * 创建线程1：
 * 继承Thread类，重写run()方法
 */
public class ThreadByExtendThread extends Thread {


    public static void main(String[] args) {
        //创建子类对象，调用start()方法启动线程
        ThreadByExtendThread threadByExtendThread =new ThreadByExtendThread();
        threadByExtendThread.start();
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Test");
        }

    }
}
