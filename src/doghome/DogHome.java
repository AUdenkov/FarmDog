package doghome;

import people.Cleaner;

import java.io.Serializable;
import java.util.ArrayList;

public class DogHome implements Serializable {
    private ArrayList<Cleaner> cleaners;
    private ArrayList<Aviary> aviaries;
    private int countAviary;

    public DogHome() {
        countAviary = 10;
        cleaners = new ArrayList<>();
        aviaries = new ArrayList<>();
        for (int i = 0; i < countAviary; i++) {
            aviaries.add(new Aviary());
        }
    }

    public ArrayList<Cleaner> getCleaners() {
        return cleaners;
    }

    public void setCleaners(ArrayList<Cleaner> cleaners) {
        this.cleaners = cleaners;
    }

    public ArrayList<Aviary> getAviaries() {
        return aviaries;
    }

    public void setAviaries(ArrayList<Aviary> aviaries) {
        this.aviaries = aviaries;
    }

    @Override
    public String toString() {
        return "DogHome{" +
                "cleaners=" + cleaners +
                ", aviaries=" + aviaries +
                '}';
    }
}
