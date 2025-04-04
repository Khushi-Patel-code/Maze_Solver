    public class Node {
        int x , y; //Coordinates of the graph
        Node parent; //tracks the path using prev element- backtracking

        //Constructor for the Node class
        public Node(int x, int y, Node parent){
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
    }
