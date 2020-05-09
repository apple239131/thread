package thread01.src.thread03;

/**
 * 单例模式：懒汉式，多线程模式下，对外存在一个对象
 * 1.构造器私有化，避免外部new构造器
 * 2.提供私有的静态属性-->存储对象的地址
 * 3.提供公共的静态方法-->获得属性
 */
public class DoubleCheckedLocking {
    //1.构造器私有化
    private DoubleCheckedLocking() {

    }

    //2.提供私有静态属性,没有volatile，其他线程可能访问一个没有初始化的对象
    private volatile static DoubleCheckedLocking instance;

    //3.提供公共的静态方法-->获取属性
    public static DoubleCheckedLocking getInstance() {
        if (null != instance) { //如果已经存在对象，避免不必要的同步
            return instance;
        }
        synchronized (DoubleCheckedLocking.class) {
            //new对象时
            //1.开辟空间 2.初始化对象信息 3.返回对象的地址给引用
            if (null == instance) {
                instance = new DoubleCheckedLocking();
            }
        }
        return instance;
    }

    //去掉同步
    public static DoubleCheckedLocking getInstance2(long time) {
        //new对象时
        //1.开辟空间 2.初始化对象信息 3.返回对象的地址给引用
        if (null == instance) {
            try {
                //模拟延时
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new DoubleCheckedLocking();
        }
        return instance;
    }

    public static void main(String[] args) {
//        Thread t = new Thread(() -> {
//            System.out.println(DoubleCheckedLocking.getInstance());
//        });
//        t.start();
//        System.out.println(DoubleCheckedLocking.getInstance());
        //thread01.src.thread03.DoubleCheckedLocking@5fd0d5ae
        //thread01.src.thread03.DoubleCheckedLocking@5fd0d5ae


        Thread t2=new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance2(1000));
        });
        t2.start();
        System.out.println(DoubleCheckedLocking.getInstance2(2000));
        //thread01.src.thread03.DoubleCheckedLocking@1b9c704e
        //thread01.src.thread03.DoubleCheckedLocking@5fd0d5ae
    }



}
