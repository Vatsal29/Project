
package N;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shanks
 */
public class Client {
private String name;
private String address;
private int port;
private DatagramSocket socket;
private InetAddress ip;
private Thread send;
     private int ID = -1;
public Client(String name,String address,int port)
{
    this.name=name;
    this.address=address;
    this.port=port;
}
    
    public boolean openConnection(String address) throws SocketException
    {
    try {
        socket=new DatagramSocket();
        ip=InetAddress.getByName(address);
    } catch (UnknownHostException ex) {
        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
    return true;
    }
    public String getName()
    {
        return name;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public int getPort()
    {
        return port;
    }
   public String receive()
    {
        byte[] data=new byte [1024];
        DatagramPacket packet=new DatagramPacket(data,data.length);
        try{
        socket.receive(packet);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        String message =new String(packet.getData());
     
            return message;
        
    }
    
public void send(final byte[] data)
{
    send =new Thread("Send")
            {
                public void run()
            {
                DatagramPacket packet=new DatagramPacket(data,data.length,ip,port);
                    try {
                        socket.send(packet);
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            };
            send.start();
}

    public void setID(int ID) {
        this.ID=ID;
    }
  
    public void close()
    {
        new Thread()
        {
            
            public void run()
            {
                  synchronized(socket)
        {
        socket.close();
    }
            }
        }.start();
      
    }
   public  int getID()
   {
       return ID;
   }
   
}
