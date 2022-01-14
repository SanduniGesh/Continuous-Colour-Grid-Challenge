package com.eyepax.colorgridchallenge.service;

import com.eyepax.colorgridchallenge.model.ColorBlock;
import com.eyepax.colorgridchallenge.model.Node;
import com.eyepax.colorgridchallenge.model.Position;

import java.util.*;

public class ColorGridService {

    public static final char[] COLORS_ARRAY = {'B', 'G', 'Y', 'R', 'P', 'O'};

    private HashMap<Position, Node> grid;

    private int col;
    private int row;

    /**
     * Method for Getting Initialized Grid
     *
     * @param cols
     * @param rows
     */
    public void getInitializedGrid(int cols, int rows) {
        this.col = cols;
        this.row = rows;

        Random random = new Random();
        this.grid = new HashMap<>();
        for (int i = 0; i < cols*rows ; i++ ) {
            int x = i % cols;
            int y = (int) Math.floor(i/cols);
            this.grid.put(new Position(x, y), new Node(i, x, y, COLORS_ARRAY[random.nextInt(3)]));
        }
    }

    /**
     * Method for Getting Node
     *
     * @param x
     * @param y
     * @return
     */
    public Node getNode(int x, int y) {
        return this.grid.get(new Position(x, y));
    }

    /**
     * Method for Printing a Grid
     */
    public void printGrid() {
        for (int y = 0; y < row; y++) {
            for(int x = 0; x < col; x++) {
                if(x == this.col - 1 ) {
                    System.out.println(getNode(x, y).getColor());
                } else {
                    System.out.print(getNode(x, y).getColor() + ", ");
                }
            }
        }
    }

    /**
     * Method for Printing a Color Block
     *
     * @param colorBlock
     */
    public void printColorBlock(ColorBlock colorBlock) {
        for (int y = 0; y < row; y++) {
            for(int x = 0; x < col; x++) {
                Node n = getNode(x, y);
                char color = colorBlock.hasNode(n) ? '=' : n.getColor();
                if(x == this.col - 1 ) {
                    System.out.println(color);
                } else {
                    System.out.print(color + ", ");
                }
            }
        }
    }

    private List<Node> findSurroundNodes(Node n, ColorBlock block) {
        List<Node> nodes = new ArrayList<>();
        Position position = n.getPosition();
        Node north = this.grid.get(position.getUpper());
        if (north != null && north.getColor() == n.getColor() && !block.hasNode(north)) {
            nodes.add(north);
        }
        Node south = this.grid.get(position.getBottom());
        if (south != null && south.getColor() == n.getColor() && !block.hasNode(south)) {
            nodes.add(south);
        }
        Node east = this.grid.get(position.getLeft());
        if (east != null && east.getColor() == n.getColor() && !block.hasNode(east)) {
            nodes.add(east);
        }
        Node west = this.grid.get(position.getRight());
        if (west != null && west.getColor() == n.getColor() && !block.hasNode(west)) {
            nodes.add(west);
        }
        return nodes;
    }

    /**
     * Method for Getting Matching Block
     *
     * @param x
     * @param y
     * @return
     */
    public ColorBlock getMatchingBlock(int x, int y) {
        Position startingPosition = new Position(x, y);
        Node startingNode = this.grid.get(startingPosition);
        ColorBlock colorBlock = new ColorBlock(startingNode.getColor());
        colorBlock.addNode(startingNode);

        LinkedList<Node> nodesToVisit = new LinkedList<>();
        nodesToVisit.addAll(findSurroundNodes(startingNode, colorBlock));

        while(!nodesToVisit.isEmpty()) {
            Node nextNode = nodesToVisit.remove();
            colorBlock.addNode(nextNode);
            nodesToVisit.addAll(findSurroundNodes(nextNode, colorBlock));
        }

        return colorBlock;
    }

    /**
     * Method for Getting the Largest Color Block
     *
     * @return ColorBlock
     */
    public ColorBlock getLargestBlock() {
        Set<Position> positionsSet = new HashSet<>(this.grid.keySet());
        List<ColorBlock> allColorBlocks = new ArrayList<>();
        while(!positionsSet.isEmpty()) {
            Position position = positionsSet.iterator().next();
            ColorBlock newColorBlock = getMatchingBlock(position.getX(), position.getY());
            allColorBlocks.add(newColorBlock);
            positionsSet.removeAll(newColorBlock.allCoords());
        }

        Optional<ColorBlock> largestColorBlock =  allColorBlocks.stream().sorted(Comparator.comparingInt(ColorBlock::size).reversed()).findFirst();

        return largestColorBlock.isPresent() ? largestColorBlock.get() : null;
    }
}
