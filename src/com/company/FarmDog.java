package com.company;

import clinic.Clinic;
import dog.Dog;
import doghome.Aviary;
import doghome.DogHome;
import people.*;
import playground.Playground;

import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FarmDog implements Serializable {
    private Playground playground;
    private Clinic clinic;
    private DogHome dogHome;
    private ArrayList<Workers> workers;
    private ArrayList<Dog> dogs;

    public FarmDog() {
        playground = new Playground();
        clinic = new Clinic();
        dogHome = new DogHome();
        workers = new ArrayList<>();
        dogs = new ArrayList<>();
        Overseer overseer = new Overseer("Andrey", 20, TypeWork.OVERSEER);
        Doctor doctor = new Doctor("Jeny", 10, TypeWork.DOCTOR);
        Cook cook = new Cook("Lesha", 25, TypeWork.COOK);
        Provider provider = new Provider("Dima", 18, TypeWork.PROVIDER);
        Trainer trainer = new Trainer("Masha", 20, TypeWork.TRAINER);
        Cleaner cleaner = new Cleaner("Igor", 22, TypeWork.CLEANER);
        clinic.setDoctor(doctor);
        trainer.setPlayground(playground);
        getDogHome().getCleaners().add(cleaner);
        addWorker(cleaner);
        addWorker(overseer);
        addWorker(doctor);
        addWorker(cook);
        addWorker(provider);
        addWorker(trainer);
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public DogHome getDogHome() {
        return dogHome;
    }

    public void setDogHome(DogHome dogHome) {
        this.dogHome = dogHome;
    }

    public ArrayList<Workers> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Workers> workers) {
        this.workers = workers;
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(ArrayList<Dog> dogs) {
        this.dogs = dogs;
    }

    public void addDog(Dog dog) {
        this.dogs.add(dog);
        Overseer overseer = getWorkers().stream().filter(workers -> workers.getTypeWork() == TypeWork.OVERSEER)
                .filter(workers -> workers instanceof Overseer)
                .map(workers -> (Overseer) workers).filter(overseer1 -> overseer1.getDog() == null).findFirst().get();
        Doctor doctor = getClinic().getDoctor();
        overseer.takeDog(dog);
        overseer.passTheDogForPersonal(doctor, dog);
        doctor.checkDog();
        doctor.passTheDogForOverseer(overseer);
        Aviary aviary1 = this.getDogHome().getAviaries().stream().filter(aviary -> aviary.getDog() == null).findFirst().get();
        overseer.dogInAviary(aviary1);
    }


    public void addWorker(Workers workers) {
        this.workers.add(workers);
    }


    @Override
    public String toString() {
        return "FarmDog{" +
                "playground=" + playground +
                ", clinic=" + clinic +
                ", dogHome=" + dogHome +
                ", workers=" + workers +
                ", dogs=" + dogs +
                '}';
    }
}
