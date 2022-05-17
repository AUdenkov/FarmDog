package people;

import java.io.Serializable;

public abstract class Personal extends Workers implements Serializable {

    public Personal() {
        super();
    }

    public Personal(String name, int age, TypeWork typeWork) {
        super(name, age, typeWork);

    }
}
