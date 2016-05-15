package com.example.projecteuler.solutions;

import com.example.projecteuler.Solution;

public class S0015 implements Solution {

    private int x = 0;
    private int y = 0;

    private int gridSize = 20;
    private long pathCount = 0;

    @Override
    public String getAnswer() {
        return Long.toString(improvedSolution());
    }

    private long improvedSolution() {

        // Original solution was a brute force method. Here's a more mathematical approach.

        int nodeCount = gridSize + 1;

        // Create array and add like pascal triangles.
        long[][] arr = new long[nodeCount][nodeCount];
        // Populate first row.
        for (int i = 0; i < nodeCount; i++) {
            arr[i][0] = 1;
        }
        // Fill out other rows.
        for (int j = 1; j < nodeCount; j++) {
            arr[0][j] = 1;
            for (int i = 1; i < nodeCount; i++){
                arr[i][j] = arr[i -1][j] + arr[i][j -1];
            }
        }

        pathCount = arr[nodeCount -1][nodeCount -1];

        return pathCount;
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

