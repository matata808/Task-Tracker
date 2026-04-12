import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        while (true) {

            Scanner scan = new Scanner(System.in);
            var input = scan.nextLine();
            // turns input into arrays. Example input "add task" <=> parts[] = {"add" , "task"}
            // splits using the given regex and the limit
            var parts = input.split(" ",2);
            if(parts[0].equals("exit")){
                System.out.println("Exiting....");
                break;
            }

            if (parts[0].contains("add")) {
                TaskList.addToList(parts[1]);



            } else if(parts[0].contains(("list"))) {
                TaskList.showList();


            } else if(input.contains("delete")){
//                TaskList.deleteFromList(Tasks.getId(Integer.parseInt(parts[1])));
            }
            else {
                System.out.println("Invalid operation. Type --help or -h for the list of commands.");
            }




        }


    }
}


