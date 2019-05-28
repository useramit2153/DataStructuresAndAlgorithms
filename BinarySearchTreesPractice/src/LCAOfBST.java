
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
public class LCAOfBST {
    
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
    
    public static int lcaInBST(BinaryTreeNode <Integer> root , int a, int b){
        // Write your code here
        
        if(root == null)
            return -1;
        
        if(a == root.data || b == root.data)
            return root.data;
        
        int n1 = -1, n2 = -1;
            n1 = lcaInBST(root.left, a, b);
            n2 = lcaInBST(root.right, a, b);
        if(n1 == -1 && n2 == -1)
            return -1;
        else if(n1 != -1 && n2 == -1)
            return n1;
        else if(n1 == -1 && n2 != -1)
            return n2;
        else 
            return root.data;
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        int ans = lcaInBST(root, 12, 78);
        System.out.println(ans);
    }
    
}
