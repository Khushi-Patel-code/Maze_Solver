import java.util.*;

class Maze {
    public int[][] maze;
    private final int rows, cols;

    public Maze(int[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
    }

    // Checks if (x, y) is within maze boundaries and on an open path (0)
    public boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols && maze[x][y] == 0;
    }

    // Prints the maze with the solution path marked
    public void printSolution(List<Node> path) {
        String[][] display = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 1) {
                    display[i][j] = "🟥";  // Walls
                } else {
                    display[i][j] = "◻️";  // Open path (not part of the solution)
                }
            }
        }

        // Mark the shortest path in the maze
        for (Node node : path) {
            display[node.x][node.y] = "🟩" ; // Solution Path
        }

        // Print the maze with spacing for better readability
        for (String[] row : display) {
            for (String s : row) {
                System.out.printf("%-4s", s);   // Adding space between symbols
            }
            System.out.println();  // Move to the next line after each row
        }
    }
}