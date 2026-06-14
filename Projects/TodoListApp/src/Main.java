import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void printCommands() {
        String text = """
                Enter
                1 -> Add todo
                2 -> View todos
                3 -> Update todo
                4 -> Delete todo
                0 -> Exit
                """;
        System.out.println(text);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Todo App");

        TaskManager taskManager = new TaskManager();

        Scanner sc = new Scanner(System.in);

        printCommands();

        while (true) {

            switch (sc.nextInt()) {
                case 1:
                    taskManager.addTask(
                            new Task(sc.nextLine(), sc.nextLine(), false));
                    System.out.println("Task added");
                    break;

                case 2:
                    System.out.println("Enter limit of todos, leave blank for fetching all.");
                    try {
                        int limit = sc.nextInt();
                        taskManager.viewTasks(limit);
                    } catch (Exception e) {
                        taskManager.viewTasks();
                    }
                    break;

                case 3:
                    System.out.println("Enter the id of the todo");
                    int id = sc.nextInt();
                    taskManager.updateTask(id, new Task(null, null, false));

                default:
                    break;
            }
        }
    }
}
