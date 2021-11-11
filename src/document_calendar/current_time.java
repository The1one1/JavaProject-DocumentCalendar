package document_calendar;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class current_time extends Thread
{

    String timeToCompare;
    String fileName;

    public current_time(String fileName, String timeToCompare)
    {
        this.fileName = fileName;
        this.timeToCompare = timeToCompare;
    }

    @Override
    public void run()
    {
        boolean flag = true;
        while (flag)
        {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
            String currentTime = sdf.format(cal.getTime());

            if (currentTime.equals(timeToCompare))
            {
                try
                {
                    File file = new File(fileName);
                    if (!Desktop.isDesktopSupported())// check if Desktop is supported by Platform or not
                    {
                        System.out.println("not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if (file.exists()) // checks file exists or not
                    desktop.open(file); // opens the specified file
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                flag = false;
            }
        }
    }
}
