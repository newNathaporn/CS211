package ver2;
public enum DayOfWeek2 {

    MONDAY("Lunae - Moon"), TUESDAY("Martis - Mars"), WEDNESDAY("Mercurii - Mercury"), 
    THURSDAY("Jovis - Jupiter"), FRIDAY("Veneris - Venus"), SATURDAY("Saturni - Saturn"),
    SUNDAY("Solis - Sun");

    private final String latinName;

    private DayOfWeek2(String latinName) { // constructor
        this.latinName = latinName;
    }

    public String getLatinName() {
        return latinName;
    }
}
