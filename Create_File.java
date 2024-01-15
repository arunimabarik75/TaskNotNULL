import java.io.File;
import java.io.IOException;

public class Create_File {
    public String name;

    Create_File(String name) {
        this.name = name;
    }

    public int createFile() {

        // Creates a new file
        // Types of file created
        // 1) Admin - stores login credentials of Admin
        // 2) User - stores login credentials of User
        // 3) Task Files - one task file is created per user (Name of file - Login Id of User)
        
        try {
            String file_name = name + ".txt";
            File file = new File(file_name);
            if (file.createNewFile()) {
                return 1;
            } else {
                return 2;
            }
        } catch (IOException exception) {
            System.out.println("<----- Unexpected error ----->");
            exception.printStackTrace();
            return 0;
        }

        // Return values 
        // 0 - Error in file creation
        // 1 - New file created
        // 2 - File already exists
    }
}