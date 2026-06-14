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
    void load();

    void addTask(Task task);

    void updateTask(int id, Task task);

    void setComplete(int id);

    void viewTasks();

    void viewTasks(int limit);

    void deleteTask(int id);

    void clear();

    void save();
}

public class TaskManager implements TaskManagerInterface {
    // TypeToken<ArrayList<String>>().getArray(ArrayList);

    private ArrayList<Task> tasks;

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    TaskManager() {
        load();
    }

    public void load() {
        Path path = Paths.get("tasks.json");
        checkFile(path);

        try {
            String json = Files.readString(path);
            Type taskListType = new TypeToken<ArrayList<Task>>() {
            }.getType();

            tasks = gson.fromJson(json, taskListType);

            if (tasks == null)
                tasks = new ArrayList<>();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTask(Task task) {
        if (tasks.isEmpty()) {
            task.setId(0);
            tasks.add(task);
            return;
        }
        task.setId(tasks.size());
        tasks.add(task);
        System.out.println("Task added");
    }

    @Override
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No task to view");
            return;
        }
        for (Task task : tasks) {
            String json = gson.toJson(task);
            System.out.println(json);
        }
    }

    @Override
    public void viewTasks(int limit) {
        if (!(limit <= tasks.size())) {
            System.out.println("limit can't be larger than the no. of tasks itself");
            return;
        }
        for (int i = 0; i < limit; i++) {
            Task t = tasks.get(i);
            String json = gson.toJson(t);
            System.out.println(json);
        }
        System.out.println();
    }

    @Override
    public void updateTask(int id, Task task) {
        if (id < 0 || id > tasks.size()) {
            System.out.println("Invalid ID");
            return;
        }
        Task t = tasks.get(id);
        tasks.remove(t);
        task.setId(id);
        tasks.add(id, task);
        System.out.println("Task updated");
        save();
    }

    @Override
    public void deleteTask(int id) {
        if (id < 0 || id > tasks.size()) {
            System.out.println("Invalid ID");
            return;
        }
        tasks.remove(id);
        System.out.println("Task deleted");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            t.setId(i);
        }
        save();
    }

    @Override
    public void save() {
        Path path = Paths.get("tasks.json");
        checkFile(path);

        String json = gson.toJson(tasks);

        try {
            Files.writeString(path, json);
            System.out.println("Saved all tasks");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setComplete(int id) {
        if (id < 0 || id > tasks.size()) {
            System.out.println("Invalid ID");
            return;
        }
        Task t = tasks.get(id);
        if (t.getComplete()) {
            System.out.println("Task is already completed.");
            return;
        }
        t.setComplete();
        System.out.println("Task marked complete");
    }

    @Override
    public void clear() {
        tasks.clear();
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
