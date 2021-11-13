import document_calendar.*;

class access extends Thread
{
    void createthread()
    {
        create_thread t = new create_thread();
        t.start();
    }

    void printdata()
    {
        while (create_thread.count < 6)// checking thread count.
        {
            System.out.print("");
            if (create_thread.count == 5)
            {
                Edit_alarm e = new Edit_alarm();
                e.printFile();
                e.run();
                System.out.println("\nEdited Time");
            }
        }
    }
}

public class time
{
    public static void main(String[] args)
    {
        access t = new access();
        t.createthread();
        t.printdata();
    }
}
