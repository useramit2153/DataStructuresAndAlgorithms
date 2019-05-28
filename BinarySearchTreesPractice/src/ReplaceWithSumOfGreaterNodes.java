
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
public class ReplaceWithSumOfGreaterNodes {
    
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
    
    public static int sum(BinaryTreeNode<Integer> root){
        // Write your code here
        if(root == null)
            return 0;
        int count = root.data;
        count += sum(root.left);
        count += sum(root.right);
        return count;
    }
    
    public static void replaceWithLargerNodesSumUtils(BinaryTreeNode<Integer> root, int sum) {
        
        if(root == null)
            return;
        
        int ls = sum + sum(root.right) + root.data;
        replaceWithLargerNodesSumUtils(root.left, ls);
        root.data = ls;
        System.out.print(ls + " ");
        replaceWithLargerNodesSumUtils(root.right, sum);
    }
    
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        // Write your code here
        replaceWithLargerNodesSumUtils(root, 0);
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        replaceWithLargerNodesSum(root);
    }
}
