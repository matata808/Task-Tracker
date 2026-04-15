package src;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Utility class responsible for managing a collection of {@code Tasks}.
 *
 * <p>This class provides static methods to:
 * <ul>
 *   <li>Add, update, and delete tasks</li>
 *   <li>Filter and display tasks</li>
 *   <li>Persist tasks to a JSON file</li>
 *   <li>Load tasks from disk</li>
 * </ul>
 *
 * <p>All task data is stored in-memory and synchronized with a JSON file
 * ("output.json") after every modification.
 */
public class TaskList {

    /**
     * Internal list storing all tasks in memory.
     */
    private static final ArrayList<Tasks> list = new ArrayList<>();

    /**
     * Output file used for persistence.
     */
    private static final File output = new File("output.json");

    /**
     * Returns the current list of tasks.
     *
     * @return the in-memory task list
     */
    public static ArrayList<Tasks> getList() {
        return list;
    }

    /**
     * Adds a new task to the list.
     *
     * <p>The task is assigned:
     * <ul>
     *   <li>A unique ID based on list size</li>
     *   <li>Current timestamp as creation time</li>
     *   <li>Initial state "todo"</li>
     * </ul>
     *
     * @param task the task description
     * @throws IOException if writing to file fails
     */
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

    /**
     * Displays all tasks in the list.
     *
     * @throws IOException if writing to file fails
     */
    public static void showList() throws IOException {
        for (Tasks task : getList()) {
            System.out.println(task);
        }
        writer();
    }

    /**
     * Displays tasks filtered by a specific state.
     *
     * @param input the task state (e.g., "todo", "in-progress", "done")
     * @throws IOException if writing to file fails
     */
    public static void showTaskWithState(String input) throws IOException {
        for (Tasks task : getList()){
            if(task.getState().equals(input.trim())){
                System.out.println(task);
            }
        }
        writer();
    }

    /**
     * Removes a task by its ID.
     *
     * @param index the ID of the task to remove
     * @throws IOException if writing to file fails
     */
    public static void removeFromList(int index) throws IOException {
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i).getId() == index){
                list.remove(i);
                break;
            }
        }
        writer();
    }

    /**
     * Updates the description of a task.
     *
     * <p>Also updates the modification timestamp.
     *
     * @param index the task ID
     * @param updatedTask the new description
     * @throws IOException if writing to file fails
     */
    public static void updateList(int index, String updatedTask) throws IOException {
        for (Tasks tasks : list) {
            if (tasks.getId() == index) {
                tasks.setDescription(updatedTask);
                tasks.setUpdatedAt(LocalDateTime.now());
                break;
            }
        }
        writer();
    }

    /**
     * Updates the state of a task.
     *
     * @param index the task ID
     * @param markedTask the new state (e.g., "done", "in-progress")
     * @throws IOException if writing to file fails
     */
    public static void markTask(int index, String markedTask) throws IOException{
        for (Tasks tasks : list) {
            if (tasks.getId() == index) {
                tasks.setState(markedTask);
                break;
            }
        }
        writer();
    }


    /**
     * Writes the current task list to a JSON file.
     *
     * <p>Each task is serialized into a JSON object containing:
     * id, description, state, creation time, and optionally update time.
     *
     * @throws IOException if file writing fails
     */
    public static void writer() throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (Tasks task : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",task.getId());
            jsonObject.put("description", task.getDescription());
            jsonObject.put("state",task.getState());
            jsonObject.put("createdAt",task.getCreatedAt().toString());

            if (task.getUpdatedAt() != null){
                jsonObject.put("UpdatedAt",task.getUpdatedAt().toString());
            }
            jsonArray.put(jsonObject);
        }
        FileWriter writer = new FileWriter(output);
        writer.write(jsonArray.toString(2));
        writer.close();
    }

    /**
     * Loads tasks from the JSON file into memory.
     *
     * <p>If the file does not exist, no action is performed.
     *
     * @throws IOException if reading from file fails
     */
    public static void reader() throws IOException{
        if(!output.exists()) return;

        BufferedReader reader = new BufferedReader(new FileReader(output));
        StringBuilder builder = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null){
            builder.append(line);
        }
        reader.close();

        JSONArray jsonArray = new JSONArray(builder.toString());
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Tasks task = new Tasks();
            task.setId(object.getInt("id"));
            task.setDescription(object.getString("description"));
            task.setState(object.getString("state"));
            task.setCreatedAt(LocalDateTime.parse(object.getString("createdAt")));
            list.add(task);
        }
    }
}