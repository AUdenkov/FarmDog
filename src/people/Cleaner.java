package people;

import doghome.Aviary;

import java.io.Serializable;
import java.util.ArrayList;

public class Cleaner extends Personal implements Serializable {

    public Cleaner(String name, int age, TypeWork typeWork) {
        super(name, age, typeWork);
    }

    public void clear(ArrayList<Aviary> aviaries){
        for (int i = 0; i < aviaries.size(); i++) {

        }
        System.out.println("Уборщик убрал все вольеры");
    }

}
