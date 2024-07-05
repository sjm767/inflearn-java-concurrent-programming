package inflearn.java.concurrent.programming.section03.lec02;

public class MultiThreadJoinExample {

  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
      System.out.println("스레드1이 3초 동안 동작합니다");
      try {
        Thread.sleep(3000);
        System.out.println("스레드1이 작업을 완료함");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    Thread thread2 = new Thread(() -> {
      System.out.println("스레드2가 2초 동안 동작합니다");
      try {
        Thread.sleep(2000);
        System.out.println("스레드2가 작업을 완료함");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    thread1.start();
    thread2.start();

    System.out.println(thread1.isAlive());
    try {
      thread1.join();
      thread2.join();
      System.out.println("메인 스레드가 계속 진행합니다");
      System.out.println(thread1.isAlive());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }

}
