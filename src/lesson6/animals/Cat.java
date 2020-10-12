package lesson6.animals;

public class Cat extends Animal{
    public static int catCount = 0;

    public Cat(String name, int age) {
        super(name, age);
        catCount++;
    }

    @Override
    public void run(int length) {
        if(length <= 200 && length > 0) {
            System.out.println(name + " has finished " + length + " race");
            return;
        }
        System.out.println("Sorry, can't run that far");
    }

    @Override
    public void swim(int length) {
        System.out.println("Sorry, I can't swim!");
    }
}
