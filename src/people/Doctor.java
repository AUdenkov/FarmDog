package people;

import dog.Dog;

import java.io.Serializable;
import java.util.Scanner;

public class Doctor extends Personal implements TakeTheDog, Serializable {
    private Dog dog;

    public Doctor() {
        super();
    }

    public Doctor(String name, int age, TypeWork typeWork) {
        super(name, age, typeWork);
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void takeTheDog(Dog dog) {
        setDog(dog);
        System.out.println(this.getName());
    }

    @Override
    public void passTheDogForOverseer(Overseer overseer) {
        overseer.setDog(dog);
        System.out.println(getName() + " отдал собаку " + dog.getName() + " " + overseer.getName());
        this.dog = null;
    }


    public void checkDog() {
        System.out.println(getName() + " проводит проверку на здоровье " + dog.getName());
        double random = Math.random();
        if (random > 0.5) {
            dog.setHealth(true);
            System.out.println(dog.getName() + " оказалась здоровой");
        } else {
            System.out.println(dog.getName() + " оказалась не здоровой");
        }
    }


    public void regeneration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ты конченый врач?");
        System.out.println("1) конченый");
        System.out.println("2) нормальный");
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                dog.setHealth(false);
                System.out.println("Ну ты и конченый");

            }
            case 2 -> {
                dog.setHealth(true);
                System.out.println(getDog().getName() + " Вылечили");
            }
        }

    }

    @Override
    public String toString() {
        return "Doctor{"
                + super.toString() +
                "dog=" + dog +
                "} ";
    }


}
