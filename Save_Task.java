import java.io.*;

public class Save_Task {
    public String name;

    Save_Task(String name) {
        this.name = name;
    }

    public void saveTask(String task) {

        // Save task entered by user in a new line in User's task file
        
        try {
            String file_name = name + ".txt";
            RandomAccessFile file = new RandomAccessFile(file_name, "rw");
            file.seek(file.length());
            file.writeBytes(task + "\n");
            file.close();
        } catch (IOException e) {
            System.out.println("<----- Details not saved ----->");
            e.printStackTrace();
        }
    }
}