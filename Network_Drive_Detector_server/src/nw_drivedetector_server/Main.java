package nw_drivedetector_server;

public class Main {

    public static void main(String[] args) 
    {
        try
        {
            //new Server(9898);
            TTS obj = TTS.getSynthesizer();
            obj.speak("Add $20 to account 55374.");
            obj.speak("Rohan, Rohan, have you reached central st.");
            obj.speak("How is the, quality of, voice?");
            obj.speak("Please, plan to do, more work, on speech synthesis");

            obj.deallocate();
        }
        catch(Exception ex)
        {
            System.out.println("Err: " + ex);
        }
        
    }//main
    
}
