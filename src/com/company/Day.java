package com.company;

import dog.Adult;
import dog.TypeDog;
import doghome.Aviary;
import people.*;

import java.util.LinkedList;
import java.util.stream.Collectors;


public class Day {
    int day;
    private FarmDog farmDog;

    public Day(FarmDog farmDog, int countDay) {
        this.farmDog = farmDog;
        day=countDay;
    }

    public void go() {
        System.out.println("Наступило утро");
        if (farmDog.getDogs().stream().anyMatch(dog -> dog.getTypeDog() == TypeDog.ADULT || dog.getTypeDog() == TypeDog.PUPPY || dog.getTypeDog() == TypeDog.ELDERLY)) {
            Provider provider = farmDog.getWorkers().stream().filter(workers -> workers.getTypeWork() == TypeWork.PROVIDER)
                    .filter(workers -> workers instanceof Provider)
                    .map(workers -> (Provider) workers)
                    .findFirst().get();
            Cook cook = farmDog.getWorkers().stream().filter(workers -> workers.getTypeWork() == TypeWork.COOK)
                    .filter(workers -> workers instanceof Cook)
                    .map(workers -> (Cook) workers)
                    .findFirst().get();
            Overseer overseer = farmDog.getWorkers().stream().filter(workers -> workers.getTypeWork() == TypeWork.OVERSEER)
                    .filter(workers -> workers instanceof Overseer)
                    .map(workers -> (Overseer) workers)
                    .findFirst().get();
            Cleaner cleaner = farmDog.getWorkers().stream().filter(workers -> workers.getTypeWork() == TypeWork.CLEANER)
                    .filter(workers -> workers instanceof Cleaner)
                    .map(workers -> (Cleaner) workers)
                    .findFirst().get();
            Trainer trainer = farmDog.getWorkers().stream().filter(workers -> workers.getTypeWork() == TypeWork.TRAINER)
                    .filter(workers -> workers instanceof Trainer)
                    .map(workers -> (Trainer) workers)
                    .findFirst().get();
            Doctor doctor = farmDog.getClinic().getDoctor();
            provider.bye(10);
            provider.meatAddCook(cook);
            cook.makeEat();
            if (overseer.takeFood(cook, farmDog.getDogs().size())) {
                foodPreparation(provider, cook);
            }
            eatDog(overseer);
            LinkedList<Adult> dogsinJob = dogInJob(overseer);
            cleaner.clear(farmDog.getDogHome().getAviaries());
            int countPuppy = 0;
            if (farmDog.getDogs().stream().anyMatch(dog -> dog.getTypeDog() == TypeDog.PUPPY)) {
                countPuppy = (int) farmDog.getDogs().stream().filter(dog -> dog.getTypeDog() == TypeDog.PUPPY).count();
                if (overseer.takeFood(cook, (int) farmDog.getDogs().stream().filter(dog -> dog.getTypeDog() == TypeDog.PUPPY).count())) {
                    foodPreparation(provider, cook);
                }
                eatPyppu(overseer);
            }
            overseer.takeFood(cook, (int) farmDog.getDogHome().getAviaries().stream().filter(aviary -> aviary.isField()).count());
            eatDog(overseer);
            regen(overseer, doctor);
            training(overseer, trainer);
            dogEndJob(dogsinJob, overseer);
            if (farmDog.getDogs().stream().anyMatch(dog -> dog.getTypeDog() == TypeDog.PUPPY)) {
                if (overseer.takeFood(cook, countPuppy)) {
                    foodPreparation(provider, cook);
                }
                eatPyppu(overseer);
            }
            if (overseer.takeFood(cook, farmDog.getDogs().size())) {
                foodPreparation(provider, cook);
            }
            eatDog(overseer);
            cook.throwAwayFood();
        }
        System.out.println("Закончился " + day + " день");

    }

    public void foodPreparation(Provider provider, Cook cook) {
        provider.bye(5);
        provider.meatAddCook(cook);
        cook.makeEat();
    }

    public void regen(Overseer overseer, Doctor doctor) {
        try {
            farmDog.getDogHome().getAviaries().stream().filter(aviary -> !aviary.getDog().isHealth())
                    .peek(aviary -> {
                        overseer.getDog(aviary.getDog());
                        overseer.passTheDogForPersonal(doctor, aviary.getDog());
                        doctor.regeneration();
                        doctor.passTheDogForOverseer(overseer);
                        overseer.dogInAviary(aviary);
                    }).collect(Collectors.toList());
        } catch (NullPointerException e) {

        }

    }

    public void eatPyppu(Overseer overseer) {
        for (int i = 0; i < farmDog.getDogs().stream().filter(dog -> dog.getTypeDog() == TypeDog.PUPPY).count(); i++) {
            try {
                farmDog.getDogHome().getAviaries().stream().filter(aviary -> aviary.getDog().getTypeDog() == TypeDog.PUPPY)
                        .peek(aviary -> overseer.feedADog(aviary.getDog())).collect(Collectors.toList());
            } catch (NullPointerException e) {

            }
        }
    }

    public void eatDog(Overseer overseer) {
        try {
            farmDog.getDogHome().getAviaries().stream().filter(Aviary::isField)
                    .peek(aviary -> overseer.feedADog(aviary.getDog())).collect(Collectors.toList());
        } catch (NullPointerException e) {
        }

    }

    public LinkedList<Adult> dogInJob(Overseer overseer) {
        LinkedList<Adult> dogs = new LinkedList<>();
        try {
            farmDog.getDogHome().getAviaries().stream().filter(aviary -> aviary.getDog().getTypeDog() == TypeDog.ADULT && aviary.getDog().isHealth() && aviary.getDog().getLevel() == 4)
                    .peek(aviary -> {
                        overseer.takeDogOfAviary(aviary);
                        overseer.dogInJob();
                        Adult adult = null;
                        if (aviary.getDog() instanceof Adult) {
                            adult = (Adult) aviary.getDog();
                        }
                        dogs.add(adult);
                    }).collect(Collectors.toList());
        } catch (NullPointerException e) {
        }
        return dogs;
    }

    public void dogEndJob(LinkedList<Adult> dogs, Overseer overseer) {
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i).getName() + " Окончила работу");
            overseer.takeDog(dogs.get(i));
            for (int j = 0; j < farmDog.getDogHome().getAviaries().size(); j++) {
                if (farmDog.getDogHome().getAviaries().get(j).getDog().equals(overseer.getDog())) {
                    overseer.dogInAviary(farmDog.getDogHome().getAviaries().get(j));
                    return;
                }
            }
        }
    }


    public void training(Overseer overseer, Trainer trainer) {
        try {
            farmDog.getDogHome().getAviaries().stream().filter(aviary -> aviary.getDog().getTypeDog() == TypeDog.ADULT && aviary.getDog().isHealth() && aviary.getDog().getLevel() != 4)
                    .peek(aviary -> {
                        overseer.getDog(aviary.getDog());
                        overseer.passTheDogForPersonal(trainer, aviary.getDog());
                        trainer.trainDog();
                        trainer.passTheDogForOverseer(overseer);
                        overseer.dogInAviary(aviary);
                    }).collect(Collectors.toList());
        } catch (NullPointerException e) {

        }
    }
}

