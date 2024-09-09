package com.adv2016.day04;

//import com.adv2016.util.FrequencyTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *  https://adventofcode.com/2016/day/4
 *  --- Day 4: Security Through Obscurity ---
 *  --- Part Two ---
 * With all the decoy data out of the way, it's time to decrypt this list and get moving.
 *
 * The room names are encrypted by a state-of-the-art shift cipher, which is nearly unbreakable without the right
 * software. However, the information kiosk designers at Easter Bunny HQ were not expecting to deal with a
 * master cryptographer like yourself.
 *
 * To decrypt a room name, rotate each letter forward through the alphabet a number of times equal to the room's
 * sector ID. A becomes B, B becomes C, Z becomes A, and so on. Dashes become spaces.
 *
 * For example, the real name for qzmt-zixmtkozy-ivhz-343 is very encrypted name.
 *
 * What is the sector ID of the room where North Pole objects are stored?
 *
 * Your puzzle answer was 501.
 */

public class Part2 {
    public static void main(String[] args) {

        try {
            File file = new File("resources/adv04.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
           // FrequencyTable ft = new FrequencyTable();
            int result = 0;

            while ((line = br.readLine()) != null) {
                int  pozicePomlcky = line.lastIndexOf('-');
                String text = line.substring(0, pozicePomlcky).replaceAll("-", " ");
                int poziceZavorky = line.indexOf('[');
                int cislo = Integer.parseInt(line.substring(pozicePomlcky+1, poziceZavorky));
                int posun = cislo % 26;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < text.length(); i++) {
                    char ch = text.charAt(i);
                    if (ch == ' ') {
                        sb.append(ch);
                    } else {
                        if ('z' - ch < posun) {
                            sb.append((char) ('a' + posun - ('z'-ch) -1));
                        } else {
                            sb.append((char) (ch + posun));
                        }
                    }
                }
                if (sb.indexOf("north")>=0) {
                    System.out.println(sb);
                    System.out.println(line);
                    System.out.println(cislo);
                    result = cislo;
                }
            }

            System.out.println("-------------------SOLUTION-------------------------------------");
            System.out.println("my score is = " + result );
            System.out.println("----------------------------------------------------------------");
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
