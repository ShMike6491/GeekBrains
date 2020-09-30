package lesson2;

import java.util.Arrays;

public class Main {
        /*
        Вопрос: Так сокращать скобки тоже нельзя, если одно действие?

        for (int x : array)
            sumArr += x;

        if (true)
            do smth
        else
            do this
        */
    public static void main(String[] args) {
        int[] binaryArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] emptyArr = new int[8];
        int[] sample = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[][] twoDimensionalArr = new int[5][5];

        reverseArray(binaryArr);
        fillInArray(emptyArr);
        // doubleLowNumbers(sample);
        // crossArrays(twoDimensionalArr);

        // Пятое задание
        // System.out.println(minValue(newArr));
        // System.out.println(maxValue(newArr));

        // Шестое задание
        // System.out.println(checkBalance(sample));

        // Седьмое задание
        shiftArray(sample, 6);

        // Проверка
        // System.out.println(Arrays.toString(emptyArr));
        // System.out.println(Arrays.toString(binaryArr));
        // System.out.println(Arrays.toString(sample));
    }

    /**
     * Первое задание: меняет каждый элемент бинарного массива на противоположный.
     *
     * @param array Массив из бинарных чисел.
     *  */
    static void reverseArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    /**
     * Второе задание: заполнить массив значениями 0 3 6 9 12 15 18 21.
     *
     * @param array Пустой массив для заполнения.
     * */
    static void fillInArray (int[] array) {
        int j = 0;
        for (int i = 0; i <= 21; i+=3) {
            array[j++] = i;
        }
    }

    /**
     * Третье задание: удваивает те значения массива, которые меньше шести.
     *
     * @param array одномерный массив в качестве параметра.
     * */
    static void doubleLowNumbers (int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] < 6) ? array[i]*2 : array[i];
        }
    }

    /**
     * Четвертое задание: изменение диагональных элементов двумерного массива.
     *
     * @param array пустой квадратный двумерный целочисленный массив в качестве параметра.
     * */
    static void crossArrays (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                if(i == j || i+j == array.length-1) {
                    array[i][j] = 1;
                }

                System.out.printf("%4d", array[i][j]);
            }
            System.out.println();
        }
    }

    // Пятое задание
    /**
     * Возвращает минималное значение из массива
     *
     * @param array одномерный массив в качестве параметра.
     * */
    static int minValue (int[] array) {
        int ans = array[0];
        for (int x : array) {
            ans = Math.min(x, ans); //(ans > x) ? x : ans;
        }
        return ans;
    }
    /**
     * Возвращает максимальное значение из массива
     *
     * @param array одномерный массив в качестве параметра.
     * */
    static int maxValue (int[] array) {
        int ans = array[0];
        for (int x : array) {
            ans = Math.max(x, ans); //(ans > x) ? ans : x;
        }
        return ans;
    }

    /**
     * Шестое задание: метод определяет, если в массиве есть место, в котором сумма левой и правой части массива равны.
     *
     * @param array одномерный массив в качестве параметра.
     * */
    static boolean checkBalance (int[] array) {
        int midNum = 0;
        int dummy = 0;
        int i, j;

        for (int x : array) {
            midNum += x;
        }
        midNum /= 2;

        for (i = 0; dummy < midNum; i++) {
            dummy += array[i];
        }

        dummy = 0;
        for (j = array.length-1; dummy < midNum; j--) {
            dummy += array[j];
        }
        return (i-j == 1);
    }

    /** Седьмое задание: сдвигает значения из массива в определенную сторону на определенное количество раз.
     *
     * @param array задает исходный массив.
     * @param n определяет направление и количество шагов.
     * */
    static void shiftArray (int[] array, int n) {
        int length = array.length-1;
        int count = Math.abs(n);
        int x = (n>0) ? 1 : -1;
        int save, index;

        for (int j = 0; j < count; j++) {
            for (int i = 0; i < length; i++) {
                index = (n > 0) ? i : length - i;

                save = array[index];
                array[index] = array[index + x];
                array[index + x] = save;
            }
        }
    }
}
