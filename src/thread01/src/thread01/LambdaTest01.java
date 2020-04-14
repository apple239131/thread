package thread01.src.thread01;

/**
 * lambda推导，无参版
 */

public class LambdaTest01 {

    //2静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I don't Like lam2");
        }
    }


    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();
        //3匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I don't Like lam4");
            }
        };
        like.lambda();

        //4方法内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I don't Like lam3");
            }
        }
        like = new Like3();
        like.lambda();


        //lambda，必需有个类型
        like = () -> {
            System.out.println("I don't Like lam5");
        };
        like.lambda();
    }
}

interface ILike {
    void lambda();
}

//1外部类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I don't Like lam1");
    }
}