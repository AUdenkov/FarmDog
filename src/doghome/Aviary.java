package doghome;

import dog.Dog;

import java.io.Serializable;
import java.util.Objects;

public class Aviary implements Serializable {
    private boolean field;
    private Dog dog;

    public Aviary() {
    }

    public Aviary(Dog dog) {
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public boolean isField() {
        return field;
    }

    public void setField(boolean field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aviary aviary = (Aviary) o;
        return field == aviary.field && Objects.equals(dog, aviary.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, dog);
    }

    @Override
    public String toString() {
        return "Aviary{" +
                "field=" + field +
                ", dog=" + dog +
                '}';
    }
}
