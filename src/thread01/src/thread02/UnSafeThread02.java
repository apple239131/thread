package thread01.src.thread02;

public class UnSafeThread02 {
    public static void main(String[] args) {

        Account account=new Account(100,"钱");
        Drawing you=new Drawing(account,80,"你");
        Drawing her=new Drawing(account,90,"她");
        you.start();
        her.start();
        //你--->账户余额为：20
        //她--->账户余额为：-70
        //你--->口袋的钱为：80
        //她--->口袋的钱为：90
    }


}
class Account{
    int money;
    String name;

    //账户
    public Account(int money, String name) {
        this.money=money;
        this.name=name;
    }

}
class Drawing extends Thread{
    Account account;//取钱的账户
    int drawMoney;//取的钱数
    int total;//得到钱总数
    public Drawing(Account account,int drawMoney,String name){
        super(name);
        this.account=account;
        this.drawMoney=drawMoney;
    }

    @Override
    public void run() {
        if (account.money - drawMoney < 0) {
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money-=drawMoney;
        total+=drawMoney;
        System.out.println(this.getName()+"--->账户余额为："+account.money);
        System.out.println(this.getName()+"--->口袋的钱为："+total);
    }
}