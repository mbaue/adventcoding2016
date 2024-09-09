package com.adv2016.util;

public class Letter implements Comparable<Letter> {
    char character;
    int frequency;

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Letter(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Letter letter) {
        if (this.getFrequency()==letter.getFrequency()) {
            return this.getCharacter() - letter.getCharacter();
        }
        return (letter.getFrequency() - this.getFrequency());
    }

    @Override
    public String toString() {
        return "Letter{" +
                "character=" + character +
                ", frequency=" + frequency +
                '}';
    }
}

