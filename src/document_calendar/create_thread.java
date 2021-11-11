package document_calendar;

import java.io.File;
import javax.swing.JOptionPane;

public class create_thread extends Thread
{

    protected static String[] file_location = new String[30]; // store location of files in string array
    protected static String[] file_time = new String[30]; // store the opening time of files in string array
    protected static String[] file_name = new String[30];
    static current_time[] ct = new current_time[30]; // array of objects
    static int cnt = 0; // count the number of files
    public static int count = 0;

    File folder = new File("/home/sudeep-23-11/Desktop/JavaProject-DocumentCalendar-master/Documents");

    @Override
    public void run()
    {

        for (File file : folder.listFiles())
        {
            if (file.exists() && (JOptionPane.showConfirmDialog(null, file.getName(), "Want To Set Alarm:",
                    JOptionPane.YES_NO_OPTION) == 0)) {
                file_time[cnt] = JOptionPane.showInputDialog(file.getName());
                file_location[cnt] = file.getAbsolutePath();
                file_name[cnt] = file.getName();
                cnt++;
            }
        }

        for (int i = 0; i < cnt; i++)
        {
            ct[i] = new current_time(file_location[i], file_time[i]);
            // ct[i].setDaemon(true);
            ct[i].start();
        }
        count = 5;
    }
}
