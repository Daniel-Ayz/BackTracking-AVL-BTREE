package Assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackingBTree<T extends Comparable<T>> extends BTree<T> {
	// For clarity only, this is the default ctor created implicitly.
	public BacktrackingBTree() {
		super();
	}

	public BacktrackingBTree(int order) {
		super(order);
	}

	//You are to implement the function Backtrack.
	public void Backtrack() {
		if(!insertedValues.isEmpty()) {
			T value=insertedValues.pop();
			recursiveBacktrack(root, value);
			if (root.numOfKeys == 0)
				root = null;
		}
    }

	private Node recursiveBacktrack(Node<T> current, T value){
		if (current.isLeaf()) {
			current.removeKey(value);
			backtrack.pop();
		}
		else {
			current = recursiveBacktrack(getNextNode(current, value), value);
			if (current != null) {
				BTreeActionType actionType = backtrack.pop();
				if (actionType == BTreeActionType.SPLIT) {
					T medianValue = insertedValues.pop();
					int medianIndex = current.indexOf(medianValue);
					Node<T> mergedNode = merge(current, medianIndex);
					if (current.numOfKeys == 0) {
						mergedNode.parent = current.parent;

						if (current == root)
							root = mergedNode;
						else
							mergedNode.parent.addChild(mergedNode);

						current = mergedNode;
					} else {
						mergedNode.parent = current;
						current.addChild(mergedNode);
						backtrack.pop();
					}
				}
			}
		}

		return current.parent;
	}

	public Node getNextNode(Node current, T value){
		int index=current.indexOf(value);
		if(index==-1){ //value in the child
			boolean found = false;
			int i = 0;
			while(i < current.getNumberOfKeys() && !found) {
				if(value.compareTo((T) current.getKey(i)) <= 0){
					found = true;
				} else {
					++i;
				}
			}
			return current.getChild(i);
		}
		else  //value in this node
			return null;
	}
	
	//Change the list returned to a list of integers answering the requirements
	public static List<Integer> BTreeBacktrackingCounterExample(){
		return Arrays.asList(1, 2, 3, 4, 5, 6);
	}
}
