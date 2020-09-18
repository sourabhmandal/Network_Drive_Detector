package client_network;

import java.io.File;
import java.util.LinkedList;

public class Detector extends Thread {
	boolean detection_flag;
	LinkedList <String> originalDrives;
	
	Detector(){
		detection_flag = true;
		originalDrives = new LinkedList<String>();
        originalDrives.add("C:\\");
                
        start();//activate the thread
    }
    
    //method to execute concurrently (by the Detector thread)
    public void run()
    {
        while(detection_flag)//polling
        {
            try
            {
                activity();
                Thread.sleep(4000);//delay
            }
            catch(Exception ex)
            {}
        }//while
    }
    
    void activity()throws Exception
    {
        //Detecting the currently available drives
        File allDrives[] = File.listRoots();
        //Runtime rt = Runtime.getRuntime();
        for(File currentDrive : allDrives)
        {
            //System.out.println("* " + currentDrive.getAbsolutePath());
            if(!originalDrives.contains(currentDrive.getAbsolutePath()))
            {
                System.out.println("DETECTED : " + currentDrive.getAbsolutePath());
                //rt.exec("notepad");
                ReportSender rs = new ReportSender("127.0.0.1", 9898);
                rs.communicate(currentDrive.getAbsolutePath() + "drive detected");
            }
        }
        System.out.println("-----------------");
    }
    
}
