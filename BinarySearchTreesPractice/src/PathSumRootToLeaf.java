
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class PathSumRootToLeaf {
    
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    
    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
        System.out.println("Enter Root Data: ");
        int rootData = s.nextInt();
        if(rootData == -1)
            return null;
        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.add(root);
        
        while(!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodes.poll();
            System.out.println("Enter left child of " + front.data);
            int leftChildData = s.nextInt();
            if(leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                pendingNodes.add(leftChild);
                front.left = leftChild;
            }
            System.out.println("Enter right child of " + front.data);
            int rightChildData = s.nextInt();
            if(rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                pendingNodes.add(rightChild);
                front.right = rightChild;
            }
        }
        return root;
    }
    
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String output) {
        // Write your code here
        if(root == null)
            return;
        
        if(root.left == null && root.right == null) {
            if(root.data == k) {
                output = output + root.data;
                System.out.println(output);
            }
            return;
        }
        
        if(root.data < k) {
            output = output + root.data + " ";
            rootToLeafPathsSumToK(root.left,  k - root.data, output);
            rootToLeafPathsSumToK(root.right, k - root.data, output);
        }
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        rootToLeafPathsSumToK(root, 13, "");
    }
}
