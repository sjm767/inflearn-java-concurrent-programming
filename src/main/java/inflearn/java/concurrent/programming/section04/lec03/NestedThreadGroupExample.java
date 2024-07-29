package inflearn.java.concurrent.programming.section04.lec03;


public class NestedThreadGroupExample {

  public static void main(String[] args) throws InterruptedException {
    ThreadGroup topGroup = new ThreadGroup("topGroup");
    ThreadGroup subGroup = new ThreadGroup(topGroup, "subGroup");

    Thread topGroupThread = new Thread(topGroup, new GroupRunnable(), "topGroupThread");
    Thread subGroupThread = new Thread(subGroup, new GroupRunnable(), "subGroupThread");

    topGroupThread.start();
    subGroupThread.start();

    topGroupThread.join();
    subGroupThread.join();

    topGroup.list();
    subGroup.list();
  }

  static class GroupRunnable implements Runnable {

    @Override
    public void run() {
      Thread currentThread = Thread.currentThread();
      System.out.println(
          currentThread.getName() + " 는 " + currentThread.getThreadGroup().getName() + " 에 속한다");
    }
  }
}
