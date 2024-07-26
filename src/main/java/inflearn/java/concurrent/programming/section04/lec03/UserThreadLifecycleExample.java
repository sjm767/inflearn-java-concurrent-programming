package inflearn.java.concurrent.programming.section04.lec03;

public class UserThreadLifecycleExample {

  public static void main(String[] args) {

    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        System.out.println("사용자 스레드 1 실행 중");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException();
        }
      }
      System.out.println("사용자 스레드 1 종료");
    });
    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        System.out.println("사용자 스레드 2 실행 중");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException();
        }
      }
      System.out.println("사용자 스레드 2 종료");
    });

    thread1.start();
    thread2.start();

    //join이 없으면 메인스레드가 먼저 종료되고, 사용자 스레드가 종료된다.
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("모든 사용자 스레드가 종료되었습니다. 메인스레드 종료");
  }
}
