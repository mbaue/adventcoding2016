package com.adv2016.day01;

public class Dimension {
    int horizontalDistance;
    int verticalDistance;

    public Dimension(int horizontalDistance, int verticalDistance) {
        this.horizontalDistance = horizontalDistance;
        this.verticalDistance = verticalDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dimension dimension = (Dimension) o;

        if (horizontalDistance != dimension.horizontalDistance) return false;
        return verticalDistance == dimension.verticalDistance;
    }

    @Override
    public int hashCode() {
        int result = horizontalDistance;
        result = 31 * result + verticalDistance;
        return result;
    }
}
