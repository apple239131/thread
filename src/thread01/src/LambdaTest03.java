package thread01.src;

/**
 * lambda表达式带返回值
 */
public class LambdaTest03 {
    public static void main(String[] args) {
        IInterest interest1=new Interest();
        interest1.lambda(2,3);


        IInterest interest2=(int a,int b)->{
            System.out.println("lambda--?"+(a+b));
            return a+b;
        };
        interest2.lambda(3,4);

        interest2=(c,d)->{
           return c+d;
        };
        interest2.lambda(3,6);


        //省略return
        interest2=(a,b)->a+b;
        System.out.println(interest2.lambda(1,3));
    }
}

interface IInterest{
    int lambda(int a,int b);
}
//外部类
class Interest implements IInterest{
    @Override
    public int lambda(int a, int b) {
        System.out.println("i have --->>"+(a+b));
        return a+b;
    }
}