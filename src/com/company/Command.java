package com.company;

import dog.*;

import java.io.*;
import java.util.Scanner;


public class Command {
    FarmDog farmDog = new FarmDog();
    Day day;
    Scanner scanner = new Scanner(System.in);
    int countDay = 1;

    public Command() {
        loadFarmDog();
        menu();
    }

    public void menu() {
        System.out.println("Меню");
        System.out.println("1) привели собаку");
        System.out.println("2) получить список собак");
        System.out.println("3) вывести ферму");
        System.out.println("4) закончить работу");
        System.out.println("5) Сброс");
        System.out.println("6) Симуляция");
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                addDog();
                menu();
            }
            case 2 -> {
                getListDog();
                menu();
            }
            case 3 -> {
                System.out.println(farmDog);
                menu();
            }
            case 4 -> saveFarmDog();
            case 5 -> {
                clear();
                menu();
            }
            case 6 -> goDay();
            default -> menu();
        }
    }

    public void addDog() {
        System.out.println("Введите имя");
        String name = scanner.next();
        System.out.println("Ведите возраст");
        int age = scanner.nextInt();
        Dog dog = null;
        while (age < 0 || age > 20) {
            System.out.println("Неверный возраст");
            System.out.println("Ведите возраст");
            age = scanner.nextInt();
        }
        if (age < 3 && age > 0) {
            dog = new Puppy(name, age, TypeDog.PUPPY);
        }
        if (age >= 3 && age < 10) {
            dog = new Adult(name, age, TypeDog.ADULT);
        }

        if (age >= 10) {
            dog = new Elderly(name, age, TypeDog.ELDERLY);
        }
        farmDog.addDog(dog);
        saveFarmDog();
    }

    public void getListDog() {
        try {
            FileWriter fileWriter = new FileWriter("Список собак.txt");
            try {
                for (int i = 0; i < farmDog.getDogs().size(); i++) {
                    fileWriter.write(i + 1 + ") " + farmDog.getDogs().get(i).getName() + "\n");
                }

            } catch (IOException e) {

            } finally {
                fileWriter.close();
            }

        } catch (IOException e) {

        }
    }

    public void saveFarmDog() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("FarmDog.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(farmDog);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("save");
    }


    public void loadFarmDog() {
        try {
            FileInputStream fileInputStream = new FileInputStream("FarmDog.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object o = objectInputStream.readObject();
            farmDog = (FarmDog) o;
            fileInputStream.close(); //Error
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Load");
    }

    public void clear() {
        farmDog = new FarmDog();
    }

    public void goDay() {
        day = new Day(farmDog, countDay);
        day.go();
        countDay++;
        menu();
    }
}
