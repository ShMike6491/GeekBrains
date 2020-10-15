package lesson6.animals;

public class Dog  extends Animal{
    public static int dogCount = 0;

    public Dog(String name, int age) {
        super(name, age);

        dogCount++;
    }

    @Override
    public void run(int length) {
        if(length <= 500 && length > 0) {
            System.out.println(name + " has finished " + length + " race");
            return;
        }
        System.out.println("Sorry, can't run that far");
    }

    @Override
    public void swim(int length) {
        if(length <= 10 && length > 0) {
            System.out.println(name + " has finished " + length + " swim");
            return;
        }
        System.out.println("Sorry, can't swim that far");
    }
}
