import java.util.*;

class Solver {
    private static final int[] dx = {-1, 1, 0, 0}; // Movement in X direction (Up, Down)
    private static final int[] dy = {0, 0, -1, 1}; // Movement in Y direction (Left, Right)

    // BFS Algorithm to find the shortest path
    public static List<Node> bfs(Maze maze) {
        int rows = maze.maze.length;
        int cols = maze.maze[0].length;
        int startX = -1, startY = -1, endX = -1, endY = -1;

        // Find first open cell (0) as start position
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze.maze[i][j] == 0) {
                    startX = i;
                    startY = j;
                    break ; // Stop after finding the first open cell
                }
            }
            if (startX != -1)
                break; // Exit outer loop once start is found
        }

        // Find last open cell (0) as end position
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (maze.maze[i][j] == 0) {
                    endX = i;
                    endY = j;
                    break; // Stop after finding the last open cell
                }
            }
            if (endX != -1)
                break; // Exit outer loop once end is found
        }

        if (startX == -1 || endX == -1) { // No valid start or end found
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.maze.length][maze.maze[0].length];

        queue.add(new Node(startX, startY, null));  // Start BFS from the first open cell
        visited[startX][startY] = true; //start position won't be visited again.

        while (!queue.isEmpty()) {
            Node current = queue.poll(); //removes node from queue for processing

            // If we reach the destination, reconstruct the path
            if (current.x == endX && current.y == endY) {
                return reconstructPath(current);
            }

            // Explore all four possible directions (Up, Down, Left, Right)
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                // Move only if within bounds, not visited before, and not a wall (1)
                if (maze.isValidMove(newX, newY) && !visited[newX][newY]) {
                    queue.add(new Node(newX, newY, current));
                    visited[newX][newY] = true;
                }
            }
        }
        return new ArrayList<>(); // Return empty list if no path is found
    }

    // Reconstruct the shortest path by backtracking from the end node
    private static List<Node> reconstructPath(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent; // Move backwards through the path and parent reference
        }
        Collections.reverse(path); // Reverse to get path from start to end
        return path;
    }
}
