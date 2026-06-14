import java.util.Scanner;

public class Main {

    private static void printCommands() {
        String text = """
                =========================
                Enter
                1 -> Add todo
                2 -> View todos
                3 -> Update todo
                4 -> Delete todo
                5 -> Mark complete
                6 -> Save tasks
                0 -> Exit
                =========================
                """;

        System.out.println(text);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Todo App");

        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {

            printCommands();

            System.out.print("Enter command: ");
            int command;

            try {
                command = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
                continue;
            }

            switch (command) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    taskManager.addTask(
                            new Task(title, description, false));
                    break;

                case 2:
                    System.out.print("Enter limit of todos (leave blank for all): ");

                    String limitInput = sc.nextLine();
                    if (limitInput.isBlank())
                        taskManager.viewTasks();
                    else {
                        try {
                            int limit = Integer.parseInt(limitInput);
                            taskManager.viewTasks(limit);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid limit");
                        }
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter task ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new title: ");
                        String newTitle = sc.nextLine();

                        System.out.print("Enter new description: ");
                        String newDescription = sc.nextLine();

                        System.out.print("Completed? (true/false): ");

                        boolean completed = Boolean.parseBoolean(sc.nextLine());

                        taskManager.updateTask(
                                id,
                                new Task(
                                        newTitle,
                                        newDescription,
                                        completed));
                    } catch (Exception e) {
                        System.out.println("Failed to update task");
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter task ID: ");

                        int id = Integer.parseInt(sc.nextLine());
                        taskManager.deleteTask(id);
                    } catch (Exception e) {
                        System.out.println("Invalid ID");
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Enter task ID: ");

                        int id = Integer.parseInt(sc.nextLine());
                        taskManager.setComplete(id);
                    } catch (Exception e) {
                        System.out.println("Invalid ID");
                    }
                    break;
                
                case 6:
                    try {
                        taskManager.save();
                    } catch(Exception e) {
                        System.out.println("An error occured while saving");
                    }

                case 0:
                    System.out.println("Exiting app...");
                    taskManager.save();
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}