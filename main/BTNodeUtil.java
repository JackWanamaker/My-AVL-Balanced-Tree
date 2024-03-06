package edu.ithaca.dragon.datastructures.tree;

public class BTNodeUtil{

    /**
     * @return the total count of all nodes connected to root (including root)  
     */
    
    public static <T extends Comparable<T>> int nodeCount(BTNode<T> root){
        if (root == null){
            return 0;
        }
        else {
            int tot = nodeCount(root.getLeft());
            tot = tot + nodeCount(root.getRight());
            return tot + 1;
        }
    }

    /**
     * @return true if itemToFind is in any node connected to root, false otherwise 
     */
    public static <T extends Comparable<T>> boolean contains(BTNode<T> root, T itemToFind){
        if (root == null){
            return false;
        }
        else{
            boolean itemFound = contains(root.getLeft(), itemToFind);
            if (itemFound){
                return true;
            }
            itemFound = contains(root.getRight(), itemToFind);
            if (itemFound){
                return true;
            }
            if (root.getItem().equals(itemToFind)){
                return true;
            }
            else{
                return false;
            }
        }
    }

    /**
     * makes a string with the root, then the subtree left of root, then the subtree right of root
     */
    public static <T extends Comparable<T>> String preOrderString(BTNode<T> root){
        //already implemented for you
        if (root == null){
            return "";
        }
        else {
            return root.getItem().toString() + ", " + preOrderString(root.getLeft()) + preOrderString(root.getRight()); 
        }
    }

    /**
     * makes a string with the subtree left of root, the subtree right of root, then root
     */
    public static <T extends Comparable<T>> String postOrderString(BTNode<T> root){
        if (root == null){
            return "";
        }
        else {
            return postOrderString(root.getLeft()) + postOrderString(root.getRight()) + root.getItem().toString() + ", ";
        }
    }

    /**
     * makes a string with the the subtree left of root, then root, then the subtree right of root
     */
    public static <T extends Comparable<T>> String inOrderString(BTNode<T> root){
        if (root == null){
            return "";
        }
        else {
            return inOrderString(root.getLeft()) + root.getItem().toString() + ", " + inOrderString(root.getRight());
        }
    }

    /**
     * @return the height of the given tree as an int
     * height is counted as the longest single chain of edges between the root and any ancestor
     * the height of a tree with a single node is then 0 (no edges)
     * the hieght of an empty tree (no nodes) is -1  
     */
    public static <T extends Comparable <T>> int height(BTNode<T> root){
        if (root == null){
            return -1;
        }
        else {
            int leftTotal = height(root.getLeft());
            int rightTotal = height(root.getRight());
            
            if(leftTotal >= rightTotal){
                return leftTotal + 1;
            }
            else{
                return rightTotal + 1;
            }
        }
    }

    
}
