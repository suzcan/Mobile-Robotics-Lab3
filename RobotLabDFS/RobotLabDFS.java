
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

import lejos.nxt.*;
import lejos.robotics.navigation.*;

public class RobotLabDFS {

  public static void main(String[] args) {
    
    ///////////////////////////////
    // 1. Setting up the tree structure
    ///////////////////////////////

    // create new nodes e.g.
    Node S = new Node("S", 0, 0);
    Node A = new Node("A", 30, 0);
    Node B = new Node("B", 30, 40);
    Node C = new Node("C", 30, 80);
    Node D = new Node("D", 60, 0);
    Node E = new Node("E", 60, 80);
    Node G = new Node("G", 90, 40);

    // add children e.g.
    S.addChild(B);
    S.addChild(A);
    A.addChild(D);
    A.addChild(B);
    B.addChild(C);
    D.addChild(G);
    C.addChild(E);

    Node currentNode = S; //initialise currentNode to start node S
    ///////////////////////////////
    // 2. Doing DFS
    Stack<Node> stack = new Stack<Node>();
    stack.push(S);
    
    do {
	if(currentNode.equals(G)) {
	    break;
	} else {
	    if(currentNode.getChild() == null) {
	      int i = 0;
	      int j = 0;
		currentNode.explored = true;
		currentNode = currentNode.pred;
		Node printMe = stack.pop();
		LCD.drawString(printMe.name, i, j);
		j++;
	    }
	    else {
	      stack.push(currentNode.getChild());
	      currentNode = currentNode.getChild();
	    }
	}
    } while(currentNode.pred != null);
    
   /* int i = 0;
    int j = 0;
    while(!stack.empty()) {
	Node printMe = stack.pop();
	LCD.drawString(printMe.name, i, j);
	j++;
    }*/

    ///////////////////////////////

    Robot robot = new Robot();
    //////////////////////////////
    // 3. Making it work with a robot
    /////////////////////////////
    robot.moveTo(A);


  }//end class main
}//end RobotLabDFS
