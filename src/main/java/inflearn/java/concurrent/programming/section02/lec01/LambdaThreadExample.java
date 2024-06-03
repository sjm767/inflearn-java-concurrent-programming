package inflearn.java.concurrent.programming.section02.lec01;

public class LambdaThreadExample {

  public static void main(String[] args) {
    Thread thread =
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " 스레드 실행 중"));

    thread.start();

  }
}
