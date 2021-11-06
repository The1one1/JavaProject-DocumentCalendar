import java.text.SimpleDateFormat;   // SimpleDateFormat
import javax.swing.JOptionPane;      // JOptionPane
import java.awt.Desktop;             // Desktop
import java.util.*;                  // scanner class for user input 
import java.io.*;                    // File

class current_time extends Thread {  // current_time class
    String timeToCompare;   // time to compare
    String fileName;        // file name

    public current_time(String fileName, String timeToCompare)   // constructor with parameters
    {  
        this.fileName = fileName;
        this.timeToCompare = timeToCompare;
    }

    @Override
    public void run()  // run method
    {
        boolean flag = true;    // flag
        while (flag)   //this while loop didn't allow thread to reach it's end position
        { 
            Calendar cal = Calendar.getInstance();   // Calendar
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");  // SimpleDateFormat
            String currentTime = sdf.format(cal.getTime());    // current time
            if (currentTime.equals(timeToCompare))    //if current time equals to time to compare
            {
                try {  
                    File file = new File(fileName); 
                    if (!Desktop.isDesktopSupported())// check if Desktop is supported by Platform or not
                    {
                        System.out.println("not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();   // Desktop
                    if (file.exists()) // checks file exists or not
                    {
                        desktop.open(file); // opens the specified file
                    }
                } catch (Exception e) {  
                    System.out.println(e);
                }
                flag = false;
            }
        }
    }
}

public class time {
    public static void main(String[] args) {
        current_time[] ct = new current_time[30]; // array of objects
        String[] file_location = new String[30]; // store location of files in string array
        String[] file_time = new String[30]; // store the opening time of files in string array

        File folder = new File("/home/rahul/Desktop/code/multithreading/multithreadingdemo/javafilehandling/Documents");
        int cnt = 0;
        Scanner in = new Scanner(System.in);   // scanner object
        for (File file : folder.listFiles())  // iterate through the files in the folder
        {
            if (file.exists() && JOptionPane.showConfirmDialog(null, file.getName(), "Want To Set Alarm:", JOptionPane.YES_NO_OPTION) == 0) // if user wants to set alarm
            {
                file_time[cnt] = JOptionPane.showInputDialog(file.getName());  //input dialog to get time to set alarm
                file_location[cnt] = file.getAbsolutePath();    // store location of file in string array
                cnt++;   // increment counter
            }
        }
        in.close();  // close scanner object

        for (int i = 0; i < cnt; i++) {
            ct[i] = new current_time(file_location[i], file_time[i]);  // create object of current_time class
            // ct[i].setDaemon(true);  // set daemon to true
            ct[i].start();   // start thread
        }
    }
}
