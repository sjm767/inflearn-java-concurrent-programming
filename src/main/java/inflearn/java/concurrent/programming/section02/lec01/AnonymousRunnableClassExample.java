package inflearn.java.concurrent.programming.section02.lec01;

public class AnonymousRunnableClassExample {

  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName() + "스레드 실행 중...");
      }
    });

    thread.start();
  }
}
