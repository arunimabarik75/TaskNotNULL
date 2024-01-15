import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read_Task {
    public String name;
    public String id;

    Read_Task(String name) {
        this.name = name;
    }

    public int readTask() {

        // Read Tasks entered by user in his/her tasklist
        
        try {
            String file_name = name + ".txt";
            File file = new File(file_name);
            Scanner scan = new Scanner(file);
            int n = 1;
            if (!scan.hasNextLine()) {
                System.out.println("<----- No Tasks added ----->");
                scan.close();
                return -1;
            }
            while (scan.hasNextLine()) {
                String task = scan.nextLine();
                System.out.println(n + ") " + task);
                n++;
            }
            scan.close();
            return n - 1;
        } catch (FileNotFoundException exception) {
            System.out.println("<----- No such User found ----->");
        }
        return 0;
    }
}
