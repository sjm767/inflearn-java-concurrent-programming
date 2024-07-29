package inflearn.java.concurrent.programming.section04.lec03;

import inflearn.java.concurrent.programming.section04.lec03.NestedThreadGroupExample.GroupRunnable;

public class ThreadGroupScopeExample {

  public static void main(String[] args) throws InterruptedException {
    ThreadGroup topGroup = new ThreadGroup("topGroup");
    ThreadGroup subGroup = new ThreadGroup(topGroup, "subGroup");

    Thread topGroupThread = new Thread(topGroup, () -> {
      System.out.println("상위 그룹 스레드에서 하위 그룹의 최대 우선 순위 설정 변경 전: " + subGroup.getMaxPriority());
      subGroup.setMaxPriority(7);
      System.out.println("상위 그룹 스레드에서 하위 그룹의 최대 우선 순위 설정 변경 후: " + subGroup.getMaxPriority());
    }, "topGroupThread");
    Thread subGroupThread = new Thread(subGroup, () -> {
      System.out.println("하위 그룹 스레드에서 상위 그룹의 최대 우선 순위 설정 변경 전: " + subGroup.getMaxPriority());
      topGroup.setMaxPriority(4);
      System.out.println("하위 그룹 스레드에서 상위 그룹의 최대 우선 순위 설정 변경 후: " + subGroup.getMaxPriority());
    }, "subGroupThread");

    topGroupThread.start();
    subGroupThread.start();

    topGroupThread.join();
    subGroupThread.join();

    System.out.println(topGroupThread.getName() + " : " + topGroupThread.getPriority());
    System.out.println(subGroupThread.getName() + " : " + subGroupThread.getPriority());

    Thread userThread1 = new Thread(topGroup, () -> {
    }, "userThread1");
    Thread userThread2 = new Thread(topGroup, () -> {
    }, "userThread2");

    userThread1.setPriority(10); //개별로 우선순위를 적용해도 적용되지 않음. (스레드 그룹의 우선순위가 우선적용됨)
    userThread2.setPriority(10);

    System.out.println(userThread1.getName() + " : " + userThread1.getPriority());
    System.out.println(userThread2.getName() + " : " + userThread2.getPriority());

  }
}
