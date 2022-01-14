package com.eyepax.colorgridchallenge.model;

import java.util.Objects;

/**
 * The type Position.
 */
public class Position {

    private int x;
    private int y;

    /**
     * Instantiates a new Position.
     *
     * @param x the x
     * @param y the y
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets upper.
     *
     * @return the upper
     */
    public Position getUpper() {
        return new Position(x, y-1);
    }

    /**
     * Gets bottom.
     *
     * @return the bottom
     */
    public Position getBottom() {
        return new Position(x, y+1);
    }

    /**
     * Gets left.
     *
     * @return the left
     */
    public Position getLeft() {
        return new Position(x-1, y);
    }

    /**
     * Gets right.
     *
     * @return the right
     */
    public Position getRight() {
        return new Position(x+1, y);
    }

    /**
     * The equals method.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Position position = (Position) obj;

        return x == position.x && y == position.y;
    }

    /**
     * The hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    /**
     * The toString method.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
