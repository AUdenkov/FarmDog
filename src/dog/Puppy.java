package dog;

import java.io.Serializable;

public class Puppy extends Dog implements Serializable {
    public Puppy(String name, int age,TypeDog typeDog) {
        super(name, age, typeDog);
    }
}
