package inflearn.java.concurrent.programming.section02.lec02;

public class ThreadStartRunExample {

  public static void main(String[] args) {
    Thread thread1 = new Thread(
        () -> System.out.println(Thread.currentThread().getName() + " 스레드 실행 중.."));
    Thread thread2 = new Thread(
        () -> System.out.println(Thread.currentThread().getName() + " 스레드 실행 중.."));
    Thread thread3 = new Thread(
        () -> System.out.println(Thread.currentThread().getName() + " 스레드 실행 중.."));

    thread1.start();
    thread2.start();
    thread3.start();

    System.out.println("메인 스레드 종료");
  }
}
