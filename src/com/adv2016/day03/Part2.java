package com.adv2016.day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://adventofcode.com/2016/day/3
 * --- Day 3: Squares With Three Sides ---
 * --- Part Two ---
 * Now that you've helpfully marked up their design documents, it occurs to you that triangles are specified in
 * groups of three vertically. Each set of three numbers in a column specifies a triangle. Rows are unrelated.
 *
 * For example, given the following specification, numbers with the same hundreds digit would be part of the
 * same triangle:
 *
 * 101 301 501
 * 102 302 502
 * 103 303 503
 * 201 401 601
 * 202 402 602
 * 203 403 603
 * In your puzzle input, and instead reading by columns, how many of the listed triangles are possible?
 *
 * Your puzzle answer was 1921.
 */

public class Part2 {
    public static void main(String[] args) {

        try {
            File file = new File("resources/adv03.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int result = 0;

            while ((line = br.readLine()) != null) {
                String[][] lines = new String[3][3];
                for (int i = 0; i < 3; i++) {
                    String[] numbers = line.trim().split(" +");
                    for (int j = 0; j < 3; j++) {
                        lines[j][i] = numbers[j];
                    }
                    if (i < 2) line = br.readLine();
                }
                for (int i = 0; i < 3; i++) {
                    Integer[] numbers = new Integer[3];

                    for (int j = 0; j < 3; j++) {
                        numbers[j] = Integer.parseInt(lines[i][j]);
                    }
                    System.out.print(numbers[0] + " " + numbers[1] + " " + numbers[2]);
                    if ((numbers[0] + numbers[1] > numbers[2]) && (numbers[0] + numbers[2] > numbers[1]) && (numbers[1] + numbers[2] > numbers[0])) {
                        result++;
                        System.out.print(" ............. OK");
                    }
                    System.out.println();
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
