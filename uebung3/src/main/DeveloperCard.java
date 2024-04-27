package main;

public class DeveloperCard extends abstractPersonCard {
    private boolean hasEnoughCoffee;
    public DeveloperCard(String firstname, String lastname) {
        super(firstname, lastname);
        this.hasEnoughCoffee = true;
    }

    public String toString() {
        String s = super.toString();
        s += "hasEnoughCoffee = [" + this.hasEnoughCoffee + "]";

        return s;
    }
}
