package thread.control.join;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class JoinMainV1 {
    // 참고!
    // main 쓰레드가 실행한 start()는 쓰레드의 실행이 끝날 때까지 기다리지 않는다.
    // 다른 쓰레드를 실행만 해두고, 자신의 다음 코드를 실행한다.
    public static void main(String[] args) {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
        log("task1 + task2 = " + sumAll);
        log("End");

        // 다들 0을 출력함 이유는 왤까?
        /*
        main 쓰레드는 thread1과 thread2에 각각 작업을 지시한다.
        thread1과 thread2가 작업을 끝마치기도 전에 먼저 계산 결과를 조회한다.
        참고로 sleep(2000);을 걸어놨기에 계산을 만료하는데는 2초 정도가 걸린다.
         */

    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }
    }
}
