package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int SIZE = 5; //размер поля
    static final int DOTS_TO_WIN = 3; //победное значение

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static int moveCount = 0; // подсчет ходов
    static int c = 0, p = 0; // очки игроков

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        playGame();

        System.out.printf("score: computer - %d player - %d \n", c, p);

        System.out.println("Want to play more? Press \"y\" for yes.");
        String reply = sc.next().toLowerCase();
        if(reply.equals("y")) {
            moveCount = 0;
            playGame();
        }

    }

    /** Инициализатор игры
     * */
    private static void playGame () {
        boolean turns = true;
        char turnsCheck;
        String reply;
        mapInit();
        printMap();

        do {
            System.out.println("Who should go first? \"c\" for computer, \"p\" for player");
            reply = sc.next().toLowerCase();
            if(reply.equals("c")) {
                turns = false;
            }
        } while (reply == "c" || reply == "p");


        while(true) {
            if (turns) {
                turnsCheck = DOT_X;
                player();
            } else {
                turnsCheck = DOT_O;
                comp();
            }
            moveCount++;

            printMap();
            if(checkWin(turnsCheck)) {
                if(turns) {
                    System.out.println("Player Won!");
                    p++;
                } else {
                    System.out.println("Game Over!");
                    c++;
                }
                break;
            }
            if(isFull()) {
                System.out.println("Tie!");
                break;
            }

            turns = !turns;
        }
    }

    /** Инициализатор пустой карты.
     * */
    private static void mapInit() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    /** Выводит карту на консоль
     * */
    private static void printMap() {
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%4d", i+1);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i+1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%4c", map[i][j]);
            }
            System.out.println();
        }
    }

    /** Производит ход игрока
     * */
    private static void player() {
        int x, y;
        do {
            System.out.println("Your turn (x,y)");
            x = sc.nextInt()-1;
            y = sc.nextInt()-1;
        } while (!checkCell(y, x));
        map[y][x] = DOT_X;
    }
    /** Производит ход компьютера
     * */
    private static void comp() {
        int x, y;

        if(compBrain(DOT_O)) {
            return;
        }

        if(compBrain(DOT_X)) {
            return;
        }

        do {
            x=rand.nextInt(SIZE);
            y=rand.nextInt(SIZE);
        } while (!checkCell(y, x));
        map[y][x] = DOT_O;
    }
    /** Просчитывает ход компьютера
     * */
    private static boolean compBrain (char c) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkCell(i, j)) {
                    map[i][j] = c;
                    if (checkWin(c)) {
                        if (c == DOT_X) {
                            map[i][j] = DOT_O;
                        }
                        return true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    /** Проверка клетки на возможность хода
     * */
    private static boolean checkCell(int y, int x) {
        if (y<0 || x<0 || y>=SIZE || x>=SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    /** Определяет заполниность поля
     * */
    private static boolean isFull () {
        return (moveCount == Math.pow(SIZE, 2));
    }

    /** Определяет победителя
     * */
    private static boolean checkWin (char c) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(check(i, j, c)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean check (int i, int j, char c) {
        int x = 0, y = 0, z = 0, d = 0;
        for (int k = 0; k < DOTS_TO_WIN; k++) {
            if(j+k < SIZE) {
                if (i-k >= 0) {
                    if ( map[i-k][j+k] == c ) { x++; }
                }
                if ( map[i][j+k] == c) { y++; }
            }
            if(i+k < SIZE) {
                if ( map[i+k][j] == c ) { z++; }
                if (j+k < SIZE) {
                    if ( map[i+k][j+k] == c ) { d++; }
                }
            }
        }
        return (x >= DOTS_TO_WIN || z == DOTS_TO_WIN || y == DOTS_TO_WIN || d == DOTS_TO_WIN );
    }
}