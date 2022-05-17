package people;

import dog.Dog;
import playground.Playground;
import playground.PlaygroundAbstract;

import java.io.Serializable;

public class Trainer extends Personal implements TakeTheDog, Serializable {
    private Dog dog;
    private Playground playground;

    public Trainer(String name, int age, TypeWork typeWork) {
        super(name, age, typeWork);
    }


    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    @Override
    public void takeTheDog(Dog dog) {
        setDog(dog);
        System.out.println(getName());
    }

    @Override
    public void passTheDogForOverseer(Overseer overseer) {
        overseer.setDog(dog);
        System.out.println(getName() + " отдал собаку " + dog.getName() + " " + overseer.getName());
        this.dog = null;
    }

    public void trainDog() {
        switch (dog.getLevel()) {
            case 0 -> {
                extracted(playground.getPlaygroundOneLevel());
            }
            case 1 -> {
                extracted(playground.getPlaygroundTwoLevel());
            }
            case 2 -> {
                extracted(playground.getPlaygroundThreeLevel());
            }
            case 3 -> {
                extracted(playground.getPlaygroundFourLevel());
            }
        }
    }

    private void extracted(PlaygroundAbstract playground) {
        playground.setDog(dog);
        playground.setTrainer(this);
        if (playground.mission(dog)) {
            dog.setLevel(dog.getLevel() + 1);
        }
        playground.setDog(null);
        playground.setTrainer(null);

    }

    @Override
    public String toString() {
        return "Trainer{" +
                "dog=" + dog +
                ", playground=" + playground +
                "} " + super.toString();
    }


}
