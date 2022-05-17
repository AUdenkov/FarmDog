package playground;

import dog.Dog;
import people.Trainer;

import java.io.Serializable;

public abstract class PlaygroundAbstract implements Serializable, Mis {
    private Dog dog;
    private Trainer trainer;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public abstract boolean mission(Dog dog);

    @Override
    public String toString() {
        return "PlaygroundAbstract{}";
    }
}
