package edu.ithaca.dragon.datastructures.tree;

import java.util.LinkedList;

import edu.ithaca.dragon.datastructures.PriorityQueue.PrioritizedItems;

public class BSTNodeUtil {

    /**
     * @pre root must be a node of a valid binary search tree
     * @pre the BST from root must not already contain item 
     * @post BST from root will be mutatated to contain a new node with the given item
     * @throws IllegalArgumentException if root is null or the BST already contains item
     */
    public static <T extends Comparable<T>> void bstAddTail(BTNode<T> root, T item, boolean notNull){
        BTNode leftSide = root.getLeft();
        BTNode rightSide = root.getRight();
        if (root.getItem().compareTo(item) == 1 && root.getLeft() == null){
            leftSide = new BTNode<T>(item);
            root.setLeft(leftSide);
        }
        else if (root.getItem().compareTo(item) == -1 && root.getRight() == null){
            rightSide = new BTNode<T>(item);
            root.setRight(rightSide);
        }
        else if (leftSide != null && leftSide.getItem().equals(item)){
            throw new IllegalArgumentException();
        }
        else if (rightSide != null && rightSide.getItem().equals(item)){
            throw new IllegalArgumentException();
        }
        else{
            if (root.getItem().compareTo(item) == 1){
                bstAddTail(root.getLeft(), item, true);
            }
            else{
                bstAddTail(root.getRight(), item, true);
            }
        }
    }

    public static <T extends Comparable<T>> void bstAddTail(BTNode<T> root, T item){
        if (root == null || root.getItem().equals(item)){
            throw new IllegalArgumentException();
        }
        bstAddTail(root, item, true);
    }

    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @pre the bst from root must not already contain item 
     * @return  the root of a BST which contains a new node the given item
     * @post original BST might be modified to contain a new node with the given item
     * @throws IllegalArgumentException if the bst already contains item
     */
    public static <T extends Comparable<T>> BTNode<T> bstAdd(BTNode<T> root, T item){
        if (root == null){
            root = new BTNode<T>(item);
            return root;
        }
        else if (root.getItem().equals(item)){
            throw new IllegalArgumentException();
        }
        else{
            if (root.getItem().compareTo(item) == 1){
                BTNode LeftSide =  bstAdd(root.getLeft(), item);
                root.setLeft(LeftSide);
                return root;
            }
            else{
                BTNode RightSide = bstAdd(root.getRight(), item);
                root.setRight(RightSide);
                return root;
            }
        }
    }

    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @return true if the item is found in the bst, false otherwise 
     */
    public static <T extends Comparable<T>> boolean bstContains(BTNode<T> root, T item){
        if (root == null){
            return false;
        }
        else if (root.getItem().equals(item)){
            return true;
        }
        else{
            if (root.getItem().compareTo(item) == 1){
                return bstContains(root.getLeft(), item);
            }
            else{
                return bstContains(root.getRight(), item);
            }
        }
    }

    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @return the item of equal priority already in the bst, or null
     */
    public static <T extends Comparable<T>> BTNode<PrioritizedItems<LinkedList<T>>> bstFind(BTNode<PrioritizedItems<LinkedList<T>>> root, PrioritizedItems<LinkedList<T>> item){
        if (root == null){
            return null;
        }
        else if (root.getItem().compareTo(item) == 0){
            return root;
        }
        else{
            if (root.getItem().compareTo(item) == 1){
                return bstFind(root.getLeft(), item);
            }
            else{
                return bstFind(root.getRight(), item);
            }
        }
    }

    /**
    * @pre root must be a node of a valid binary search tree, or null 
    * @return  the minimum item from the BST, or null if there are no items
    */
    public static <T extends Comparable<T>> T bstFindMin(BTNode<T> root){
        if (root == null){
            return null;
        }
        else{
            T leftSide = bstFindMin(root.getLeft());
            if (leftSide != null){
                if (leftSide.compareTo(root.getItem()) == -1){
                    return leftSide;
                }
            }
            return root.getItem();
        }
    }

    /**
    * @pre root must be a node of a valid binary search tree, or null 
    * @return  the root of a BST with the minimum removed, or null if empty
    * @post original BST might be modified to have the minimum removed
    */
    public static <T extends Comparable<T>> BTNode<T> bstRemoveMin(BTNode<T> root){
        /*if (root == null || root.getLeft() == null){
            return null;
        }*/
        if (root == null){
            return null;
        }
        else if (root.getLeft() == null && root.getRight() != null){
            return root.getRight();
        }
        else if (root.getLeft() == null){
            return null;
        }
        else if (root.getLeft().getLeft() == null){
            root.setLeft(null);
            return root;
        }
        else{
            BTNode leftSide = bstRemoveMin(root.getLeft());
            root.setLeft(leftSide);
            return root;
        }
    }
}
