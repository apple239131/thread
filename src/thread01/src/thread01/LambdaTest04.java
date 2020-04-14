package thread01.src.thread01;

public class LambdaTest04 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("学习java");
        }).start();

        new Thread(() -> System.out.println("lambda")).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("学习" + i);
            }
        }
        ).start();
    }
}
