# TaskNotNULL

TaskNotNULL is a task management application developed using object-oriented programming in Java and file handling. It allows users to create tasks, manage tasks and reset passwords. The application has separate login credentials for admins and users, which are stored in text files. Each user has their own task file to store their tasks. Admins can only see the pending tasks of users but can't modify it. Admin has the rights of User creation & Deletion. 

## Features

- Admin and user login credentials are saved in separate text files.
- New users can be added by the admin and their login credentials are saved in the user file.
- Separate task files are created for each user to store their tasks.
- Admin has the option to delete users and reset passwords.
- Users can add tasks, delete tasks and view their tasks.

## Code Structure

The code consists of the following classes:

1. `Admin.java`: Contains methods for adding users, deleting users, displaying users, visiting user tasks, resetting passwords and the admin menu.
2. `Create_File.java`: Creates a new file for storing login credentials or tasks.
3. `Delete_File.java`: Deletes a file or removes a specific line from a file.
4. `Home.java`: Contains the main method and the main menu for the application. Handles admin and user login.
5. `Read_Login.java`: Reads login credentials from a file and verifies them.
6. `Read_Task.java`: Reads tasks from a user's task file and displays them.
7. `Reset_Password.java`: Resets the admin or user password by removing the old credentials and saving the new password.
8. `Save_Login.java`: Saves login credentials in a file.
9. `Save_Task.java`: Saves tasks in a user's task file.
10. `User.java`: Contains methods for adding tasks, deleting tasks, displaying tasks, resetting passwords and the user menu.

## Usage

To use the TaskNotNULL application, follow these steps:

1. Compile the `Home.java` file to generate the class files.
2. Run the generated class files to start the application.
3. The application will display a main menu with options for admin login, user login and exit.
4. Select the appropriate option and follow the prompts to perform the desired actions.
