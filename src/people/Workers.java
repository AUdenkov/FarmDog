package people;

import java.io.Serializable;

public abstract class Workers implements Serializable {
    private String name;
    private int age;
    private TypeWork typeWork;


    public Workers() {
    }

    public Workers(String name, int age, TypeWork typeWork) {
        this.name = name;
        this.age = age;
        this.typeWork = typeWork;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TypeWork getTypeWork() {
        return typeWork;
    }

    public void setTypeWork(TypeWork typeWork) {
        this.typeWork = typeWork;
    }


    @Override
    public String toString() {
        return "Workers{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", typeWork=" + typeWork +
                '}';
    }
}
