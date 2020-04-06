package thread01.src;

public class RacerByRunnable implements Runnable {
    private static String winner;


    public static void main(String[] args) {
        RacerByRunnable racer=new RacerByRunnable();
        new Thread(racer,"乌龟").start();
        new Thread(racer,"兔子").start();
    }
    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps++) {
            if(Thread.currentThread().getName().equals("乌龟")){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"--->>"+steps);
            boolean flag=gameOver(steps);
            if (flag) {
                break;
            }
        }
    }

    public boolean gameOver( int steps){
        if (winner != null) {
            return true;
        }else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner==>>"+winner);
                return true;
            }
        }
        return false;
    }
}
