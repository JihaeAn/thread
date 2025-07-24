package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
    /**
     * 예를 들어서, 특정 스레드가 Thread.sleep()을 통해 쉬고 있는데,
     * 처리해야 하는 작업이 들어와서 해당 스레드를 급하게 깨워야 할 수 있다.
     * 또는 sleep()으로 쉬고 있는 스레드에게 더는 일이 없으니, 작업 종료를 지시할 수도 있다.
     * 인터럽트를 사용하면, WAITING, TIMED_WAITING 같은 대기 상태의 스레드를 직접 깨워서,
     * 작동하는 RUNNABLE 상태로 만들 수 있다.

     * 참고로 interrupt()를 호출했다고 해서 즉각 InterruptedException이 발생하는 것은 아니다.
     * 오직 sleep()처럼 InterruptedException을 던지는 메서드를 호출하거나 또는 호출 중일 때 예외가 발생한다.
     */

    /**
     * 그러나 이 코드의 아쉬운 점은 인터럽트가 발생해도
     * while (true) <- 이 부분은 항상 true기 때문에 다음 코드로 넘어간다.
     * 그리고 sleep()을 호출하고 나서야 인터럽트가 발생하는 것이다.
     */
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태 1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    log("작업 중");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());
                log("interrupted message = " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}
