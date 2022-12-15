package day06;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomListMultiThread implements Runnable {

  private Socket socket;

  public RandomListMultiThread (Socket socket){
    this.socket = socket;
  }

  @Override
  public void run(){

      try{
        Random rnd = new Random();
        String payload = IOUtils.read(socket);
        String[] values = payload.split(" ");
        Integer count = Integer.parseInt(values[0]);
        Integer limit = Integer.parseInt(values[1]);
        List<Integer> randNums = new LinkedList<>();

        for (Integer i=0; i<count;i++){
        randNums.add(rnd.nextInt(limit));
        }
        String response = randNums.stream()
          .map (v -> v.toString()) //lambda looping through entire String, for every number convert to String and connect using : to a String
          .collect(Collectors.joining(":")); //joining default is a comma, unless specified

        IOUtils.write(socket,response);
      } catch (IOException e) {}
      
  }
  
}
