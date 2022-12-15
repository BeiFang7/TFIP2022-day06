package day06;

import java.io.IOException;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HandleClient implements Runnable{ //to implement thread

  private Socket socket;
  public HandleClient(Socket socket){
    this.socket= socket;
  }

  @Override
  public void run(){

    //Random number generator
    Random rand = new SecureRandom();
    
    System.out.printf("New Connection on port %d\n", socket.getPort()); //getPort shows the port connected to once established connection; getLocalPort is the 8080 port on localhost Port

    //Random number generator
    Random rnd = new SecureRandom();

    try{

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

      //introduce a delay thread; sleep for 2 secondas to see the threading
      Thread.sleep(2000);

      IOUtils.write(socket,response);
    } catch (Exception e){

    } finally{ //anytime exit or return, before it return it will execute finally. means socket.close() will definitely be executed before it exits the try catch 
      try{
        socket.close();
      } catch(IOException e){

      }
    }

  }
  
}
