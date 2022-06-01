package Assignment4;

public class Main {
    public static void main(String[] args){
        BacktrackingAVL tree=new BacktrackingAVL();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        System.out.println("----------------");
        tree.printTree();
        System.out.println("----------------inserted 5:");
        tree.insert(5);
        tree.printTree();
        System.out.println("----------------backtracked the insert:");
        tree.Backtrack();
        tree.printTree();
        System.out.println("----------------");

        tree=new BacktrackingAVL();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        System.out.println("----------------before 6:");
        tree.printTree();
        System.out.println("----------------inserted 6:");
        tree.insert(6);
        tree.printTree();
        System.out.println("----------------backtracked the insert:");
        tree.Backtrack();
        tree.printTree();
        System.out.println("----------------");

        AVLTree.Node n2=tree.root;
        AVLTree.Node n1=tree.root.left;
        AVLTree.Node n4=tree.root.right;
        AVLTree.Node n5=tree.root.right.right;
        AVLTree.Node n3=tree.root.right.left;

        System.out.println(n1.value==1);
        System.out.println(n2.value==2);
        System.out.println(n3.value==3);
        System.out.println(n4.value==4);
        System.out.println(n5.value==5);

        System.out.println(n3.parent==n4);
        System.out.println(n5.parent==n4);
        System.out.println(n4.parent==n2);
        System.out.println(n1.parent==n2);
        System.out.println(n2.parent==null);

        System.out.println(n3.left==null);
        System.out.println(n3.right==null);
        System.out.println(n5.left==null);
        System.out.println(n5.right==null);
        System.out.println(n1.left==null);
        System.out.println(n1.right==null);
    }
}
