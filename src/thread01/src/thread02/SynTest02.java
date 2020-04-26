package thread01.src.thread02;

public class SynTest02 {
    public static void main(String[] args) {
        Account account=new Account(100,"money");
        SafeDrawing her=new SafeDrawing(account,90,"她");
        SafeDrawing he=new SafeDrawing(account,80,"他");
        he.start();
        her.start();
    }
    //他--->账户余额为：20
    //他--->口袋的钱为：80
    //她--->账户余额为：-70
    //她--->口袋的钱为：90

}
class SafeDrawing extends Thread {
    int drawMoney;//取的钱数
    int total;//得到钱总数
    Account account;//账户

    public SafeDrawing(Account account, int drawMoney, String name) {
        super(name);
        this.account=account;
        this.drawMoney=drawMoney;
    }

    @Override
    public void run() {
        test();
    }

    //目标不对，锁定失败，此处不锁this，需要锁account
    public synchronized void test() {
        if (account.money - drawMoney < 0) {
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money-=drawMoney;
        total+=drawMoney;
        System.out.println(this.getName()+"--->账户余额为："+account.money);
        System.out.println(this.getName()+"--->口袋的钱为："+total);
    }
}
