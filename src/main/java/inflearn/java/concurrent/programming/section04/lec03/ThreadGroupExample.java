package inflearn.java.concurrent.programming.section04.lec03;

public class ThreadGroupExample {

  public static void main(String[] args) throws InterruptedException {
    ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();

    ThreadGroup customThreadGroup = new ThreadGroup("custom thread group");

    Thread defaultGroupThread = new Thread(new GroupRunnable(), "defaultGroupThread");
    Thread mainGroupThread = new Thread(mainThreadGroup, new GroupRunnable(), "mainGroupThread");
    Thread customGroupThread = new Thread(customThreadGroup, new GroupRunnable(), "customGroupThread");

    defaultGroupThread.start();
    mainGroupThread.start();
    customGroupThread.start();

    defaultGroupThread.join();
    mainGroupThread.join();
    customGroupThread.join();
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
