package document_calendar;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class create_thread extends Thread {

    public String[] file_location = new String[30]; // store location of files in string array
    public String[] file_time = new String[30]; // store the opening time of files in string array
    public static String[] file_name = new String[30];
    current_time[] ct = new current_time[30]; // array of objects
    File folder = new File("/home/rahul/Desktop/code/multithreading/multithreadingdemo/javafilehandling/Documents");

    @Override
    public void run() {
        int cnt = 0;
        Scanner in = new Scanner(System.in);

        for (File file : folder.listFiles()) {
            if (file.exists() && (JOptionPane.showConfirmDialog(null, file.getName(), "Want To Set Alarm:", JOptionPane.YES_NO_OPTION) == 0)) {
                file_time[cnt] = JOptionPane.showInputDialog(file.getName());
                file_location[cnt] = file.getAbsolutePath();
                file_name[cnt] = file.getName();
                cnt++;
            }
        }
        in.close();

        for (int i = 0; i < cnt; i++) {
            ct[i] = new current_time(file_location[i], file_time[i]);
            // ct[i].setDaemon(true);
            ct[i].start();
        }
    }
}
