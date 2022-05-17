package dog;

import java.io.Serializable;

public class Elderly extends Dog implements Serializable {
    public Elderly(String name, int age, TypeDog typeDog) {
        super(name, age, typeDog);
    }
}
