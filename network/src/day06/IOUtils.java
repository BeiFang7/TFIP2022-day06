package day06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class IOUtils {
  public static void write(Socket socket, String payload) throws IOException{ //payload what we want to write

    //Get the output stream
    OutputStream os = socket.getOutputStream();
    BufferedOutputStream bos = new BufferedOutputStream(os); 
    DataOutputStream dos = new DataOutputStream(bos);

    //Write the string as UTF
    System.out.printf(">>>> %s\n", payload);
    dos.writeUTF(payload);

    dos.flush();
    //Close output stream in the reverse order of how we open them, so long close os is good enough.
    // dos.close(); //if close input & output stream maybe seemed like closing socket.
    // bos.close();
    // os.close(); 
  }

  public static String read(Socket socket) throws IOException{

    //Get the input stream
    InputStream is = socket.getInputStream();
    BufferedInputStream bis = new BufferedInputStream(is);
    DataInputStream dis = new DataInputStream(bis);

    //Read the payload from the input stream
    String payload = dis.readUTF(); //read UTP, read String so cannot read numbers. If 
    System.out.printf("<<<< %s\n", payload);

    // dis.close();
    // bis.close();
    // is.close();

    return payload;
  }
}
