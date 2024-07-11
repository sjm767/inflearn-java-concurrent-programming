package inflearn.java.concurrent.programming.section03.lec04;

public class CountingThreadExample {

  public static void main(String[] args) throws InterruptedException {
    Thread maxThread = new CountingThread("우선 순위가 높은 스레드", CountingThread.MAX_PRIORITY);
    Thread normThread = new CountingThread("우선 순위가 기본 스레드", CountingThread.NORM_PRIORITY);
    Thread minThread = new CountingThread("우선 순위가 낮은 스레드", CountingThread.MIN_PRIORITY);

    maxThread.start();
    normThread.start();
    minThread.start();

    maxThread.join();
    normThread.join();
    normThread.join();

    System.out.println("작업 완료");
  }


  static class CountingThread extends Thread {

    private final String threadName;
    private int count = 0;

    public CountingThread(String threadName, int priority) {
      this.threadName = threadName;
      setPriority(priority);
    }

    @Override
    public void run() {
      while (count < 10000000) {
        count++;
      }

      System.out.println(threadName + ": " + count);
    }
  }
}
