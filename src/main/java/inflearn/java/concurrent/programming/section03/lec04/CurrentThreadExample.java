package inflearn.java.concurrent.programming.section03.lec04;

public class CurrentThreadExample {

  public static void main(String[] args) {

    System.out.println("현재 스레드: " + Thread.currentThread().getName());
    Thread thread = new Thread(new ThreadName());
    thread.start();
  }

  static class ThreadName implements Runnable {

    @Override
    public void run() {
      System.out.println("현재 스레드: " + Thread.currentThread());
      System.out.println("현재 스레드 이름(getName사용): " + Thread.currentThread().getName());
    }
  }
}
