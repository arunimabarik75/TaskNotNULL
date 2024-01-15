import java.util.*;

class User {

    Scanner scan = new Scanner(System.in);

    private String login;

    User(String login) {
        this.login = login;
    }

    public void addTask() {

        // Add task in a new line in User task file

        String task;
        System.out.println("Enter task to be added : ");
        System.out.print("--> ");
        task = scan.next();
        Save_Task newTask = new Save_Task(login);
        newTask.saveTask(task);
        System.out.println("<----- New Task added ----->");
    }

    public void deleteTask() {

        // Displays all tasks added
        // Deletes task corresponding to specified task number

        int n = displayTask();
        if (n > 0) {
            int num;
            System.out.println("Enter the task number to be deleted: ");
            System.out.print("--> ");
            num = scan.nextInt();
            if (num > n || num <= 0) {
                System.out.println("<----- Invalid task number ----->");
            } else {
                Delete_Task dtask = new Delete_Task(login, num);
                dtask.deleteTask();
            }
        }
    }

    public int displayTask() {

        // Displays all tasks added
        
        System.out.println("Tasks added - ");
        Read_Task rtask = new Read_Task(login);
        int n = rtask.readTask();
        return n;
    }

    public void resetPass() {

        // Reset User Password

        Reset_Password rset = new Reset_Password("User");
        System.out.print("Enter the Login Id : ");
        String login = scan.next();
        System.out.print("Enter Password : ");
        String pass = scan.next();
        System.out.print("Enter New Password : ");
        String newpass = scan.next();
        rset.resetPassword(login, pass, newpass);
    }

    public void userMenu() {

        // User Menu
        
        loop: while (true) {
            int opt;
            System.out.println("Select from the below options -");
            System.out.println("1) Add Task");
            System.out.println("2) Delete Task");
            System.out.println("3) Display Task");
            System.out.println("4) Reset Password");
            System.out.println("5) Logout");
            System.out.print("--> ");
            opt = scan.nextInt();
            System.out.println("--------------------------------------------------");
            switch (opt) {
            case 1:
                addTask();
                System.out.println("--------------------------------------------------");
                break;
            case 2:
                deleteTask();
                System.out.println("--------------------------------------------------");
                break;
            case 3:
                displayTask();
                System.out.println("--------------------------------------------------");
                break;
            case 4:
                resetPass();
                System.out.println("--------------------------------------------------");
                break;
            case 5:
                System.out.println("<----- Logout successful ----->");
                System.out.println("--------------------------------------------------");
                break loop;
            default:
                System.out.println("<----- Invalid selection ----->");
                System.out.println("--------------------------------------------------");
                break loop;
            }
        }
    }
}
