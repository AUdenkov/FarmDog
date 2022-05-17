package playground;

import dog.Dog;

import java.io.Serializable;
import java.util.Scanner;

public class PlaygroundTwoLevel extends PlaygroundAbstract implements  Serializable {
    public PlaygroundTwoLevel() {
    }

    @Override
    public boolean mission(Dog dog) {
        System.out.println("Обучаем собаку " + dog.getName());
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (count != 5) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 20);
            System.out.println("Разница этих чисел равна ?\n" + x + "-" + y + "=");
            if (x - y == scanner.nextInt()) {
                count++;
            }
            else {
                System.out.println("Вы слабое звено, прощайте");
                return false;
            }
        }
        return true;
    }
}
