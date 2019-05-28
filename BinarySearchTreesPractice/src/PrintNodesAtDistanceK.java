
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
public class PrintNodesAtDistanceK {
    
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
    
    private static void printNodesAtDepth(BinaryTreeNode<Integer> root, int k) {
        
        if(root == null)
            return;
        
        if(k == 0) {
            System.out.println(root.data);
            return;
        }
        //System.out.println(root.data);
        printNodesAtDepth(root.left, k - 1);
        printNodesAtDepth(root.right, k - 1);
    }
    
    private static int nodesAtDistanceKUtils(BinaryTreeNode<Integer> root, int node, int k) {
        if(root == null)
            return -1;
        if(root.data == node) {
            printNodesAtDepth(root, k);
            return 1;
        } else {
            int ld = nodesAtDistanceKUtils(root.left, node, k);
            int rd = nodesAtDistanceKUtils(root.right, node, k);
            //System.out.println(ld + " " + rd);
            if(ld != -1) {
                if(ld == k)
                    System.out.println(root.data);
                printNodesAtDepth(root.right, k - ld - 1);
                return ld + 1;
            } else if(rd != -1) {
                if(rd == k)
                    System.out.println(root.data);
                printNodesAtDepth(root.left, k - rd - 1);
                return rd + 1;
            } else {
                return -1;
            }
            //return -1;
        }
    }
    
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        // Write your code here
        nodesAtDistanceKUtils(root, node, k);
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        nodesAtDistanceK(root, 968, 1);
        //printNodesAtDepth(root, 3);
    }
}
