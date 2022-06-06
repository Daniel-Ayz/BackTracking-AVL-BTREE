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
            current.updateSize();
            return current;
        }

        return null;
    }

    
    //Change the list returned to a list of integers answering the requirements
    public static List<Integer> AVLTreeBacktrackingCounterExample() {
        return Arrays.asList(2,1,4,3,5);
    }
    
    public int Select(int index) {
        return Select(root,index);
    }

    private int Select(Node node,int index) {
        if(node==null)
            return -1;
        int curr_rank = node.left==null ? 1 : node.left.size + 1;
        if (curr_rank == index)
            return node.value;
        else if (index<curr_rank)
            return Select(node.left, index);
        else
            return Select(node.right, index - curr_rank);
    }

    public int Rank(int value) {
        return Rank(root,value);
    }

    private int Rank(Node node,int val){
        if(node==null)
            return 0;
        if (node.value == val)
            return node.left==null ? 0 : node.left.size ;
        else if( node.value > val)
            return Rank(node.left, val);
        else
            return Rank(node.right, val) + (node.left==null ? 0 : node.left.size) + 1;
    }
}
