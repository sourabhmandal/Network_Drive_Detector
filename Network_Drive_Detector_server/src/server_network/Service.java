package server_network;

public class Service 
{
    static String echo(String data)
    {
        return "[" + data.toUpperCase() + "]";
    }
    
}