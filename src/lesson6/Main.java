package lesson6;

import lesson6.animals.Animal;
import lesson6.animals.Cat;
import lesson6.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Cat myCat = new Cat("Tom", 6);
        Cat newCat = new Cat("Sam", 6);
        Dog myDog = new Dog("Baron", 4);

        myCat.run(100);
        myDog.run(200);

        myCat.swim(10);
        myDog.swim(10);

        System.out.println(Animal.count);
        System.out.println(Cat.catCount);
        System.out.println(Dog.dogCount);
    }
}
