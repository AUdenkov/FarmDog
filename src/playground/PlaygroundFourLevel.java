package playground;

import dog.Dog;

import java.io.Serializable;
import java.util.Scanner;

public class PlaygroundFourLevel extends PlaygroundAbstract implements  Serializable {
    public PlaygroundFourLevel() {
    }

    @Override
    public boolean mission(Dog dog) {
        System.out.println("Обучаем собаку " + dog.getName());
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (count != 5) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            int c = (int) (Math.random() * 10);
            System.out.println("Результат равен ?\n" + "(" + x + "+" + y + ")" + "*" + c + "=");
            if ((x + y) * c == scanner.nextInt()) {
                count++;
            } else {
                System.out.println("Вы слбаое звено, прощайте");
                return false;
            }
        }
        return true;
    }
}
