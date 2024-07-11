package inflearn.java.concurrent.programming.section03.lec04;

import java.util.stream.IntStream;

public class ThreadNamingExample {

  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
      System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
    }, "MyThread");
    thread1.start();

    Thread thread2 = new Thread(() -> {
      System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
    });

    thread2.setName("YourThread");
    thread2.start();

    IntStream.range(0, 5).forEach(idx -> {
      new Thread(() -> {
        System.out.println("자동 생성 스레드 이름: " + Thread.currentThread().getName());
      }).start();
    });
  }

}
