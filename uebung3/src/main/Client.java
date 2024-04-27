package main;

import java.util.List;

public class Client {
    public static void main(String args[]) {
        CardBox cardBox = CardBox.getInstance();
        PersonCard personCard1 = new EnduserCard("Rini", "Reh");
        PersonCard personCard2 = new DeveloperCard("Reise", "Kato");
        PersonCard personCard3 = new EnduserCard("Max", "Mod");
        PersonCard personCard4 = new DeveloperCard("Berni", "Winki");

        try {
            cardBox.addPerson(personCard1);
            cardBox.addPerson(personCard2);
            cardBox.addPerson(personCard3);
            cardBox.addPerson(personCard4);
        } catch (CardBoxException e)
        {
            System.out.println(e.getMessage());
        }

        PersonCardView personCardView = new PersonCardView();
        personCardView.showContent(cardBox.getCurrentList());

        try {
            cardBox.save();
            cardBox.load();
        } catch (CardBoxStorageException e) {
            System.out.println(e);
        }
    }
}
