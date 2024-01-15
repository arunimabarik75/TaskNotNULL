import java.util.*;

class Admin {

    Scanner scan = new Scanner(System.in);

    public void addUser() {

        // Adds a new user in User file
        // Saves login credentials in User file
        // Creates a new task file for the User

        String login, pass;
        System.out.print("Enter User Login Id : ");
        login = scan.next();
        System.out.print("Enter Password : ");
        pass = scan.next();
        Save_Login save = new Save_Login("User");
        save.saveLogin(login, pass);
        Create_File newUser = new Create_File(login);
        newUser.createFile();
        System.out.println("<----- New User added ----->");
    }

    public void deleteUser() {

        // Deletes an existing user
        // Deletes login credentials from User file
        // Deletes task file of the User

        System.out.print("Enter User Login Id : ");
        String login = scan.next();
        System.out.print("Enter Password : ");
        String password = scan.next();
        Delete_File del = new Delete_File("User");
        del.deleteUser(login, password);
        Delete_File delUser = new Delete_File(login);
        delUser.deleteFile();
    }

    public void displayUser() {

        // Displays list of users

        Read_Login displayUser = new Read_Login("User");
        displayUser.readUsers();
    }

    public void visitUserTask() {

        // See tasks added by a user

        System.out.print("Enter User Login Id: ");
        String login = scan.next();
        Read_Task readUser = new Read_Task(login);
        readUser.readTask();
    }

    public void resetPass() {

        // Reset Admin password

        Reset_Password rset = new Reset_Password("Admin");
        System.out.print("Enter Admin Login Id : ");
        String login = scan.next();
        System.out.print("Enter Password : ");
        String pass = scan.next();
        System.out.print("Enter New Password : ");
        String newpass = scan.next();
        rset.resetPassword(login, pass, newpass);
    }

    public void adminMenu() {

        // Admin Menu - Options available for Admin
        
        loop: while (true) {
            int opt;
            System.out.println("Select from the below options -");
            System.out.println("1) Add User");
            System.out.println("2) Delete User");
            System.out.println("3) Display Users");
            System.out.println("4) Visit User Tasks");
            System.out.println("5) Reset Password");
            System.out.println("6) Logout");
            System.out.print("--> ");
            opt = scan.nextInt();
            System.out.println("--------------------------------------------------");
            switch (opt) {
            case 1:
                addUser();
                System.out.println("--------------------------------------------------");
                break;
            case 2:
                deleteUser();
                System.out.println("--------------------------------------------------");
                break;
            case 3:
                displayUser();
                System.out.println("--------------------------------------------------");
                break;
            case 4:
                visitUserTask();
                System.out.println("--------------------------------------------------");
                break;
            case 5:
                resetPass();
                System.out.println("--------------------------------------------------");
                break;
            case 6:
            System.out.println("<----- Logout successful ----->");
                System.out.println("--------------------------------------------------");
                break loop;
            default:
                System.out.println("<----- Invalid selection ----->");
                System.out.println("--------------------------------------------------");
                break;
            }
        }
    }
}
