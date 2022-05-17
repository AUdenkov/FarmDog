package dog;

import java.io.Serializable;

public class Adult extends Dog implements Serializable {
    public Adult(String name, int age, TypeDog typeDog) {
        super(name, age, typeDog);
    }

}
