package document_calendar;

import java.util.Scanner;

public class Edit_alarm extends Thread{

    @Override
    public void run() {

        System.out.print("Setting[y\\n]:");
        Scanner in = new Scanner(System.in);
        if (in.next().charAt(0) == 'y') {
            for (String it : create_thread.file_name) {
                System.out.print(it + " ");
            }
        }
        in.close();
    }
}
