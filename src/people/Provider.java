package people;

import java.io.Serializable;

public class Provider extends Workers implements Serializable {
    private int meat;

    public Provider() {
    }

    public Provider(String name, int age, TypeWork typeWork) {
        super(name, age, typeWork);
    }

    public void meatAddCook(Cook cook) {
        cook.setMeat(meat);
        System.out.println(this.getName() + " отдал мясо повару " + cook.getName() + " " + getMeat() + " кусков");
        this.meat = 0;

    }

    public void bye(int count) {
        meat = count;
        System.out.println(this.getName() + " купил мясо " + count + " кусков");
    }

    public int getMeat() {
        return meat;
    }

    public void setMeat(int meat) {
        this.meat = meat;
    }
}
