package com.adv2016.day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://adventofcode.com/2016/day/3
 * --- Day 3: Squares With Three Sides ---
 * Now that you can think clearly, you move deeper into the labyrinth of hallways and office furniture that makes
 * up this part of Easter Bunny HQ. This must be a graphic design department; the walls are covered in specifications
 * for triangles.
 *
 * Or are they?
 *
 * The design document gives the side lengths of each triangle it describes, but... 5 10 25? Some of these aren't
 * triangles. You can't help but mark the impossible ones.
 *
 * In a valid triangle, the sum of any two sides must be larger than the remaining side. For example, the "triangle"
 * given above is impossible, because 5 + 10 is not larger than 25.
 *
 * In your puzzle input, how many of the listed triangles are possible?
 *
 * Your puzzle answer was 1050.
 */

public class Day03 {
    public static void main(String[] args) {

        try {
            File file = new File("resources/adv03.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int result = 0;

            while ((line = br.readLine()) != null) {
                String[] numbers = line.trim().split(" +");
                if (numbers.length != 3) System.out.println(" split se nepovedl   " + line);
                int num1 = Integer.parseInt(numbers[0]);
                int num2 = Integer.parseInt(numbers[1]);
                int num3 = Integer.parseInt(numbers[2]);

                if ((num1 + num2 > num3) && (num1 + num3 > num2) && (num2 + num3 > num1)) {
                    result++;
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
