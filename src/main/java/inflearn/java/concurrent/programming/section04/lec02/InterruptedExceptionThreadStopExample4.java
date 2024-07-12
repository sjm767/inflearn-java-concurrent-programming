package inflearn.java.concurrent.programming.section04.lec02;

public class InterruptedExceptionThreadStopExample4 {

  public static void main(String[] args) throws InterruptedException {

    Thread worker = new Thread(() -> {
      try {
        while (true) {
          System.out.println("worker 스레드 수행 중");
          System.out.println("인터럽트 상태1: " + Thread.currentThread().isInterrupted());

          if (!Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("thread is interrupted");
          }
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
        Thread.sleep(500);
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
