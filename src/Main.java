package src;

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        TaskList.reader();

        while (true) {
            Scanner scan = new Scanner(System.in);
            var input = scan.nextLine();
            // turns input into arrays. Example input "add task" <=> parts[] = {"add" , "task"}
            // splits using the given regex and the limit
            var parts = input.split(" ", 2);
            if (parts[0].equals("exit")) {
                System.out.println("Exiting....");
                break;
            } else if (parts[0].equals("add")) {
                TaskList.addToList(parts[1].trim());


            } else if (parts[0].equals("list")) {
                if (parts.length > 1) {
                    switch (parts[1]) {
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
            } else if (parts[0].equals("delete")) {
                var toRemove = Integer.parseInt(parts[1].trim());
                TaskList.removeFromList(toRemove);

            } else if (parts[0].equals("update")) {
                parts = input.split(" ", 3);
                int index = Integer.parseInt(parts[1].trim());
                String updatedTask = parts[2].trim();
                TaskList.updateList(index, updatedTask);

            } else if (parts[0].equals("mark-done")) {
                int index = Integer.parseInt(parts[1].trim());
                TaskList.markTask(index, "done");

            } else if (parts[0].equals("mark-in-progress")) {
                int index = Integer.parseInt(parts[1].trim());
                TaskList.markTask(index,"in-progress");

            } else {
                System.out.println("Invalid operation. Type --help or -h for the list of commands.");
            }


        }


    }
}


