package inflearn.java.concurrent.programming.section04.lec02;

public class FlagThreadStopExample {

  private volatile static boolean running = true;

  public static void main(String[] args) {
    new Thread(() -> {
      int count = 0;
      while (running) {
        count++;
      }
      System.out.println("스레드1 종료, count: " + count);
    }).start();

    new Thread(() -> {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("스레드2 종료");
      running = false;
    }).start();


  }
}
