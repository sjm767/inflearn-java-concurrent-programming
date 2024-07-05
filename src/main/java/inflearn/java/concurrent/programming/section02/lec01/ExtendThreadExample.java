package inflearn.java.concurrent.programming.section02.lec01;

public class ExtendThreadExample {
  public static void main(String[] args) {
    MyThread thread1 = new MyThread();
    thread1.start();
  }
}

class MyThread extends Thread {
  public void run() {
    System.out.println(Thread.currentThread().getName() + " 스레드 실행 중..");
  }
}

