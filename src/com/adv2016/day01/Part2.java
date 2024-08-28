package com.adv2016.day01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *  https://adventofcode.com/2016/day/1
 *  --- Day 1: No Time for a Taxicab ---
 *  --- Part Two ---
 * Then, you notice the instructions continue on the back of the Recruiting Document. Easter Bunny HQ is actually
 * at the first location you visit twice.
 *
 * For example, if your instructions are R8, R4, R4, R8, the first location you visit twice is 4 blocks away, due East.
 *
 * How many blocks away is the first location you visit twice?
 *
 * Your puzzle answer was 111.
 */
public class Part2 {
    public static Set<Dimension> visited;

    public static void main(String[] args) {

        try {
            int result = -1;
            visited = new HashSet<>();
            Dimension x = new Dimension(0, 0);
            visited.add(x);
            File file = new File("resources/adv01.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            int facing = 0;
            int actualVerticalDist = 0;
            int actualHorizontalDist = 0;
            int verticalDist = 0;
            int horizontalDist = 0;

            String[] instructions = line.split(", ");
            outer:
            for (String s : instructions) {
                System.out.println(s);
                char ch = s.trim().charAt(0);
                int num = Integer.parseInt(s.trim().substring(1));

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
                        verticalDist = verticalDist + num;
                        break;
                    case 1:
                        horizontalDist = horizontalDist + num;
                        break;
                    case 2:
                        verticalDist = verticalDist - num;
                        break;
                    case 3:
                        horizontalDist = horizontalDist - num;
                        break;
                }

                if (actualHorizontalDist == horizontalDist) {
                    int start;
                    int cil;
                    int step;
                    if (verticalDist > actualVerticalDist) {
                        start = actualVerticalDist + 1;
                        cil = verticalDist;
                        step = 1;
                        for (int i = start; i <= cil; i = i + step) {
                            Dimension d = new Dimension(horizontalDist, i);
                            if (!visited.add(d)) {
                                System.out.println("===1=========================================" + horizontalDist + ", " + i);
                                result = Math.abs(horizontalDist) + Math.abs(i);
                                break outer;
                            }
                        }
                    } else {
                        start = actualVerticalDist - 1;
                        cil = verticalDist;
                        step = -1;
                        for (int i = start; i >= cil; i = i + step) {
                            Dimension d = new Dimension(horizontalDist, i);
                            if (!visited.add(d)) {
                                System.out.println("====2=========================================" + horizontalDist + ", " + i);
                                result = Math.abs(horizontalDist) + Math.abs(i);
                                break outer;
                            }
                        }
                    }
                } else {
                    int start;
                    int cil;
                    int step;
                    if (horizontalDist > actualHorizontalDist) {
                        start = actualHorizontalDist + 1;
                        cil = horizontalDist;
                        step = 1;
                        for (int i = start; i <= cil; i = i + step) {
                            Dimension d = new Dimension(i, verticalDist);
                            if (!visited.add(d)) {
                                System.out.println("====3================== to je ono ============================" + i + ", " + verticalDist);
                                result = Math.abs(verticalDist) + Math.abs(i);
                                break outer;
                            }
                        }
                    } else {
                        start = actualHorizontalDist - 1;
                        cil = horizontalDist;
                        step = -1;
                        for (int i = start; i >= cil; i = i + step) {
                            Dimension d = new Dimension(i, verticalDist);
                            if (!visited.add(d)) {
                                System.out.println("====4================== to je ono ============================" + i + ", " + verticalDist);
                                result = Math.abs(verticalDist) + Math.abs(i);
                                break outer;
                            }
                        }
                    }
                }
                actualHorizontalDist = horizontalDist;
                actualVerticalDist = verticalDist;
                System.out.println();
            }


            System.out.println("----------------------------------------------------------------");
            System.out.println("my score is = " + result);
            System.out.println("-------------------SOLUTION-------------------------------------");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}