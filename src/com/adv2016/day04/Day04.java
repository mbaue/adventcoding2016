package com.adv2016.day04;

import com.adv2016.util.FrequencyTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * https://adventofcode.com/2016/day/4
 * --- Day 4: Security Through Obscurity ---
 * Finally, you come across an information kiosk with a list of rooms. Of course, the list is encrypted and full
 * of decoy data, but the instructions to decode the list are barely hidden nearby. Better remove the decoy data first.
 *
 * Each room consists of an encrypted name (lowercase letters separated by dashes) followed by a dash, a sector ID,
 * and a checksum in square brackets.
 *
 * A room is real (not a decoy) if the checksum is the five most common letters in the encrypted name, in order,
 * with ties broken by alphabetization. For example:
 *
 * aaaaa-bbb-z-y-x-123[abxyz] is a real room because the most common letters are a (5), b (3), and then a tie
 * between x, y, and z, which are listed alphabetically.
 * a-b-c-d-e-f-g-h-987[abcde] is a real room because although the letters are all tied (1 of each), the first
 * five are listed alphabetically.
 * not-a-real-room-404[oarel] is a real room.
 * totally-real-room-200[decoy] is not.
 * Of the real rooms from the list above, the sum of their sector IDs is 1514.
 *
 * What is the sum of the sector IDs of the real rooms?
 *
 * Your puzzle answer was 137896.
 */

public class Day04 {
    public static void main(String[] args) {

        try {
            File file = new File("resources/adv04.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int result = 0;

            while ((line = br.readLine()) != null) {
                int  pozicePomlcky = line.lastIndexOf('-');
                String pismena = line.substring(0, pozicePomlcky).replaceAll("-", "");
                int poziceZavorky = line.indexOf('[');
                int cislo = Integer.parseInt(line.substring(pozicePomlcky+1, poziceZavorky));
                String zavorka = line.substring(poziceZavorky+1, line.length()-1);
                String s = analyze(pismena);
                if (s.equals(zavorka)){
                    result = result + cislo;
                }
                System.out.println();
            }

            System.out.println("-------------------SOLUTION-------------------------------------");
            System.out.println("my score is = " + result);
            System.out.println("----------------------------------------------------------------");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String analyze(String pismena){
        FrequencyTable ft = new FrequencyTable();
        for (int i = 0; i < pismena.length(); i++){
            char ch = pismena.charAt(i);
            ft.addLetter(ch);
        }
        return ft.getFirstFive();
    }
}