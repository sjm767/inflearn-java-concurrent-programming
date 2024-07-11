package inflearn.java.concurrent.programming.section03.lec03;

import java.util.concurrent.Executors;

public class InterruptedExample2 {

  public static void main(String[] args) throws InterruptedException {
    Thread thread2 = new Thread(() -> {
      while (!Thread.interrupted()) {
        System.out.println("스레드2 작동 중");
      }
      System.out.println("인터럽트 상태: " + Thread.currentThread().isInterrupted());
    });

    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("스레드1 작동 중..");
        if (i == 2) {
          thread2.interrupt();
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
  }
}
