package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class ThreadStopMainV4 {

    /**
     * Thread.isInterrupted() : 스레드의 인터럽트 상태를 단순히 확인
     * Thread.interrupted()   : 직접 체크해서 사용
     * - 스레드가 인터럽트 상태라면 true를 반환하고, 해당 스레드의 인터럽트 상태를 false로 변경해준다.
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
            while (!Thread.interrupted()) { // 인터럽트 상태는 변경 O
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
