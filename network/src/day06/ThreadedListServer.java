package day06;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedListServer{
  public static void main (String[] args) throws Exception{ //throws exception
    /*Type in CMD: java -cp classes day06.ListServer 8080 --> to run LISTSERVER*/

    //Get the port
    Integer port = Integer.parseInt(args[0]); //first input after the ListServer

    //Create a threadpool
    ExecutorService thrpool = Executors.newFixedThreadPool(2);

    //Create a ServerSocket and bind to the port
    ServerSocket sc = new ServerSocket(port);
    System.out.printf("Listening on port %d\n", port);

    //Server loop
    while(true){
      //Wait for a connection
      System.out.println("Waiting for connection...");
      Socket socket = sc.accept();

      //Create a HandleClient to handle the client socket
      HandleClient client = new HandleClient(socket);
      //Do not do this. THIS IS NOT A THREAD
      //client.run(); //just calling run method from another class.
      
      //Submit the Runnable to the threadpool
      thrpool.submit(client);
      
    }


  }
}
