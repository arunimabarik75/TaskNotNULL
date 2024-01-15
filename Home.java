import java.util.*;

class Home {
    static Scanner scan = new Scanner(System.in);

    static void newAdmin() {

        // Appears on first time login

        String login, pass;

        System.out.println("<-----  Set the Admin Details  ----->\n");
        System.out.print("Enter Login Id : ");
        login = scan.next();
        System.out.print("Enter Password : ");
        pass = scan.next();
        Save_Login save = new Save_Login("Admin");
        save.saveLogin(login, pass);

        System.out.println("\nAdmin details set");
        System.out.println("--------------------------------------------------\n");
    }

    static boolean checkAdmin(String entered_login, String entered_pass) {

        // Verify Admin credentials - Login Id and Password

        Read_Login read = new Read_Login("Admin");
        int res = read.checkFile(entered_login, entered_pass);

        if (res == 1) {
            System.out.println("<----- Login Successful ----->");
            return true;
        } else if (res == 2) {
            System.out.println("<----- Wrong credentials ----->");
            System.out.println("--------------------------------------------------");
            return false;
        } else {
            System.out.println("<----- File Error ----->");
            System.out.println("--------------------------------------------------");
            return false;
        }
    }

    static boolean checkUser(String entered_login, String entered_pass) {

        // Verify User credentials - Login Id and Password

        Read_Login read = new Read_Login("User");
        int res = read.checkFile(entered_login, entered_pass);

        if (res == 1) {
            System.out.println("<----- Login Successful ----->");
            return true;
        } else if (res == 2) {
            System.out.println("<----- Wrong credentials ----->");
            System.out.println("--------------------------------------------------");
            return false;
        } else {
            System.out.println("<----- File Error ----->");
            System.out.println("--------------------------------------------------");
            return false;
        }
    }

    static void mainMenu() {

        // Displays Main Menu

        System.out.println("Select from the below options -");
        System.out.println("1) Admin Login");
        System.out.println("2) User Login");
        System.out.println("3) Exit");
        System.out.print("--> ");
    }

    public static void main(String[] args) {

        System.out.println(" * * * * * * TaskNotNULL * * * * * * \n");

        Create_File ad = new Create_File("Admin");

        // Create Admin file to store Admin Login Id and Password
        int check = ad.createFile();
        if (check == 1) {
            newAdmin();
        }

        // Create User file to store User Login Id and Password
        Create_File us = new Create_File("User");
        us.createFile();

        loop: while (true) {
            int opt;
            mainMenu();
            opt = scan.nextInt();
            System.out.println("--------------------------------------------------");
            switch (opt) {

            case 1: {

                // Admin Login

                String entered_login, entered_pass;
                System.out.print("Enter Admin Login Id : ");
                entered_login = scan.next();
                System.out.print("Enter Password : ");
                entered_pass = scan.next();
                
                if (checkAdmin(entered_login, entered_pass)) {
                    System.out.println("--------------------------------------------------");
                    Admin admin = new Admin();
                    admin.adminMenu();
                }
                break;
            }

            case 2: {

                // User Login

                String entered_login, entered_pass;
                System.out.print("Enter User Login Id : ");
                entered_login = scan.next();
                System.out.print("Enter Password : ");
                entered_pass = scan.next();

                if (checkUser(entered_login, entered_pass)) {
                    System.out.println("--------------------------------------------------");
                    User user = new User(entered_login);
                    user.userMenu();
                }
                break;
            }

            case 3:

                // Exit from the application

                System.out.println("<----- Thank you for using TaskNotNULL ----->");
                System.out.println("Made by - ");
                System.out.println("20BCE016 Arunima Barik");
                System.out.println("20BCE068 Diya Patel");
                System.out.println("20BCE079 Gaurav Golchha");
                System.out.println("--------------------------------------------------");
                break loop;

            default:

                // Invalid input
                
                System.out.println("<----- Invalid Selection ----->");
                System.out.println("--------------------------------------------------");
                break loop;
            }
        }
    }
}
