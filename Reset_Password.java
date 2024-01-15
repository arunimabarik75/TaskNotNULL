import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class Reset_Password {
    public String name;

    Reset_Password(String name) {
        this.name = name;
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

    public void resetPassword(String login, String pass, String newpass) {

        // Reset Password
        // Remove older credential saved
        // Save New Password along with Login Id
        
        Read_Login read = new Read_Login(name);
        int res = read.checkFile(login, pass);

        if (res == 1) {
            String toDelete = login + "#" + pass;
            removeLine(toDelete);
            if (name.equals("User")) {
                Save_Login newCred = new Save_Login("User");
                newCred.saveLogin(login, newpass);
            } else {
                Save_Login copyCred = new Save_Login("Admin");
                copyCred.saveLogin(login, newpass);
            }
            System.out.println("<----- Password reset successfully ----->");
        } else if (res == 2) {
            System.out.println("<----- Wrong credentials ----->");
        } else {
            System.out.println("<----- File Error ----->");
        }
    }

}
