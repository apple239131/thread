package thread01.src;

/**
 * lambda表达式，简化线程（用一次）的使用
 */
public class LambdaThread {
    //静态内部类,使用时才编译
    static class Test implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("听歌1");
            }
        }
    }

    public static void main(String[] args) {
        // new Thread(new Test()).start();
        //局部内部类
        class Test2 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("听歌1");
                }
            }
        }
        new Thread(new Test2()).start();

        //匿名内部类，没有类名实现类名称,只能借助接口或父类
        new Thread(new Runnable(){
            //实现体
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("听歌1");
                }
            }
        }).start();

        //jdk8简化,去掉接口名，方法名，只关注传什么参，实现什么，接口里只能有一个方法
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("听歌1");
            }
        }).start();
    }


}
