package src;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Tasks> list = new ArrayList<>();
    private static File output = new File("output.json");



    public static ArrayList<Tasks> getList() {
        return list;
    }


    public static void addToList(String task) throws IOException {
        Tasks myTask = new Tasks();
        myTask.setDescription(task);
        myTask.setId(list.size());
        myTask.setCreatedAt(LocalDateTime.now());
        list.add(myTask);
        System.out.println("Task added successfully (ID: " + myTask.getId() + " )");
        myTask.setState("todo");
        writer();
    }



    public static void showList() throws IOException {
        for (Tasks task : getList()) {
            System.out.println(task);
        }
        writer();
    }

    public static void showTaskWithState(String input) throws IOException {
        for (Tasks task : getList()){
            if(task.getState().equals(input.trim())){
                System.out.println(task);
            }
        }
        writer();
    }


    public static void removeFromList(int index) throws IOException {
       for(int i= list.size() -1; i >= 0; i-- ){
           if(list.get(i).getId() == index){
               list.remove(i);
               break;
           }
       }
        writer();
    }

    public static void updateList(int index, String updatedTask) throws IOException {
        for(int i= 0; i < list.size(); i++){
            if(list.get(i).getId() == index){
                list.get(i).setDescription(updatedTask);
                list.get(i).setUpdatedAt(LocalDateTime.now());
                break;

            }

        }
        writer();
    }

    public static void markTask(int index, String markedTask) throws IOException{
        for(int i=0; i < list.size(); i++){
            if(list.get(i).getId() == index){
                list.get(i).setState(markedTask);
                break;
            }
        }
        writer();
    }

    public static File getOutput() {
        return output;
    }

    public static void writer() throws FileNotFoundException, IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(output);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        for (Tasks i : getList()) {
            printWriter.println(i);
        }

        printWriter.close();
        fileOutputStream.close();

    }


}


