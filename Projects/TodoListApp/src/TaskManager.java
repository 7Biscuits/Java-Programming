import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

interface TaskManagerInterface {
    void addTask(Task task);

    void updateTask(int id, Task task);

    void setComplete(int id);

    void viewTasks();

    void viewTasks(int limit);

    void deleteTasks();

    void save();
}

public class TaskManager implements TaskManagerInterface {
    // TypeToken<ArrayList<String>>().getArray(ArrayList);

    ArrayList<Task> tasks;

    private ArrayList<Task> initializeArrayList() {
        Path path = Paths.get("tasks.json");
        checkFile(path);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            String json = Files.readString(path);
            Type taskListType = new TypeToken<ArrayList<Task>>() {
            }.getType();

            tasks = gson.fromJson(json, taskListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    TaskManager() {
        initializeArrayList();
    }

    @Override
    public void addTask(Task task) {
        task.setId(tasks.size());
        tasks.add(task);
    }

    @Override
    public void viewTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    @Override
    public void viewTasks(int limit) {
        for (int i = 0; i < limit; i++) {
            System.out.println(tasks.get(i));
        }
        System.out.println();
    }

    @Override
    public void updateTask(int id, Task task) {
        Task t = tasks.get(id - 1);
        tasks.remove(t);
        task.setId(t.getId());
        tasks.add(id - 1, task);
    }

    @Override
    public void deleteTasks() {
        tasks.clear();
    }

    @Override
    public void save() {
        Path path = Paths.get("tasks.json");
        checkFile(path);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(tasks);

        try {
            Files.writeString(path, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setComplete(int id) {
        Task t = tasks.get(id);
        if (t.getComplete()) {
            System.out.println("Task is already completed.");
            return;
        }
        t.setComplete();
    }

    private void checkFile(Path path) {
        // Create file if missing
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                Files.writeString(path, "[]");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
