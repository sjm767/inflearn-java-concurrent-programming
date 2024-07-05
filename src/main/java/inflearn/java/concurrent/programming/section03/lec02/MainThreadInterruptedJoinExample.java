package inflearn.java.concurrent.programming.section03.lec02;

public class MainThreadInterruptedJoinExample {

  public static void main(String[] args) {
    Thread mainThread = Thread.currentThread();

    Thread longRunningThread = new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          System.out.println("긴 작업 스레드가 계속 실행 중..");
          Thread.sleep(1000);
        }
      } catch (InterruptedException e) {
        System.out.println("긴 작업 스레드가 인터럽트 걸림");
//        mainThread.interrupt();
      }
    });

    Thread interruptingThread = new Thread(() -> {
      try {
        Thread.sleep(1000);
        longRunningThread.interrupt();
      } catch (InterruptedException e) {

      }
    });

    longRunningThread.start();
    interruptingThread.start();

    try {
      System.out.println("메인 스레드가 긴 작업 스레드를 기다립니다");
      longRunningThread.join();
      System.out.println(longRunningThread.isInterrupted());
      System.out.println("메인 스레드 작업이 끝났습니다");
    } catch (InterruptedException e) {
      System.out.println("메인 스레드가 join 중에 인터럽트 걸렸습니다");
      throw new RuntimeException(e);
    }
  }
}
