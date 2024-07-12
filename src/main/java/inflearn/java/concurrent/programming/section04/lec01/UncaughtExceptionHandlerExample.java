package inflearn.java.concurrent.programming.section04.lec01;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionHandlerExample {

  public static void main(String[] args) {

    Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
      System.out.println(t.getName() + " 디폴트 ExceptionHandler를 통한 처리: " + e);
    });

    Thread thread1 = new Thread(() -> {
      System.out.println("스레드1 시작!");

      //예기치 않은 예외
      throw new RuntimeException("예기치 않은 예외!");
    });

    Thread thread2 = new Thread(() -> {
      System.out.println("스레드2 시작!");
      throw new RuntimeException("스레드2 예외 발생");
    });

    thread1.setUncaughtExceptionHandler(new UncaughtExceptionHandlerImpl());

    thread1.start();
    thread2.start();
  }

  static class UncaughtExceptionHandlerImpl implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
      System.out.println(t + "스레드 예외 처리: " + e.getMessage());
    }
  }
}
