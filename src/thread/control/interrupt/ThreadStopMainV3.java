package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    /**
     * while (!Thread.currentThread().isInterrupted())로 인터럽트의 상태를 확인하면
     * while 문을 체크하는 부분에서 더 빠르게 while 문을 빠져나갈 수 있다.

     * work 스레드는 이후에 자원을 정리하는 코드를 실행하는데, 이때도 인터럽트의 상태는 계속 true로 유지된다.
     * 이때 만약 인터럽트가 발생하는 sleep()과 같은 코드를 수행한다면, 해당 코드에서 인터럽트 예외가 발생하게 된다.

     * 자바에서 인터럽트 예외가 한 번 발생하면, 스레드의 인터럽트 상태를 다시 정상 false로 돌리는 것은 이런 이유 때문이다.
     * 스레드의 인터럽트 상태를 정상으로 돌리지 않으면 이후에도 계속 인터럽트가 발생하게 된다.
     * 인터럽트의 목적을 달성하면 인터럽트 상태를 다시 정상으로 돌려두어야 한다.
     */
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100); // 시간 줄일게
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태 1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태는 변경 X
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리 시도");
                Thread.sleep(1000);
                log("자원 정리 완료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태 3 = " + Thread.currentThread().isInterrupted());
            }
            log("작업 종료");
        }
    }
}
