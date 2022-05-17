package dog;

import doghome.Aviary;

import java.io.Serializable;

public abstract class Dog implements Serializable {
    private TypeDog typeDog;
    private String name;
    private int age;
    private int level;
    private boolean health;
    private boolean eat;

    public Dog() {

    }

    public Dog(String name, int age,TypeDog typeDog) {
        this.name = name;
        this.age = age;
        this.typeDog=typeDog;
        this.level = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public boolean isEat() {
        return eat;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    public TypeDog getTypeDog() {
        return typeDog;
    }

    public void setTypeDog(TypeDog typeDog) {
        this.typeDog = typeDog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "typeDog=" + typeDog +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                ", health=" + health +
                ", eat=" + eat +
                '}';
    }
}
