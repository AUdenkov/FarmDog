package people;

import java.io.Serializable;

public class Cook extends Personal implements Serializable {
    private int portions;
    private int meat;

    public Cook(String name, int age, TypeWork typeWork) {
        super(name, age, typeWork);
    }

    public void makeEat() {
        portions = meat * 3;
        this.meat = 0;
        System.out.println("повар " + getName() + " сделал " + getPortions() + " порций");
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public int getMeat() {
        return meat;
    }

    public void setMeat(int meat) {
        this.meat = meat;
    }

    public void throwAwayFood() {
        setPortions(0);
        System.out.println(getName() + " выкинул еду ");
    }

    public boolean cheakPortions(){
        if (getPortions()<10){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Cook{" +
                "portions=" + portions +
                ", meat=" + meat +
                "} " + super.toString();
    }
}
