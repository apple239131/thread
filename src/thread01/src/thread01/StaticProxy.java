package thread01.src.thread01;

/**
 * 静态代理
 * 公共接口
 * 1.真实角色
 * 2.代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
        // 类比 new Thread(具体线程对象).start();
    }


}

interface Marry {
    void happyMarry();
}

class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("you will be married");
    }
}

//代理角色
class WeddingCompany implements Marry {
    //具体角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("收拾--------");
    }

    private void ready() {
        System.out.println("准备---------");
    }
}