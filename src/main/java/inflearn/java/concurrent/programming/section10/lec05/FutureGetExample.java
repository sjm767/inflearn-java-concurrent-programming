package inflearn.java.concurrent.programming.section10.lec05;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureGetExample {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Future<String> future = executorService.submit(() -> {
      System.out.println("비동기 작업 시작...");
      Thread.sleep(2000);
      System.out.println("비동기 작업 완료");
      return "OK";
    });

    try {
      String result = future.get();
      System.out.println("result: " + result);
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("인터럽트 되었습니다");
    }

    executorService.shutdown();
  }
}
