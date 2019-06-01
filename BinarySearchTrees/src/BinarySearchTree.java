/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class BinarySearchTree {
    
    BinaryTreeNode<Integer> root;
    
    private BinaryTreeNode<Integer> insertDataHelper(BinaryTreeNode<Integer> root, int data) {
        if(root == null) {
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
            return newNode;
        }
        else {
            if(data < root.data)
                root.left = insertDataHelper(root.left, data);
            else
                root.right = insertDataHelper(root.right, data);
            return root;
        }
    }
    
    public void insertData(int data) {
        root = insertDataHelper(root, data);
    }
    
    public BinaryTreeNode<Integer> deleteDataHelper(int data, BinaryTreeNode<Integer> root) {
        if(root == null)
            return null;
        
        if(root.data == data) {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null && root.right != null)
                return root.right;
            else if(root.left != null && root.right == null)
                return root.left;
            else {
                BinaryTreeNode<Integer> temp = root.right;
                while(temp.left != null)
                    temp = temp.left;
                deleteDataHelper(temp.data, root);
                temp.left = root.left;
                temp.right = root.right;
                return temp;
            }
        }
        
        if(data < root.data)
            root.left = deleteDataHelper(data, root.left);
        else
            root.right = deleteDataHelper(data, root.right);
        return root;
    }
    
    public void deleteData(int data) {
        root = deleteDataHelper(data, root);
    }
    
    private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root) {
        if(root == null)
            return false;
        
        if(root.data == data)
            return true;
        
        if(data > root.data)
            return hasDataHelper(data, root.right);
        else
            return hasDataHelper(data, root.left);
    }
    
    public boolean search(int data) {
        return hasDataHelper(data, root);
    }
    
    public void printHelperTree(BinaryTreeNode<Integer> root) {
        if(root == null)
            return;
        
        String toBePrinted = root.data + ":";
        if(root.left != null)
            toBePrinted = toBePrinted + "L:" + root.left.data + ",";
        if(root.right != null)
            toBePrinted = toBePrinted + "R:" + root.right.data;
        System.out.println(toBePrinted);
        printHelperTree(root.left);
        printHelperTree(root.right);
    }
    
    public void printTree() {
        printHelperTree(root);
    }
    
}
