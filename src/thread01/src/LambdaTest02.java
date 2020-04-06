package thread01.src;

/**
 * lambda表达式带参数
 */
public class LambdaTest02 {

    public static void main(String[] args) {
        ILove love = new Love();
        love.lambda(123);

        //lambda
        ILove love1 = (int a) -> {
            System.out.println("lam--------->  " + a);
        };
        love1.lambda(231);

        //参数类型可省略
        ILove love2 = (b) -> {
            System.out.println("lam--------->  " + b);
        };
        love2.lambda(5643);

        //只有一个参数情况下参数括号也可以省略
        ILove love3 = c -> {
            System.out.println("lam--------->  " + c);
        };
        love3.lambda(365);

        //只有一行代码{}也可以省略
        ILove love4 = d -> System.out.println("lam--------->  " + d);
        love4.lambda(65);

    }
}

interface ILove {
    void lambda(int a);
}

//外部类
class Love implements ILove {
    @Override
    public void lambda(int a) {
        System.out.println("外部--------->  " + a);
    }
}