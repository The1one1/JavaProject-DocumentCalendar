package document_calendar;

import static document_calendar.create_thread.ct;
import static document_calendar.create_thread.file_name;
import static document_calendar.create_thread.file_time;

import java.util.Formatter;
import java.util.Scanner;

public class Edit_alarm extends Thread
{

    Formatter f = new Formatter();

    public void printFile()
    {

        System.out.format("%35s %20s%n", "File Name", " |  Alarm");
        for (int t = 0; t < create_thread.cnt; t++){
    	    System.out.format("%35s %20s%n", file_name[t], "|  " + file_time[t]);
        }
    }

    @Override
    public void run()
    {
        System.out.print("Setting[y\\n]:");
        Scanner in = new Scanner(System.in);
        char c = in.next().charAt(0);
        if (c == 'y')
        {
            // want to change value of file_time
            System.out.print("Enter file no whose time want to edit:");
            int file_name = in.nextInt();
            System.out.print("Time:");
            String time = in.next();
            file_time[file_name - 1] = time;

            if(!ct[file_name-1].isAlive()) {    
                ct[file_name - 1] = new current_time(create_thread.file_location[file_name - 1], file_time[file_name - 1]);
                ct[file_name - 1].start();
            }
            else{
                ct[file_name - 1].timeToCompare = time;
            }
        }
    }
}
