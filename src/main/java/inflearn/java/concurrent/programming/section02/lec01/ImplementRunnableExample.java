package inflearn.java.concurrent.programming.section02.lec01;

public class ImplementRunnableExample {
  public static void main(String[] args) {
    MyRunnable task = new MyRunnable();
    Thread thread = new Thread(task);
    thread.start();
  }
}

class MyRunnable implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + "스레드 실행 중");
  }
}
