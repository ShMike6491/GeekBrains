package lesson7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(50);

        Cat[] cats = {
                new Cat("Tom", 10),
                new Cat("Jack", 20),
                new Cat("Bella", 15),
                new Cat("Cloe", 10)
        };

        for (Cat x : cats) {
            System.out.println(x);
            x.eat(plate);
            System.out.println(plate);
        }
    }
}
