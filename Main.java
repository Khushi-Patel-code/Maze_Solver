import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //get maze dimensions from the user and validate using function
        int rows = getValidIntegerInput(scan, "Enter the number of Rows: ");
        int cols = getValidIntegerInput(scan, "Enter the number of Columns: ");

        //Initializing the maze grid
        int[][] mazeGrid = new int[rows][cols];

        // Displaying a blank grid template for user guidance
        System.out.println("\nEnter the maze grid row by row (0: Open Path, 1: Wall)");
        System.out.println("Example for a " + rows + "x" + cols + " maze:");

        for (int i = 0; i < rows; i++) {
            System.out.print("Row " + (i + 1) + ": ");

            // Print the correct number of placeholders for the row
            for (int j = 0; j < cols; j++) {
                System.out.print("◻️ ");  // Placeholder for Open Path (0)
            }

            System.out.println("(Enter " + cols + " numbers separated by space)");  // Instruction
        }
        System.out.println();

        // User input Validation
        for (int i = 0; i < rows; i++) {
            while (true) {  // Loop until valid input is given
                System.out.print("Enter Row " + (i + 1) + ": ");
                String[] input = scan.nextLine().trim().split("\\s+"); // Read and split user input into an array, ensuring no extra spaces at end.

                if (input.length != cols) {
                    System.out.println("❌ Please enter exactly " + cols + " numbers separated by spaces.");
                    continue;  // Ask for input again
                }

                boolean isValid = true;
                for (int j = 0; j < cols; j++) {
                    try {
                        int value = Integer.parseInt(input[j]);
                        if (value != 0 && value != 1) {
                            isValid = false;
                            break;
                        }
                        mazeGrid[i][j] = value;
                    } catch (NumberFormatException e) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    break;  // Move to the next row if input is valid
                } else {
                    System.out.println("❌ Invalid input! Only enter 0 (Open Path) or 1 (Wall). Try again.");
                }
            }
        }

        // Create maze instance
        Maze maze = new Maze(mazeGrid);
        List<Node> shortestPath = Solver.bfs(maze);

        if (!shortestPath.isEmpty()) {
            System.out.println("Shortest Path Found: ");
            maze.printSolution(shortestPath);
        } else {
            System.out.println("No path found!");
        }
    }

    // Method to get a valid positive integer from the user
    private static int getValidIntegerInput(Scanner scan, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            String input = scan.nextLine().trim();  // trims the trailing spaces

            try {
                value = Integer.parseInt(input); // Converts input string to integer
                if (value > 0) {
                    break; // Ensuring the input is a positive number
                } else{
                    System.out.println("❌ Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
            }
        }
        return value;
    }
}