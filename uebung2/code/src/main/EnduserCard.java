package main;

public class EnduserCard extends abstractPersonCard {
    private boolean isHungry = true;
    public EnduserCard(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public String toString() {
        String s = super.toString();
        s += "isHungry = [" + this.isHungry + "]";

        return s;
    }
}
