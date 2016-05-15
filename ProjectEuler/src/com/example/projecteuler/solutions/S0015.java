package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

public class S0015 implements Solution {

    private int x = 0;
    private int y = 0;

    private int gridSize = 20;
    private long pathCount = 0;

    @Override
    public String getAnswer() {
        return Long.toString(originalSolution());
    }

    private long originalSolution() {

        takePath();

        return pathCount;
    }

    private void takePath() {
        Node node =  new Node(x, y);
        for (int i = 0; i <= 1; i++){
            pos(node);
            if (i == 0) {
                x++;
            }
            if (i == 1) {
                y++;
            }
            if (atEnd()) {
                pathCount++;
            } else takePath();
        }
    }

    private void pos(Node node) {
        // Set pos to node.
        x = node.xPos();
        y = node.yPos();
    }

    private boolean atEnd() {
        return (x == gridSize || y == gridSize);
    }

    private class Node {

        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int xPos() { return x; }
        int yPos() { return y; }
    }


}

