package clinic;

import people.Doctor;

import java.io.Serializable;

public class Clinic implements Serializable {
    private Doctor doctor;

    public Clinic() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    @Override
    public String toString() {
        return "Clinic{" +
                "doctor=" + doctor +
                '}';
    }
}
