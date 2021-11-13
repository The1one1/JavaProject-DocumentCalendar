import document_calendar.*;

class access 
{
    void createthread()
    {
        create_thread t = new create_thread();
        t.run();
    }

    void printdata()
    {
        while(true)
        {
            System.out.print("");
            Edit_alarm e = new Edit_alarm();
            e.printFile();
            e.run();
            System.out.println("\nEdited time");
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
