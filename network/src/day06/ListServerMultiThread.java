package day06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ListServerMultiThread{
  public static void main (String[] args) throws Exception{ //throws exception
    /*Type in CMD: java -cp classes day06.ListServer 8080 --> to run LISTSERVER*/

    //Get the port
    Integer port = Integer.parseInt(args[0]); //first input after the ListServer

    ExecutorService threadpool = Executors.newFixedThreadPool(5);

    //Create a ServerSocket and bind to the port
    ServerSocket sc = new ServerSocket(port);
    System.out.printf("Listening on port %d\n", port);

    

    //Server loop
    while(true){
      //Wait for a connection
      System.out.println("Waiting for connection...");
      Socket socket = sc.accept();

      for (Integer i=0; i<4;i++){
        RandomListMultiThread worker = new RandomListMultiThread(socket);
        threadpool.submit(worker);
      }
      

      //once have connection via client socket, will print this line
      System.out.printf("New Connection on port %d\n", socket.getPort()); //getPort shows the port connected to once established connection; getLocalPort is the 8080 port on localhost Port

      /*Random rnd = new Random();
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

      IOUtils.write(socket,response);*/

      /*InputStream is = socket.getInputStream();
      BufferedInputStream bis = new BufferedInputStream(is);
      
      //Server opens Input Stream --> means Client should open Output Stream
      //Read Client output "n"
      Integer fromClientNum = bis.read();
      Integer fromClientLimit = bis.read();
      System.out.printf("From Client Num & Limit: %d & %d\n", fromClientNum, fromClientLimit);
      
      //Server closes the Input Stream
      is.close();

      //Generate a list of random numbers in comma separated string
      List<Integer> list = new LinkedList<>();
      for (Integer i = 0; i<fromClientNum; i++){
        Random rand = new Random();
        list.add(rand.nextInt(fromClientLimit));
        System.out.println(list.get(i));
      }

      //Server opens Output Stream --> means Client should open Input Stream
      //Write to Client "..,.."
      OutputStream sos = socket.getOutputStream();
      BufferedOutputStream bsos = new BufferedOutputStream(os);
      
      for (Integer j=0; j<list.size();j++){
        bsos.write(list.get(j));
        System.out.println(list.get(j));
      }

      //Server closes Output Stream
      sos.close();*/

      socket.close();
      
    }


  }
}
