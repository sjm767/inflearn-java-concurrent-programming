package inflearn.java.concurrent.programming.section04.lec04;

public class InheritableThreadLocalExample {

  private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
//  private static ThreadLocal<String> inheritableThreadLocal = new ThreadLocal<>();

  public static void main(String[] args) throws InterruptedException {
    inheritableThreadLocal.set("부모 스레드의 값");

    Thread thread = new Thread(() -> {
      System.out.println("자식 스레드에서 부모로부터 상속받은 값: " + inheritableThreadLocal.get());

      inheritableThreadLocal.set("자식 스레드의 새로운 값");
      System.out.println("자식 스레드에서 설정한 후의 값: " + inheritableThreadLocal.get());
    });

    thread.start();
    thread.join();

    System.out.println("부모 스레드의 값: " + inheritableThreadLocal.get());
  }

}
