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
			T value=insertedValues.getFirst();
			boolean found=false;
			while(!backtrack.isEmpty() && !found){
				Node current=root;
				BTreeActionType actionType=backtrack.getLast();
				switch (actionType){
					case NONE -> {
						if(current.isLeaf()){
							current.removeKey(value);
						}
						else{
							current=getNextNode(current,value);
						}
					}
					case SPLIT -> {

					}
				}
			}
		}
    }

	public void merge(Node current){

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
