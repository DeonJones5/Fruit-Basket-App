public class Fruit {
    private String name;
    private String daysOld;
    private String characteristic1;
    private String characteristic2;

    public Fruit() {
    }

    public Fruit(String name, String daysOld, String characteristic1, String characteristic2) {
        this.name = name;
        this.daysOld = daysOld;
        this.characteristic1 = characteristic1;
        this.characteristic2 = characteristic2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDaysOld() {
        return daysOld;
    }

    public void setDaysOld(String daysOld) {
        this.daysOld = daysOld;
    }

    public String getCharacteristic1() {
        return characteristic1;
    }

    public void setCharacteristic1(String characteristic1) {
        this.characteristic1 = characteristic1;
    }

    public String getCharacteristic2() {
        return characteristic2;
    }

    public void setCharacteristic2(String characteristic2) {
        this.characteristic2 = characteristic2;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [name: " + name +
                ", daysOld: " + daysOld +
                ", characteristic1: " + characteristic1 +
                ", characteristic2: " + characteristic2 + "]";
    }
}
