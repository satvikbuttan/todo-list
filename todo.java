import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    private static ArrayList<String> tasks = new ArrayList<>();

    // Function to display the menu
    public static void displayMenu() {
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. View tasks");
        System.out.println("2. Add a task");
        System.out.println("3. Remove a task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Function to view tasks
    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Your tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Function to add a task
    public static void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    // Function to remove a task
    public static void removeTask(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
        } else {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed successfully.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewTasks();
                    break;
                case 2:
                    System.out.print("Enter the task to add: ");
                    String task = scanner.nextLine();
                    addTask(task);
                    break;
                case 3:
                    System.out.print("Enter the task number to remove: ");
                    int taskNumber = scanner.nextInt();
                    removeTask(taskNumber);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting To-Do List. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
