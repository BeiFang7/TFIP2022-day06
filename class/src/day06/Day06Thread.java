package day06;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day06Thread {
  public static void main(String[] args){
    
    List<Integer> numList = new LinkedList<>();

    //To try a thread, need to get CPU thread from the system. Need to create your own thread. Ask executor service to give you x number of threads, in this case, 2 threads. Why limit to 2, because threads are bound by numbers of actual threads. If there are 100 threads but no 100 threads on your machine, it is useless. And there are also other programs in the CPU running. The more you acquire, the less there is for other resources. 
    /*have many kinds of threadpools.newScheduledThreadPool that can run at scheduled times. There are threadpools that have their own characteristics. Can set minimum number of thread 1, then if got work then it can goes up to maximum numbers of thread. will not exit if have the executor. need to hit ctrl c to exit*/

    ExecutorService threadpool = Executors.newFixedThreadPool(2);

    for(Integer i =0; i<3 ;i++){
      //just an object implementing runnable when creating the class. Unless you run the thread in the threadpool, then this is creating a thread.

      //Create a thread
      RandomNumbers thr = new RandomNumbers("thr-%d".formatted(i),100,numList);

      /*//if i call run myself, it is running on the main thread. so this is not a thread.
      thr.run();*/

      /*If you run a thread into a threadpool, it is running on a separate thread */
      //Schedule a thread to the Runnable
      threadpool.submit(thr);
    }
    System.out.println("All done");

    //NOT correct way to update memoory
    while(true){
      System.out.println("\n>>>> numList: " + numList + ", size: " + numList.size());

      try{
        //Sleep for 5 sec
        Thread.sleep(5*1000);
      } catch(InterruptedException ex)
      {}
    }
    
    
    
    /* (2) //run RandomNumber.java thread
    //have a running thread pool, the program doesnt end.
    //1 thread means the one needs to finish first before it can start the new thread. So only can see after thread 1 finish then thread 2 will start.
    //if increase to 2, then will see that the thread can now interliving. thr-2 starting at the end, because one of the thr-0 and thr-1 finish rnunning then will schedule thr-2 to start running.
    //Order is hard to predict, depends on scheduler and how it is run. The moment you run the thread, you cannot control how the program runs because it is an independent program.
    //Mutli-thread: programmes can communicate through memory
    ExecutorService threadpool = Executors.newFixedThreadPool(2);

    //Create 3 threads, together with main thread, total 4 threads
    for (Integer i=0;i<3;i++){
      //Create a thread
      RandomNumbers thr = new RandomNumbers("thr-%d".formatted(i),100);
      //Scedule a thread to the Runnable
      threadpool.submit(thr);
    }*/

    /* (1) //main thread, when program finish running it will stop.
    Random rand = new SecureRandom();
    for (Integer i=0;i<10;i++){
      System.out.printf(">>> %d\n", rand.nextInt(100));
    }
    System.out.println("Add done");
  } */
  }
}
