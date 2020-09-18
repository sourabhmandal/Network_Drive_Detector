package server_network;

public class Main {

    public static void main(String[] args) 
    {
        try
        {
            new Server(9898);
        }
        catch(Exception ex)
        {
            System.out.println("Err: " + ex);
        }
        
    }//main
    
}

