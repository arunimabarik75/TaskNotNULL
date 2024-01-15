import java.io.IOException;
import java.io.RandomAccessFile;

public class Save_Login {
    public String name;

    Save_Login(String name) {
        this.name = name;
    }

    public void saveLogin(String login, String pass) {

        // Write Login credentials in file
        // Format - login_id#password
        
        try {
            String file_name = name + ".txt";
            RandomAccessFile file = new RandomAccessFile(file_name, "rw");
            file.seek(file.length());
            file.writeBytes(login + "#" + pass + "\n");
            file.close();
        } catch (IOException e) {
            System.out.println("<----- Details not saved ----->");
            e.printStackTrace();
        }
    }
}