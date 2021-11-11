
import document_calendar.*;
import document_calendar.Edit_alarm;

class access extends Thread {
    void createthread() {
        create_thread t = new create_thread();
        t.start();
    }

    void printdata() {
        while (create_thread.count < 6) {
            System.out.print("");
            if (create_thread.count == 5) {
                Edit_alarm e = new Edit_alarm();
                e.printFile();
                e.run();
                System.out.println("\nEdited time");
            }
        }
    }
}

public class time {
    public static void main(String[] args) {
        access t = new access();
        t.createthread();
        t.printdata();
    }
}
