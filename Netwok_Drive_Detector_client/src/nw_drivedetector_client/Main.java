package nw_drivedetector_client;

import java.net.InetAddress;
import java.util.Properties;
import java.util.Enumeration;
public class Main {

    
    public static void main(String[] args) 
    {
        try
        {
            //new Detector();
            System.out.println(InetAddress.getLocalHost());
            
            //Properties is a data structure that holds
            //values as key-value pairs.
            //Here the keys are unique.
            Properties sys_props = System.getProperties();
            
            //add a key-value pair
            sys_props.put("Coding", "Java");

            //Enumeration object is an iterator over the
            //data structure (like Properties).
            //Its hasMoreElements() method returns a boolean
            //indicating presence of one more element in
            //the data structure.
            //Its nextElement() jumps to the next element (if
            //available) and returns the data.
            Enumeration en = sys_props.keys();
            
            String k,v;
            while(en.hasMoreElements())
            {
                k = (String) en.nextElement();//jump to the next element (if availabe) and return the data (key).
                //WRT the key fetch the value
                v = (String) sys_props.get(k);
                
                System.out.println(k +" : " + v);
            }
            
            //System.out.println("Country: " + System.getProperty("user.country"));
            //System.out.println("OS: " + System.getProperty("os.name"));
            //System.out.println("Language: " + System.getProperty("user.language"));
            //System.out.println("User Name: " + System.getProperty("user.name"));
            //System.out.println("Home Directory: " + System.getProperty("user.home"));
            
            
        }
        catch(Exception ex){}
    }
    
}
