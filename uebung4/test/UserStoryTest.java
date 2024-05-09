import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Reise Thomas Kato
 * @created 09.05.2024
 * @project uebung4
 */

public class UserStoryTest {
    UserStory userStory;

    @BeforeEach
    void setUp() {
        userStory = new UserStory();
    }

    @Test
    void toStringTest() {
        userStory = new UserStory("Bitte Tee", 1, "must-have");
        assertEquals(userStory.toString(), "User Story ID: 1 - Beschreibung: Bitte Tee - Priorität: must-have");
    }
    @Test
    void priorityIntTest() {
        String[] prios = {"must-have", "should-have", "could-have", "won't have"};
        for(int i = 0; i < 4; i++) {
            userStory = new UserStory("Bitte Tee", 1, prios[i]);
            assertEquals(userStory.getiPriority(), i);
        }
    }

}
