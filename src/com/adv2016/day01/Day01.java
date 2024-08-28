package com.adv2016.day01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://adventofcode.com/2016/day/1
 * --- Day 1: No Time for a Taxicab ---
 * Santa's sleigh uses a very high-precision clock to guide its movements, and the clock's oscillator is regulated by
 * stars. Unfortunately, the stars have been stolen... by the Easter Bunny. To save Christmas, Santa needs you to
 * retrieve all fifty stars by December 25th.
 *
 * Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second
 * puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
 *
 * You're airdropped near Easter Bunny Headquarters in a city somewhere. "Near", unfortunately, is as close as you can
 * get - the instructions on the Easter Bunny Recruiting Document the Elves intercepted start here, and nobody had time
 * to work them out further.
 *
 * The Document indicates that you should start at the given coordinates (where you just landed) and face North. Then,
 * follow the provided sequence: either turn left (L) or right (R) 90 degrees, then walk forward the given number
 * of blocks, ending at a new intersection.
 *
 * There's no time to follow such ridiculous instructions on foot, though, so you take a moment and work out the
 * destination. Given that you can only walk on the street grid of the city, how far is the shortest path to the
 * destination?
 *
 * For example:
 *
 * Following R2, L3 leaves you 2 blocks East and 3 blocks North, or 5 blocks away.
 * R2, R2, R2 leaves you 2 blocks due South of your starting position, which is 2 blocks away.
 * R5, L5, R5, R3 leaves you 12 blocks away.
 * How many blocks away is Easter Bunny HQ?
 *
 * Your puzzle answer was 288.
 */
public class Day01 {

    public static void main(String[] args) {

        try {
            File file = new File("resources/adv01.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            int facing = 0;
            int verticalDistance = 0;
            int horizontalDistance = 0;

            String[] instructions = line.split(", ");
            for (String s : instructions) {
                char ch = s.trim().charAt(0);
                int num = Integer.parseInt(s.trim().substring(1));
                System.out.println(ch);
                System.out.println(num);

                switch (ch) {
                    case 'L': {
                        facing = (facing + 3) % 4;
                        break;
                    }
                    case 'R': {
                        facing = (facing + 1) % 4;
                        break;
                    }
                }
                switch (facing) {
                    case 0:
                        verticalDistance = verticalDistance + num;
                        break;
                    case 1:
                        horizontalDistance = horizontalDistance + num;
                        break;
                    case 2:
                        verticalDistance = verticalDistance - num;
                        break;
                    case 3:
                        horizontalDistance = horizontalDistance - num;
                        break;
                }
                System.out.println("horiz=" + horizontalDistance);
                System.out.println("verti=" + verticalDistance);
                System.out.println();
            }


            System.out.println("-------------------SOLUTION-------------------------------------");
            System.out.println("my score is = " + (Math.abs(horizontalDistance) + Math.abs(verticalDistance)));
            System.out.println("----------------------------------------------------------------");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

