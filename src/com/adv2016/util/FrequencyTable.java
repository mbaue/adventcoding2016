package com.adv2016.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrequencyTable {

    List<Letter> l ;

    public FrequencyTable() {
        this.l = new ArrayList<>();
    }

    public  void addLetter(char ch) {
        if (contains(ch)) {
            int newFrequency = getLetter(ch).getFrequency() +1;
            getLetter(ch).setFrequency(newFrequency);
        } else {
            l.add(new Letter(ch, 1));
        }
    }


    boolean contains(char ch) {
        for (Letter letter : this.l) {
             if (letter.getCharacter() == ch){

                 return true;
             }
        }
        return false;
    }

    Letter getLetter(char ch) {
        for (Letter letter : this.l){
            if (letter.getCharacter() == ch) {
                return letter;
            }
        }
        return null;
    }

    void sortTable() {
        Collections.sort(l);
    }

    public String getFirstFive (){
        Collections.sort(l);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <5; i++) {
            sb.append(l.get(i).getCharacter());
        }
        return sb.toString();
    }
}