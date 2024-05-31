package inflearn.java.concurrent.programming.section01.lec01;

import java.util.ArrayList;
import java.util.List;

public class ParallelismExample {
  public static void main(String[] args) {
    //    int cpuCores = Runtime.getRuntime().availableProcessors() * 2;
    // CPU 코어수보다 1개 더 많음.
    int cpuCores = 9;

    // CPU 개수를 초과하는 데이터를 생성
    List<Integer> data = new ArrayList<>();

    for (int i = 0; i < cpuCores; i++) {
      data.add(i);
    }

    // CPU 개수를 초과하는 데이터를 병렬로 처리
    long startTime2 = System.currentTimeMillis();

    long sum2 =
        data.parallelStream()
            .mapToLong(
                i -> {
                  try {
                    Thread.sleep(500);
                  } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                  }
                  return i * i;
                })
            .sum();
    long endTime2 = System.currentTimeMillis();
    System.out.println("CPU 개수를 초과하는 데이터를 병렬로 처리하는 데 걸린 시간: " + (endTime2 - startTime2) + "ms");
  }
}
