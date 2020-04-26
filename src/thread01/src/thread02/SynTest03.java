package thread01.src.thread02;

public class SynTest03 {
    public static void main(String[] args) {
        Account account = new Account(100, "money");
        SymBlockTest01 her = new SymBlockTest01(account, 90, "她");
        SymBlockTest01 he = new SymBlockTest01(account, 80, "他");
        he.start();
        her.start();
    }
    //total为100时
    //他--->账户余额为：20
    //他--->口袋的钱为：80
    //total为1000时
    //他--->账户余额为：920
    //他--->口袋的钱为：80
    //她--->账户余额为：830
    //她--->口袋的钱为：90
}

class SymBlockTest01 extends Thread {
    int drawMoney;//取的钱数
    int total;//得到钱总数
    Account account;//账户

    public SymBlockTest01(Account account, int drawMoney, String name) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        test();
    }

    //目标锁定account
    public void test() {
        if (account.money <= 0) {
            return;
        }
        //同步块
        synchronized (account) {
            if (account.money - drawMoney < 0) {
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawMoney;
            total += drawMoney;
            System.out.println(this.getName() + "--->账户余额为：" + account.money);
            System.out.println(this.getName() + "--->口袋的钱为：" + total);
        }
    }
}
