import java.io.*;
import java.nio.file.Files;

public class Delete_File {

    public String name;

    Delete_File(String name) {
        this.name = name;
    }

    public int deleteFile() {

        // Delete a file

        String file_name = name + ".txt";
        File file = new File(file_name);
        if (file.delete()) {
            return 1;
        } else {
            return 2;
        }

        // Return values - 
        // 1 - File deleted
        // 2 - Error 

    }

    public void removeLine(String lineContent) {

        // Create a temporary file
        // Copy all data from exisiting file to new file except a specified line
        // Delete the existing file and rename the temporary file

        String file_name = name + ".txt";
        File file = new File(file_name);
        File temp = new File("temp.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(temp));
            Files.lines(file.toPath()).filter(line -> !line.contains(lineContent)).forEach(out::println);
            out.flush();
            out.close();
            deleteFile();
            temp.renameTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String login, String password) {

        // Delete credentials of a specific user from User file
        
        Read_Login read = new Read_Login("User");
        int res = read.checkFile(login, password);

        if (res == 1) {
            Delete_File delUser = new Delete_File("User");
            delUser.removeLine(login + "#" + password);
            System.out.println("<----- User deleted successfully ----->");
        } else {
            System.out.println("<----- Wrong credentials ----->");
        }
    }
}