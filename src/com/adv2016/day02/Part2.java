package com.adv2016.day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://adventofcode.com/2016/day/2
 * --- Day 2: Bathroom Security ---
 * --- Part Two ---
 * You finally arrive at the bathroom (it's a several minute walk from the lobby so visitors can behold the many
 * fancy conference rooms and water coolers on this floor) and go to punch in the code. Much to your bladder's dismay,
 * the keypad is not at all like you imagined it. Instead, you are confronted with the result of hundreds of man-hours
 * of bathroom-keypad-design meetings:
 *
 * 1
 * 2 3 4
 * 5 6 7 8 9
 * A B C
 * D
 * You still start at "5" and stop when you're at an edge, but given the same instructions as above, the outcome is
 * very different:
 *
 * You start at "5" and don't move at all (up and left are both edges), ending at 5.
 * Continuing from "5", you move right twice and down three times (through "6", "7", "B", "D", "D"), ending at D.
 * Then, from "D", you move five more times (through "D", "B", "C", "C", "B"), ending at B.
 * Finally, after five more moves, you end at 3.
 * So, given the actual keypad layout, the code would be 5DB3.
 *
 * Using the same instructions in your puzzle input, what is the correct bathroom code?
 *
 * Your puzzle answer was A6B35.
 */

public class Part2 {
    public static final int[][] TABULKA = {
            {0, 0, 0, 0},
            {1, 3, 1, 1},  // 1
            {2, 6, 2, 3},  // 2
            {1, 7, 2, 4},  // 3
            {4, 8, 3, 4},
            {5, 5, 5, 6},
            {2, 10, 5, 7},
            {3, 11, 6, 8},
            {4, 12, 7, 9},
            {9, 9, 8, 9},
            {6, 10, 10, 11}, // A
            {7, 13, 10, 12}, // B
            {8, 12, 11, 12}, // C
            {11, 13, 13, 13}  // D
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
                        case 'U': {
                            break;
                        }
                        case 'D': {
                            index = 1;
                            break;
                        }
                        case 'L': {
                            index = 2;
                            break;
                        }
                        case 'R': {
                            index = 3;
                            break;
                        }
                    }
                    num = TABULKA[num][index];
                    System.out.println(num);
                }
                if (num == 10) {
                    result.append("A");
                } else if (num == 11) {
                    result.append("B");
                } else if (num == 12) {
                    result.append("C");
                } else if (num == 13) {
                    result.append("D");
                } else {
                    result.append(num);
                }
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
