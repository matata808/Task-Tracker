package src;

import java.io.IOException;
import java.util.Scanner;


/**
 * Entry point for the command-line task management application.
 * This class provides an interactive CLI loop that parses user input
 * and delegates task operations to the {@link TaskList} utility class.
 * On startup, persisted tasks are loaded from disk using
 * {@link TaskList#reader()}.
 */
class Main {
    /**
     * Main method that starts the CLI application.
     * This method initializes persisted data and enters an infinite loop
     * waiting for user commands from standard input.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if reading or writing task data fails
     */
    public static void main(String[] args) throws IOException {
        TaskList.reader();
        Scanner scan = new Scanner(System.in);

        while (true) {
            var input = scan.nextLine();
            var command = input.split(" ", 2);

            // turns input into arrays. Example input "add task" <=> command[] = {"add" , "task"}
            // splits using the given regex and the limit

            if (command[0].equals("exit")) {
                System.out.println("Exiting....");
                break;
            } else if (command[0].equals("add")) {
                TaskList.addToList(command[1].trim());


            } else if (command[0].equals("list")) {
                try {
                    if (command.length > 1) {
                        switch (command[1]) {
                            case "todo":
                                TaskList.showTaskWithState("todo");
                                break;
                            case "in-progress":
                                TaskList.showTaskWithState("in-progress");
                                break;
                            case "done":
                                TaskList.showTaskWithState("done");
                                break;
                        }
                    } else {
                        TaskList.showList();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Type 'help' for the list of available commands ");
                }
            } else if (command[0].equals("delete")) {
                try {
                    var toRemove = Integer.parseInt(command[1].trim());
                    TaskList.removeFromList(toRemove);
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Invalid ID. Please enter a number.");
                }

            } else if (command[0].equals("update")) {
                try {
                    command = input.split(" ", 3);
                    int index = Integer.parseInt(command[1].trim());
                    String updatedTask = command[2].trim();
                    TaskList.updateList(index, updatedTask);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID. Please enter a number.");
                }

            } else if (command[0].equals("mark-done")) {
                try {
                    int index = Integer.parseInt(command[1].trim());
                    TaskList.markTask(index, "done");
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Invalid input. Type `help` for the list of available commands. ");
                }

            } else if (command[0].equals("mark-in-progress")) {
                try {
                    int index = Integer.parseInt(command[1].trim());
                    TaskList.markTask(index, "in-progress");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid format. Please follow the instructions in `help` to execute the code right. ");
                }


            } else if (command[0].equals("help")) {
                System.out.println("Available commands:");
                System.out.println("  add <description>           - Add a new task");
                System.out.println("  delete <id>                 - Delete a task by ID");
                System.out.println("  update <id> <description>   - Update a task's description");
                System.out.println("  mark-in-progress <id>       - Mark a task as in-progress");
                System.out.println("  mark-done <id>              - Mark a task as done");
                System.out.println("  list                        - List all tasks");
                System.out.println("  list in-progress            - List all in-progress tasks");
                System.out.println("  list done                   - List all done tasks");
                System.out.println("  help                        - Show this help message");
                System.out.println("  exit                        - Exit the application");
            } else {
                System.out.println("Invalid operation. Type 'help' for the list of commands.");
            }


        }


    }
}


