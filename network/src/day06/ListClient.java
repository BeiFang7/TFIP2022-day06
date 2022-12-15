package day06;

import java.net.Socket;

public class ListClient {
  public static void main(String[] args) throws Exception{
    /*Type in CMD: java -cp classes day06.ListClient 10 100 localhost 8080 --> to run LISTCLIENT*/

    //Get the list size
    Integer num = Integer.parseInt(args[0]);

    //Get the limit
    Integer limit = Integer.parseInt(args[1]);

    //Get the host
    String host = args[2];

    //Get the port
    Integer port = Integer.parseInt(args[3]);

    //Create the socket to the server
    Socket cs = new Socket(host,port);

    System.out.printf("Connected to %s:%d on %d\n", host, port, cs.getPort()); //getPort is the port connected to

    IOUtils.write(cs,"%d %d".formatted(num,limit));

    String response = IOUtils.read(cs);

    //Process response - calculate the average;
    String[] listOfNumbers = response.split(":");
    Integer sum=0;
    for (Integer j=0; j<listOfNumbers.length;j++){
      Integer number = Integer.parseInt(listOfNumbers[j]);
      sum = sum + number;
    }
    Float average = (float) sum/(listOfNumbers.length);
    System.out.printf("Average: %.2f", average);

    cs.close();

    
    /*//Client opens Output Stream --> means Server should open Input Stream
    OutputStream os = cs.getOutputStream();
    BufferedOutputStream bos = new BufferedOutputStream(os);
    
    //Write "n limit" --> want n numbers from 0 to limit
    bos.write(num);
    bos.write(limit);
    bos.flush();

    //Client closes the Output Stream
    os.close();

    //Client opens the Input Stream --> means Server should open Output Stream
    //Read in Server Output and print out
    InputStream cis = cs.getInputStream();
    BufferedInputStream bcis = new BufferedInputStream(is);

    List<Integer> fromServerList = new LinkedList<>();

    for (Integer j = 0; j<num; j++){
      fromServerList.add(bcis.read());
      System.out.println(fromServerList.get(j));
    }

    //Client closes Input Stream
    cis.close();
    cs.close();*/

    
    
    

    
    
    
  }
}
  

