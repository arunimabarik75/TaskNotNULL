import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Read_Login {
    public String name;

    Read_Login(String name) {
        this.name = name;
    }

    public int checkFile(String entered_login, String entered_pass) {

        // Verify credentials - Login Id and Password

        try {
            String file_name = name + ".txt";
            File file = new File(file_name);
            Scanner scan = new Scanner(file);

            int flag = 0;
            while (scan.hasNextLine()) {
                String fileData = scan.nextLine();
                String[] saved_details = fileData.split("#");
                if (saved_details[0].equals(entered_login) && saved_details[1].equals(entered_pass)) {
                    flag = 1;
                    break;
                }
            }
            scan.close();

            if (flag == 0)
                return 2;
            else
                return 1;
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            return 0;
        }

        // Return values -
        // 0 - Error
        // 1 - Correct credentials
        // 2 - Wrong credentials

    }

    public void readUsers() {

        // Displays Users present in the User file
        
        try {
            File file = new File("User.txt");
            Scanner scan = new Scanner(file);
            int n = 1;
            if (!scan.hasNextLine()) {
                System.out.println("<----- No Users Added ----->");
                scan.close();
                return;
            }
            System.out.println("Displaying Users - ");
            while (scan.hasNextLine()) {
                String userData = scan.nextLine();
                int idx = userData.indexOf("#");
                userData = userData.substring(0, idx);
                System.out.println(n + ") " + userData);
                n++;
            }
            scan.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}