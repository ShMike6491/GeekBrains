package lesson6.animals;

public abstract class Animal {
    protected String name;
    protected int age;
    public static int count = 0;

    public Animal() { count ++; }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;

        count++;
    }

    public abstract void run(int length);
    public abstract void swim(int length);

    // Такого рода перегруз, тоже относится к полиморфизму?
    public void sayName() {
        System.out.println(name);
    }

    public void sayName(String otherName) {
        System.out.println(name + " called " + otherName);
    }

}
