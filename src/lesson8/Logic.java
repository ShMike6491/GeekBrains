package lesson8;

import java.util.Random;

public class Logic {
    private static int size = 0; //размер поля
    private static int dotsToWin = 0; //победное значение
    static boolean endGame;
    static String winner;
    static boolean playerVsComp;
    static char turns;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static int moveCount = 0; // подсчет ходов
    static int c = 0, p = 0; // очки игроков

    static char[][] map;

    static Random rand = new Random();

    /** Инициализатор игры
     * */
    static void playGame () {
        endGame = true;

        moveCount++;
        if(checkWin(DOT_X)) {
            winner = "Player wins!";
            p++;
            return;
        }
        if(isFull()) {
            winner = "Tie!";
            return;
        }

        comp();
        moveCount++;
        if(checkWin(DOT_O)) {
            winner = "Game over!";
            c++;
            return;
        }
        if(isFull()) {
            winner = "Tie";
            return;
        }

        endGame = false;
    }

    static void playWithFriend (){
        endGame = true;

        moveCount++;
        if(checkWin(turns)) {
            winner = turns + " wins!";
            return;
        }
        if(isFull()) {
            winner = "Tie";
            return;
        }

        if(turns == DOT_X) {
            turns = DOT_O;
        } else {
            turns = DOT_X;
        }

        endGame = false;
    }

    /** Инициализатор пустой карты.
     * */
     static void mapInit(boolean hVsComp,int s, int w) {
         turns = DOT_X;
         playerVsComp = hVsComp;
         endGame = false;
         size = s;
         dotsToWin = w;
         moveCount = 0;


        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /** Производит ход игрока
     * */
     static void player(int x , int y) {
         if(checkCell(y,x)) {
             map[y][x] = turns;
             if(playerVsComp) {
                 playGame();
             } else {
                 playWithFriend();
             }
         }
    }
    /** Производит ход компьютера
     * */
     static void comp() {
        int x, y;

        if(compBrain(DOT_O)) {
            return;
        }

        if(compBrain(DOT_X)) {
            return;
        }

        do {
            x=rand.nextInt(size);
            y=rand.nextInt(size);
        } while (!checkCell(y, x));
        map[y][x] = DOT_O;
    }
    /** Просчитывает ход компьютера
     * */
     static boolean compBrain (char c) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
     static boolean checkCell(int y, int x) {
        if (y<0 || x<0 || y>= size || x>= size) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    /** Определяет заполниность поля
     * */
     static boolean isFull () {
        return (moveCount == Math.pow(size, 2));
    }

    /** Определяет победителя
     * */
     static boolean checkWin (char c) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(check(i, j, c)) {
                    return true;
                }
            }
        }
        return false;
    }
     static boolean check (int i, int j, char c) {
        int x = 0, y = 0, z = 0, d = 0;
        for (int k = 0; k < dotsToWin; k++) {
            if(j+k < size) {
                if (i-k >= 0) {
                    if ( map[i-k][j+k] == c ) { x++; }
                }
                if ( map[i][j+k] == c) { y++; }
            }
            if(i+k < size) {
                if ( map[i+k][j] == c ) { z++; }
                if (j+k < size) {
                    if ( map[i+k][j+k] == c ) { d++; }
                }
            }
        }
        return (x >= dotsToWin || z == dotsToWin || y == dotsToWin || d == dotsToWin);
    }
}
