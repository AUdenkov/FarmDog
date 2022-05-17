package people;

import dog.Dog;
import doghome.Aviary;

import java.io.Serializable;

public class Overseer extends Personal implements Serializable {
    private Dog dog;
    private int food;

    public Overseer(String name, int age, TypeWork typeWork) {
        super(name, age, typeWork);
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void feedADog(Dog dog) {
        dog.setEat(true);
        food--;
        System.out.println(getName() + " покормил " + dog.getName());

    }
    public void dogInAviary(Aviary aviary) {
        aviary.setDog(getDog());
        aviary.setField(true);
        System.out.println(getName() + " завел собаку " + getDog().getName() + " в вальер");
        this.dog = null;

    }

    public void passTheDogForPersonal(TakeTheDog people, Dog dog) {
        System.out.print(getName() + " отдал собаку ");
        people.takeTheDog(dog);
        this.setDog(null);
    }

    public void getDog(Dog dog) {
        setDog(dog);
        System.out.println(this.getName() + " Взял собаку " + dog.getName());
    }

    public void takeDogOfAviary(Aviary aviary) {
        this.dog = aviary.getDog();
        aviary.setField(false);
    }

    public boolean takeFood(Cook cook, int count) {
        this.food = count;
        cook.setPortions(cook.getPortions() - count);
        boolean cheak = cook.cheakPortions();
        System.out.println(getName() + " взял " + count + " порций");
        return cheak;
    }

    public void takeDog(Dog dog) {
        setDog(dog);
        System.out.println(getName() + " взял собаку " + dog.getName());
    }


    public void dogInJob() {
        System.out.println(getName() + " отправил на работу собаку " + getDog().getName());
        this.dog = null;
    }

    @Override
    public String toString() {
        return "Overseer{" +
                super.toString() +
                "dog=" + dog +
                ", food=" + food + "} ";

    }
}
