import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Reise Thomas Kato
 * @created 09.05.2024
 * @project uebung4
 */
public class Console {
    private String[] commands;
    private ArrayList<UserStory> userStories;
    private ArrayList<Task> tasks;
    String fileName = "user_stories.txt";

    public Console(){
        commands = new String[]{"story", "task", "assign", "stories", "tasks", "load", "save"};
        userStories = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    /**
     * Run the system in the command line.
     */
    public void run() {
        try {
            help();
            while(true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();
                if(line.equals("stop")) {
                    break;
                }
                else if(line.equals("help")) {
                    help();
                }
                else {
                    String[] arrLine = line.split(" ");
                    while (!Arrays.asList(commands).contains(arrLine[0])) {
                        System.out.println("Unknown command. Type \"help\" to get an overview of allowed commands.");
                        line = br.readLine();
                        arrLine = line.split(" ");
                    }

                    processCommand(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * type help to get description of usage.
     */
    private void help() {
        System.out.println("\nstory: Eingabe einer User Story ohne die Eingabe der zugeordneten Tasks.\n" +
                "task: Eingabe eines Tasks ohne Zuordnung des Tasks zu einer User Story.\n" +
                "assign: Zuordnung einer (weiteren) Task-ID zu einer User-Story-ID.\n" +
                "stories: Ausgabe aller gespeicherten User Stories, wobei zu jeder User Story alle zugeordneten Tasks" +
                " ausgegeben werden.\n" +
                "tasks: Ausgabe aller gespeicherten Tasks, die zugeodnete User Story (sofern vorhanden) braucht" +
                " dabei nicht mit ausgegeben zu weren.\n" +
                "load: Laden der gespeicherten User Stories aus einer Datei.\n" +
                "save: Speichern der eingegeben User Stories in einer Datei.\n" +
                "stop: Beenden des Systems. KEINE automatische Speicherung.\n");
    }

    /**
     * extract description of User Story or Task
     *
     * @param line  command line
     * @return String -> description
     */
    private String extractText(String line) {
        int start = line.indexOf("\"");
        int end = line.lastIndexOf("\"");
        if(start != -1 && end != -1 && start < end) {
            return line.substring(start + 1, end);
        }
        else {
            return "";
        }
    }

    /**
     * Process the command line given by user.
     *
     * @param line  command line
     * @throws IOException
     */
    private void processCommand(String line) throws IOException{
        String[] arrLine = line.split(" ");
        String command = arrLine[0];

        switch (command) {
            case "story" -> {
                addStory(line);
            }
            case "task" -> {
                addTask(line);
            }
            case "assign" -> {
                assignTaskToStory(line);
            }
            case "stories" -> {
                printStories();
            }
            case "tasks" -> {
                printTasks();
            }
            case "load" -> {
                loadData();
            }
            case "save" -> {
                saveData();
            }
        }
    }

    /**
     * Add a User Story to the system. All Parameters are given by the User via command line.
     *
     * @param line  User command prompt.
     */
    private void addStory(String line) {
        String[] arrLine = line.split(" ");
        String description = extractText(line);
        UserStory userStory = new UserStory(description, Integer.parseInt(arrLine[1]),
                arrLine[arrLine.length - 1]);
        userStories.add(userStory);
    }

    /**
     * Add a Task to the system. All Parameters are given by the User via command line.
     *
     * @param line User command prompt.
     */
    private void addTask(String line) {
        String[] arrLine = line.split(" ");
        Task task = new Task(extractText(line), Integer.parseInt(arrLine[1]));
        tasks.add(task);
    }

    /**
     * Assign a Task to a specific User Story. All Parameters are given by the User via command line.
     *
     * @param line  User command prompt.
     */
    private void assignTaskToStory(String line) {
        String[] arrLine = line.split(" ");
        int userStoryId = Integer.parseInt(arrLine[1]);
        int taskId = Integer.parseInt(arrLine[2]);
        for (UserStory us : userStories) {
            if (userStoryId == us.getId()) {
                for (Task t : tasks) {
                    if (taskId == t.getTaskId()) {
                        t.setUserStoryId(userStoryId);
                        System.out.println("Task mit ID " + taskId + " wurde erfolgreich User Story mit ID " +
                                userStoryId + " zugeordnet.");
                        return;
                    }
                }
                System.out.println("Keine Task mit ID " + taskId + " gefunden.");
                return;
            }
            System.out.println("Keine User Story mit ID " + userStoryId + "gefunden.");
        }
    }

    /**
     * Print all User Stories which are currently in the system.
     */
    private void printStories() {
        System.out.println("User Stories mit entsprechenden Tasks:");
        for (UserStory us : userStories) {
            System.out.println(us);
            for (Task t : tasks) {
                if (t.getUserStoryId() == us.getId()) {
                    System.out.println(t);
                }
            }
        }
    }

    /**
     * Print all Tasks which are currently in the system.
     */
    private void printTasks() {
        System.out.println("Alle Tasks ohne User Stories:");
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    /**
     * Load Data of User Stories and Tasks.
     *
     * @throws IOException
     */
    private void loadData() throws IOException{
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fin);
        try {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof UserStory) {
                    userStories.add((UserStory) obj);
                } else if (obj instanceof Task) {
                    tasks.add((Task) obj);
                } else {
                    System.out.println("Unbekanntes Obekt.");
                }
            }
        } catch (EOFException e) {
            System.out.println("Erfolgreich geladen.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }

    /**
     * Save Data of User Stories and Tasks to a file.
     *
     * @throws IOException
     */
    private void saveData() throws IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (UserStory us : userStories) {
            oos.writeObject(us);
        }
        for (Task t : tasks) {
            oos.writeObject(t);
        }
        oos.close();
        System.out.println("User Stories und Tasks wurden gespeichert.");
    }
}
