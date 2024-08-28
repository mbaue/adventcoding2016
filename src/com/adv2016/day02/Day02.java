package com.adv2016.day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://adventofcode.com/2016/day/2
 * --- Day 2: Bathroom Security ---
 * You arrive at Easter Bunny Headquarters under cover of darkness. However, you left in such a rush that you forgot to use the bathroom! Fancy office buildings like this one usually have keypad locks on their bathrooms, so you search the front desk for the code.
 *
 * "In order to improve security," the document you find says, "bathroom codes will no longer be written down. Instead, please memorize and follow the procedure below to access the bathrooms."
 *
 * The document goes on to explain that each button to be pressed can be found by starting on the previous button and moving to adjacent buttons on the keypad: U moves up, D moves down, L moves left, and R moves right. Each line of instructions corresponds to one button, starting at the previous button (or, for the first line, the "5" button); press whatever button you're on at the end of each line. If a move doesn't lead to a button, ignore it.
 *
 * You can't hold it much longer, so you decide to figure out the code as you walk to the bathroom. You picture a keypad like this:
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * Suppose your instructions are:
 *
 * ULL
 * RRDDD
 * LURDL
 * UUUUD
 * You start at "5" and move up (to "2"), left (to "1"), and left (you can't, and stay on "1"), so the first button is 1.
 * Starting from the previous button ("1"), you move right twice (to "3") and then down three times (stopping at "9" after two moves and ignoring the third), ending up with 9.
 * Continuing from "9", you move left, up, right, down, and left, ending with 8.
 * Finally, you move up four times (stopping at "2"), then down once, ending with 5.
 * So, in this example, the bathroom code is 1985.
 *
 * Your puzzle input is the instructions from the document you found at the front desk. What is the bathroom code?
 *
 * Your puzzle answer was 74921.
 */
public class Day02 {

    public static final int[][] TABULKA = {
            {0, 0, 0, 0},
            {1, 4, 1, 2},  // 1
            {2, 5, 1, 3},  // 2
            {3, 6, 2, 3},  // 3
            {1,7,4,5},
            {2,8,4,6},
            {3,9,5,6},
            {4,7,7,8},
            {5,8,7,9},
            {6,9,8,9}
             };

    public static void main(String[] args) {

        try {
            File file = new File("resources/adv02.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder result = new StringBuilder();
            int startNum = 5;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                int num = startNum;
                for (char ch : line.toCharArray()) {
                    int index = 0;
                    switch (ch) {
                        case 'U':{
                            break;
                        }
                        case 'D':{
                            index = 1;
                            break;
                        }
                        case 'L':{
                            index = 2;
                            break;
                        }
                        case 'R':{
                            index = 3;
                            break;
                        }
                    }
                    num = TABULKA[num][index];
                    System.out.println(num);
                }
                result.append(num);
            }

            System.out.println("-------------------SOLUTION-------------------------------------");
            System.out.println("my score is = " + result);
            System.out.println("----------------------------------------------------------------");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
