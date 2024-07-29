package inflearn.java.concurrent.programming.section04.lec03;

public class ThreadGroupAPIExample {

  public static void main(String[] args) {
    ThreadGroup topGroup = new ThreadGroup("상위 그룹");
    ThreadGroup subGroup = new ThreadGroup(topGroup, "하위 그룹");

    Thread[] topThreads = new Thread[5];
    for (int i = 0; i < 5; i++) {
      topThreads[i] = new Thread(topGroup, () -> {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }, "스레드" + i);
      topThreads[i].start();
    }

    Thread[] subThreads = new Thread[5];
    for (int i = 0; i < 5; i++) {
      subThreads[i] = new Thread(subGroup, () -> {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }, "스레드" + i);
      subThreads[i].start();
    }

    System.out.println("상위그룹 활성 스레드 수: " + topGroup.activeCount());
    System.out.println("상위그룹 활성 스레드 그룹 수: " + topGroup.activeGroupCount());

    System.out.println("하위그룹 활성 스레드 수: " + subGroup.activeCount());
    System.out.println("하위그룹 활성 스레드 그룹 수: " + subGroup.activeGroupCount());

    System.out.println("하위그룹의 부모 그룹: " + subGroup.getParent());

    System.out.println("상위그룹은 하위그룹의 부모 또는 조상 그룹인가? " + topGroup.parentOf(subGroup));
  }
}
