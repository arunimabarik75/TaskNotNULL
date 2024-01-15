import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Delete_Task {
    public String name;
    public int lineNo;
    public String requiredLine;

    Delete_Task(String name, int lineNo) {
        this.name = name;
        this.lineNo = lineNo;
    }

    public void removeLine(String lineContent) {

        // Create a temporary file
        // Copy all data from exisiting file to new file except a specified line
        // Delete the existing file and rename the temporary file

        File file = new File(name + ".txt");
        File temp = new File("temp.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(temp));
            Files.lines(file.toPath()).filter(line -> !line.contains(lineContent)).forEach(out::println);
            out.flush();
            out.close();
            Delete_File df = new Delete_File(name);
            df.deleteFile();
            temp.renameTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask() {

        // Deletes a task from User's tasklist
        
        try {
            String file_name = name + ".txt";
            File file = new File(file_name);
            Scanner scan = new Scanner(file);
            int n = 1;
            while (scan.hasNextLine()) {
                String task = scan.nextLine();
                if (n == lineNo) {
                    requiredLine = task;
                    break;
                }
                n++;
            }
            scan.close();
            System.out.println("<----- Task deleted successfully ----->");
        } catch (FileNotFoundException exception) {
            System.out.println("<----- No such User found ----->");
            exception.printStackTrace();
        }
        removeLine(requiredLine);
    }
}
