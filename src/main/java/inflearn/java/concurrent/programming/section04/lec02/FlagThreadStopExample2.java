package inflearn.java.concurrent.programming.section04.lec02;

import java.util.concurrent.atomic.AtomicBoolean;

public class FlagThreadStopExample2 {

  private static AtomicBoolean running = new AtomicBoolean(true);

  private void flagTest() {
    new Thread(() -> {
      long count = 0;
      while (running.get()) {
        count++;
      }
      System.out.println("스레드 종료. count: " + count);
    }).start();
  }

  public static void main(String[] args) {
    new FlagThreadStopExample2().flagTest();

    new Thread(() -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      running.set(false);
      System.out.println("스레드 중지 요청");
    }).start();
  }
}
