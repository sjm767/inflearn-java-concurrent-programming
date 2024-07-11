package inflearn.java.concurrent.programming.section03.lec03;

public class InterruptedExceptionExample {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        System.out.println("스레드가 인터럽트 되었습니다");
        System.out.println("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
      }
    });

    thread.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    thread.interrupt();
    thread.join();

    System.out.println("인터럽트 상태: " + thread.isInterrupted());
  }
}
