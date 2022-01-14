package com.eyepax.colorgridchallenge.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Color block.
 */
public class ColorBlock {

    private char color;

    private Set<Node> nodes;

    /**
     * Instantiates a new Color block.
     *
     * @param color the color
     */
    public ColorBlock(char color) {
        this.color = color;
        nodes = new HashSet<>();
    }

    /**
     * All nodes set.
     *
     * @return the set
     */
    public Set<Node> allNodes() {
        return nodes;
    }

    /**
     * All coords set.
     *
     * @return the set
     */
    public Set<Position> allCoords() {
        return nodes.stream().map(n -> n.getPosition()).collect(Collectors.toSet());
    }

    /**
     * Add node boolean.
     *
     * @param node the node
     * @return the boolean
     */
    public boolean addNode(Node node) {
        if (node != null && !nodes.contains(node)
                && node.getColor() == this.color) {
            return nodes.add(node);
        }
        return false;
    }

    /**
     * Has node boolean.
     *
     * @param node the node
     * @return the boolean
     */
    public boolean hasNode(Node node) {
        if(node == null)
            return false;
        return nodes.stream().anyMatch(n -> n.getId() == node.getId());
    }

    /**
     * Display.
     */
    public void display() {
        nodes.forEach(n -> System.out.print(n.toString()));
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return nodes.size();
    }
}
