
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Tasks> list = new ArrayList<>();


    public static ArrayList<Tasks> getList() {
        return list;
    }


    public static void addToList(String task) {
        Tasks myTask = new Tasks();
        myTask.setDescription(task);
        myTask.setId(list.size());
        myTask.setCreatedAt(LocalDateTime.now());
        list.add(myTask);
    }

    public static void deleteFromList(int index) {
        Tasks deleteFromTask = new Tasks();
        //list.remove(deleteFromTask.getId(index));
    }

    public static void showList() {
        System.out.println(getList().toString() +"\n");
    }
}


