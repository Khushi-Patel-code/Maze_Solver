# Maze Solver

A Java-based Maze Solver using **Breadth-First Search (BFS)** to find the most efficient path in a maze. The program allows users to input a custom maze layout and dimensions, solving it by finding the optimal path from the start point to the goal. This project demonstrates the use of algorithms and data structures like queues and graphs to solve real-world problems.


## Features
- **Breadth-First Search (BFS)** algorithm to solve the maze
- User-defined maze dimensions (rows and columns)
- Custom input for maze layout with 0 for open paths and 1 for walls
- Displays the most efficient path from the start to the goal
- Console-based user interaction for easy input and output

## Prerequisites
To run this project, ensure you have the following:
- **Java JDK** (version 11 or higher)
- An IDE such as **IntelliJ IDEA**, **Eclipse**, or **VS Code** (or any Java-supported IDE)


## Steps to Run the Maze Solver

1. **Download the Project Files**  
   Download the project zip folder or clone the repository from GitHub:  
   `https://github.com/Khushi-Patel-code/Maze_Solver`.

2. **Ensure All Java Files Are in One Folder**  
   Confirm that all necessary Java files (**Main.java**, **Maze.java**, **Node.java**, **Solver.java**, etc.) are in the same folder inside your project.

3. **Open IntelliJ IDEA (or Preferred IDE)**  
   Open the downloaded project folder in your IDE.

4. **Install Java JDK (version 11 or higher)**  
   Make sure Java JDK 11 or higher is installed on your system. You can check your JDK version by running the command:  
   `java -version` in the terminal.

5. **Open the `Main.java` File**  
   In your IDE, navigate to and open the **Main.java** file, where the program execution begins.

6. **Run the Program**  
   Click the green **play button (▶️)** next to the `main` method or run the `Main.java` class to start the program.

7. **Input Maze Dimensions**  
   The program will prompt you to enter the **number of rows** and **number of columns** for the maze in the **Run** console. Enter valid integer values for these dimensions.

8. **Input the Maze Layout**  
   After entering the maze dimensions, you will be prompted to input the maze layout. For each row of the maze, input:
   - **0** for open paths.
   - **1** for walls.


9. **Maze Solving**  
After inputting the maze layout, the program will use **Breadth-First Search (BFS)** to solve the maze. It will display the most efficient path from the start to the goal.

## Technologies Used
- **Java** (JDK 11 or higher)
- **Algorithms**: Breadth-First Search (BFS)
- **Data Structures**: Queue, Graphs, Arrays


## Sample Output
```
Enter the number of Rows: 5 Enter the number of Columns: 5

Enter the maze grid row by row (0: Open Path, 1: Wall) 
Example for a 5x5 maze: 
Row 1: ◻️ ◻️ ◻️ ◻️ ◻️ (Enter 5 numbers separated by space) 
Row 2: ◻️ ◻️ ◻️ ◻️ ◻️ (Enter 5 numbers separated by space) 
Row 3: ◻️ ◻️ ◻️ ◻️ ◻️ (Enter 5 numbers separated by space) 
Row 4: ◻️ ◻️ ◻️ ◻️ ◻️ (Enter 5 numbers separated by space) 
Row 5: ◻️ ◻️ ◻️ ◻️ ◻️ (Enter 5 numbers separated by space)

Enter Row 1: 1 0 0 1 0 
Enter Row 2: 1 0 0 0 1 
Enter Row 3: 1 1 1 0 1 
Enter Row 4: 1 0 0 0 1 
Enter Row 5: 1 0 0 1 1

Shortest Path Found: 
🟥 🟩 ◻️ 🟥 ◻️
🟥 🟩 🟩 🟩 🟥
🟥 🟥 🟥 🟩 🟥
🟥 ◻️ 🟩 🟩 🟥
🟥 ◻️ 🟩 🟥 🟥
```


