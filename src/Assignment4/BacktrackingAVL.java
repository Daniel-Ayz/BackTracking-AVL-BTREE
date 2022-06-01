package Assignment4;

import java.util.Arrays;
import java.util.List;

public class BacktrackingAVL extends AVLTree {
    // For clarity only, this is the default ctor created implicitly.
    public BacktrackingAVL() {
        super();
    }

	//You are to implement the function Backtrack.
    public void Backtrack() {
        if(!inserted.isEmpty() && root!=null){
            root=Backtrack(root,inserted.pop());
        }
    }

    private Node Backtrack(Node current, int value) {
//        if(current.value==value){
//                root=null;
//            } manage in the backtrack() func
//         && !inserted.isEmpty()
        if (!backtrack.isEmpty()) {
            ImbalanceCases status = backtrack.pop();

            switch (status) {
                case LEFT_LEFT:
                    current = rotateLeft(current);
                    break;
                case LEFT_RIGHT:
                    current = rotateLeft(current);
                    current.left = rotateRight(current.left);
                    break;
                case RIGHT_RIGHT:
                    current = rotateRight(current);
                    break;
                case RIGHT_LEFT:
                    current = rotateRight(current);
                    current.right = rotateLeft(current.right);
                    break;
            }

            if (current.value == value)
                return null;
            else if (current.value < value) {
                current.right = Backtrack(current.right,value);
//                current.right.parent = current;
            } else {
                current.left = Backtrack(current.left,value);
//                current.left.parent = current;
            }

            current.updateHeight();
            return current;
        }

        return null;
    }

    
    //Change the list returned to a list of integers answering the requirements
    public static List<Integer> AVLTreeBacktrackingCounterExample() {
        return Arrays.asList(2,1,4,3,5);
    }
    
    public int Select(int index) {
        // You should remove the next two lines, after double-checking that the signature is valid!
        IntegrityStatement.signature(); // Reminder!
        throw new UnsupportedOperationException("You should implement this");
    }
    
    public int Rank(int value) {
        // You should remove the next two lines, after double-checking that the signature is valid!
        IntegrityStatement.signature(); // Reminder!
        throw new UnsupportedOperationException("You should implement this");
    }
}
