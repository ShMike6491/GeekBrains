package lesson1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // #2
        // primitive types
        byte num1 = 127;
        short num2 = 32_000;
        int num3 = 2_000_000;
        long num4 = 2_000_000L;
        float num5 = 1.123456789F;
        double num6 = 1.123456789;
        char letter = 'A';
        boolean bool = true;

        // reference types
        String word = "Hello!";
        Date now = new Date();

        System.out.println("Числа:\n" + num1 + "\n" + num2 + "\n" + num3 + "\n" + num4 + "\n" + num5 + "\n" + num6);
        System.out.println("Символ:" + letter);
        System.out.println("Логический тип:" + bool);
        System.out.println("Строка:" + word);
        System.out.println("Дата:" + now);
        //_______________________________

        // #3
        System.out.println("\n" + thirdTask(5, 10, 12, 8));

        // #4
        System.out.println("\n" + fourthTask(19, 2));

        // #5
        fifthTask(0);

        // #6
        System.out.println("\n" + sixthTask(0));

        // #7
        seventhTask("Миша");

        // #8
        eighthTask(1992);
    }

    // #3
    static int thirdTask (int a, int b, int c, int d) {
        return a * (b + (c/d));
    }

    // #4
    static boolean fourthTask (int a, int b) {
        return (a+b >= 10 && a+b <=20);
    }

    // #5
    static void fifthTask (int a) {
        String ans = (a >= 0) ? "Положительное" : "Отрицательное";
        System.out.println("\n" + ans);
    }

    // #6
    static boolean sixthTask (int a) {
        return (a < 0);
    }

    // #7
    static void seventhTask (String name) {
        System.out.println("\n\"Привет, " + name + "!\"");
    }

    // #8
    static void eighthTask (int year) {
        boolean leapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
        if (leapYear) {
            System.out.println("\nВисокосный");
            return;
        }

        System.out.println("\nНе является високосным");
    }
}
