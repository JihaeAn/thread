package thread.control.test;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class JoinTest2Main {
    public static void main(String[] args) throws InterruptedException {
        // 총 몇 초가 걸릴까?
        // 3초
/*      14:24:09 956 [       t3] 1
        14:24:09 956 [       t2] 1
        14:24:09 956 [       t1] 1
        14:24:10 963 [       t2] 2
        14:24:10 963 [       t3] 2
        14:24:10 963 [       t1] 2
        14:24:11 967 [       t2] 3
        14:24:11 968 [       t1] 3
        14:24:11 969 [       t3] 3
        모든 스레드 실행 완료*/
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("모든 스레드 실행 완료");
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 3 ; i++) {
                log(i);
                sleep(1000);
            }
        }
    }
}
