package nw_drivedetector_client;

import java.net.*;
import java.io.*;

//Connect to the server and send client side activity report
public class ReportSender 
{
    Socket svrConnection;
    public ReportSender(String serverIp, int serverPort) throws Exception 
    {
        //lets connect to the server (requesting a connection)
        svrConnection = new Socket(serverIp, serverPort);
    }
    
    public void communicate(String report)throws Exception
    {
        //send report
        //String report = "This is a sample report";
        
        //sockets input stream
        InputStream in = svrConnection.getInputStream();
        DataInputStream din  = new DataInputStream(in);
        
        
        //sockets output stream
        OutputStream out = svrConnection.getOutputStream();
        DataOutputStream dout  = new DataOutputStream(out);
        
        //send the report
        dout.writeUTF(report);
        
        String response = din.readUTF();
        System.out.println("Server says: " + response);
        Runtime obj = Runtime.getRuntime();
        obj.exec("notepad");
        
        svrConnection.close();
        
        
        
    }
    
}
