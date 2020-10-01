package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        //guessNumGame(10,3);
        //guessWord();
    }

    /** Задание 1: программа, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
     *
     * @param number Параметр для диапазона секретного числа.
     * @param tries Параметр определяющий количество попыток.
     * */
    private static void guessNumGame (int number, int tries) {
        int x = rand.nextInt(number);
        int count = 0;
        int num;
        System.out.println("Угадай число от 0 до " + (number-1));

        do {
            num = sc.nextInt();
            if(num == x) {
                System.out.println("Правильно!");
                break;
            } else if(num < x) {
                System.out.println("Больше");
            } else {
                System.out.println("Меньше");
            }
            count++;
        } while (count < tries);

        System.out.println("Игра окончина. Нажми \"1\", чтобы попробовать еще");
        String reply = sc.next();

        if(reply.equals("1")) {
            guessNumGame(number, tries);
        }
    }

    /** Задание 2: Игра угадай слово.
     * */
    private static void guessWord () {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String secret = words[rand.nextInt(words.length)];
        String answer = "";
        String word;
        int temp;

        System.out.println("Попробуй угадать слово:");

        do {
            word = sc.next();

            temp = Math.min(word.length(), secret.length());

            for (int i = 0; i < temp; i++) {
                if (word.charAt(i) == secret.charAt(i)) {
                    answer += word.charAt(i);
                } else {
                    answer += "#";
                }
            }

            for (int j = 0; j < 15-temp; j++) {
                answer += "#";
            }

            System.out.println(answer);
            answer = "";

        } while (!secret.equals(word));

        System.out.println("Отлично! Слово угадано! Нажми \"1\", чтобы сыграть еще");
        String reply = sc.next();

        if(reply.equals("1")) {
            guessWord();
        }
    }
}
