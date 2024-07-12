package inflearn.java.concurrent.programming.section04.lec02;

public class IsInterruptedThreadStopExample {

  public static void main(String[] args) throws InterruptedException {

    Thread worker = new Thread(() -> {
      while (!Thread.interrupted()) {
        System.out.println("작업 스레드가 실행 중..");
      }
      System.out.println("인터럽트 상태1: " + Thread.currentThread().isInterrupted());
      Thread.currentThread().interrupt();
      System.out.println("인터럽트 상태2: " + Thread.currentThread().isInterrupted());
      System.out.println("작업 스레드가 완료되었습니다");
    });

    Thread stopper = new Thread(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      worker.interrupt();
    });

    worker.start();
    stopper.start();

    worker.join();
    stopper.join();

    System.out.println("메인 스레드 종료");
  }
}
