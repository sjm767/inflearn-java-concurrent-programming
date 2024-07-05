package inflearn.java.concurrent.programming.section03.lec02;

public class BasicJoinExample {

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      System.out.println("스레드가 3초간 sleep 됩니다");
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    thread.start();
    System.out.println("메인 스레드가 다른 스레드의 완료를 기다립니다");
    try {
      thread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("메인스레드가 계속 진행합니다");
  }

}
