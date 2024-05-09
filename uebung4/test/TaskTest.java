import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Reise Thomas Kato
 * @created 09.05.2024
 * @project uebung4
 */

public class TaskTest {
    @Test
    void toStringTest() {
        Task task = new Task("Teebeutel kaufen.", 1);
        assertEquals(task.toString(), "Task ID: 1 - Beschreibung: Teebeutel kaufen.");
    }
}
