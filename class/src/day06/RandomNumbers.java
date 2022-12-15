package day06;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

//want main program Day06Thread.java to run the mini program in RandomNumbers.java
public class RandomNumbers implements Runnable{
  
  private String name;
  private Integer range;
  private List<Integer> numList;
  public RandomNumbers(String name, Integer range , List<Integer> numList) { 
    this.name = name;
    this.range = range;
    this.numList = numList;
  }
  
  //To make multi-thread, need to implement an interface called Runnable
  @Override
  public void run() {
    //The body of the thread, once finish run thread it will die.
    Random rand = new SecureRandom();
    for (Integer i = 0; i < 10; i++) {
      Integer num = rand.nextInt(range);
      numList.add(num);
      System.out.printf("%d [%s] %d\n", i, name, num);
      try {
          // Sleep for 2 sec
          Thread.sleep(2 * 1000);
      } catch (InterruptedException ex) 
      { }
    }
  }
}
