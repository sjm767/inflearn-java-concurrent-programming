package inflearn.java.concurrent.programming.section04.lec04;

public class ThreadLocalExample {


  //  private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
  private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "Hello World");

  public static void main(String[] args) {

    Thread thread1 = new Thread(() -> {
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
      threadLocal.set("스레드 1의 값");
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
    });

    Thread thread2 = new Thread(() -> {
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
      threadLocal.set("스레드 2의 값");
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
      threadLocal.remove();
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
    });

    thread1.start();
    thread2.start();

  }

}
