import java.io.Serializable;

/**
 * @author Reise Thomas Kato
 * @created 09.05.2024
 * @project uebung4
 */
public class UserStory implements Serializable {
    private String description;
    private int id;
    private String sPriority;
    private int iPriority;

    public UserStory() {}

    public UserStory(String description, int id, String priority) {
        this.description = description;
        this.id = id;
        this.sPriority = priority;
        convertPrioToInt(priority);
    }

    /**
     * Convert MoSCoW Priority System to Integer for easier Priority Management inside program.
     * The lower the number, the higher the priority.
     *
     * @param priority  MoSCoW priority System
     */
    private void convertPrioToInt(String priority) {
        if(priority.toLowerCase().contains("must")) {
            this.iPriority = 0;
        }
        else if(priority.toLowerCase().contains("should")) {
            this.iPriority = 1;
        }
        else if(priority.toLowerCase().contains("could")) {
            this.iPriority = 2;
        }
        else {
            this.iPriority = 3;
        }
    }

    public int getId() {
        return id;
    }

    public int getiPriority() {
        return iPriority;
    }

    public String toString() {
        return "User Story ID: " + this.id + " - Beschreibung: " + this.description
                + " - Priorität: " + this.sPriority;
    }
}
