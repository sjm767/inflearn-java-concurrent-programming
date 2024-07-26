package inflearn.java.concurrent.programming.section03.lec03;

public class InterruptedExample3 {

  public static void main(String[] args) {

    Thread thread = new Thread(() -> {
      while (true) {
        System.out.println("스레드 작동 중..");
        if (Thread.interrupted()) {
          System.out.println("인터럽트 상태가 초기화되었습니다.");
          break;
        }
      }
      System.out.println("스레드 인터럽트 상태: " + Thread.currentThread().isInterrupted());
      System.out.println("Self Interrupt");
      Thread.currentThread().interrupt();
      System.out.println("스레드 인터럽트 상태: " + Thread.currentThread().isInterrupted());
    });

    thread.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    thread.interrupt();

  }

}
