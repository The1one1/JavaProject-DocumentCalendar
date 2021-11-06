import document_calendar.*;
import document_calendar.Edit_alarm;

public class time {

    public static void main(String[] args) {
        create_thread t = new create_thread();
        t.start();
        new Edit_alarm().run();
    }
}