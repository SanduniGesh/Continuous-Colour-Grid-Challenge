package com.eyepax.colorgridchallenge.model;

/**
 * The type Node.
 */
public class Node {

    private int id;
    private Position position;
    private char color;


    /**
     * Instantiates a new Node.
     *
     * @param id    the id
     * @param x     the x
     * @param y     the y
     * @param color the color
     */
    public Node(int id, int x, int y, char color) {
        this.id = id;
        this.position = new Position(x, y);
        this.color = color;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public char getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Node node = (Node) obj;

        if (color != node.color)
            return false;

        return position.equals(node.position);
    }

    /**
     * The hashCode method.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", position=" + position +
                ", color=" + color +
                '}';
    }
}
