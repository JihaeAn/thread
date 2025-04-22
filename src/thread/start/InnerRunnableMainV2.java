package thread.start;

import static thread.util.MyLogger.log;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        log("main() start");

        // 익명 클래스
        // 해당 기능을 이 메서드 안에서만 쓴다는 느낌
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                log("run()");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }
}
