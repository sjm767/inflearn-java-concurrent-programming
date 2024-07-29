package inflearn.java.concurrent.programming.section05.lec03;

public class CriticalSectionExample {

  public static void main(String[] args) throws InterruptedException {
    SharedResource resource = new SharedResource();

    Thread t1 = new Thread(resource::increment);
    Thread t2 = new Thread(resource::increment);

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println(resource.getCounter());
  }

}
