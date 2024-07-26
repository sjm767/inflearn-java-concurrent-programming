package inflearn.java.concurrent.programming.section10.lec05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.LongStream;

public class FutureCancelInterruptExample {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Callable<String> task = () -> {
      System.out.println("비동기 작업 시작...");
      try {
        for (long i = 0; i < 999999999999999L; i++) {
          Thread.sleep(10);
          System.out.println("idx: " + i);
        }
      } catch (InterruptedException e) {
        System.out.println("작업이 인터럽트 됨");
      }
      System.out.println("비동기 작업 종료");
      return "OK";
    };

    Future<String> future = executorService.submit(task);

    Thread.sleep(2000);
    System.out.println("작업 취소 요청");
    future.cancel(true);
    System.out.println("작업 취소 요청 완료");

    executorService.shutdown();
  }
}
