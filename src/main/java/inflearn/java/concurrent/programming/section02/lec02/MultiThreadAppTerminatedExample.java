package inflearn.java.concurrent.programming.section02.lec02;

import inflearn.java.concurrent.programming.section02.lec02.ThreadStackExample.MyRunnable;

public class MultiThreadAppTerminatedExample {

  public static void main(String[] args) {

    for (int i = 0; i < 3; i++) {
      Thread thread = new Thread(new MyRunnable(i));
      thread.start();
    }

    System.out.println("메인 스레드 종료");
  }

}
