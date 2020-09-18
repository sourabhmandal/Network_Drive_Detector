package server_network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    ServerSocket port;
    ConnectionManager cmgr;
    
    Server(int portNumber) throws IOException
    {
        //open a port
        port = new ServerSocket(portNumber);
        //activate the ConnectionManager
        cmgr = new ConnectionManager();
        
    }
    
    //nested class
    class ConnectionManager extends Thread
    {
        boolean connection_flag;
        
        ConnectionManager()
        {
            connection_flag = true;
            start();//activate the thread
        }
        
        void stopConnectionManager()
        {
            connection_flag = false;
        }
        
        public void run()
        {
            while(connection_flag )
            {
                acceptConnection();
            }
            try
            {
                port.close();
            }
            catch(Exception ex)
            {}
        }//run

        void acceptConnection()
        {
            
            //port.accept()
            //1) Blocks the program control and waits for a client connection request. 
            //2) On a client connection request.
            //3) Forms a connection (stream of data transfer between the server and the client).

            try
            {
                System.out.println("Waiting for a client connection request...");
                Socket s = port.accept();
                //a new thread per connection
                new ProcessConnection(s);
                System.out.println("... Got a client connection request!!!");
            }
            catch(Exception ex)
            {}
        }
    }
    
    //ProcessConnection
    class ProcessConnection extends Thread
    {
        Socket client;
        ProcessConnection(Socket s)
        {
            client = s;
            start();//activate the thread
        }
        
        //per connection process
        public void run()
        {
            try
            {
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();
                
                DataInputStream din = new DataInputStream(in);
                DataOutputStream dout = new DataOutputStream(out);
                
                //i/o
                String req = din.readUTF();//client has sent
                String res = Service.echo(req);
                dout.writeUTF(res);
                
                //close the connection
                client.close();
            }
            catch(Exception ex)
            {
                System.out.println("Err: " + ex);
            }
        }
    }
}