package inflearn.java.concurrent.programming.section04.lec02;

public class InterruptedExceptionExample {

  public static void main(String[] args) throws InterruptedException {

    Thread worker = new Thread(() -> {
      try {
        while (true) {
          System.out.println("작업 스레드가 실행 중 입니다");
          System.out.println("인터럽트 상태1: " + Thread.currentThread().isInterrupted());
          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
        System.out.println("인터럽트 상태2: " + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
      }

      System.out.println("작업 스레드가 중단되었습니다");
      System.out.println("인터럽트 상태3: " + Thread.currentThread().isInterrupted());
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

  }

}
