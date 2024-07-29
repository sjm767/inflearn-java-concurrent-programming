package inflearn.java.concurrent.programming.section04.lec04.logger;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalLogger {

  private static final ThreadLocal<List<String>> THREAD_LOG = ThreadLocal.withInitial(() -> new ArrayList<>());

  public static void addLog(String log) {
    THREAD_LOG.get().add(log);
  }

  public static void printLog() {
    List<String> logs = THREAD_LOG.get();
    System.out.println("[" + Thread.currentThread().getName() + "]" + String.join("->", logs));
  }

  public static void clearLog() {
    THREAD_LOG.remove();
  }

  static class ServiceA {

    public void process() {
      addLog("Service A 로직 수행");
    }
  }

  static class ServiceB {

    public void process() {
      addLog("Service B 로직 수행");
    }
  }

  static class ServiceC {

    public void process() {
      addLog("Service C 로직 수행");
    }
  }
}
