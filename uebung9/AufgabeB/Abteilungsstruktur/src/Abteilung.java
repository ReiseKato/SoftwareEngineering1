public abstract class Abteilung {
    private String name;
    public Abteilung() {}
    public Abteilung(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(this.name);
    }
}
