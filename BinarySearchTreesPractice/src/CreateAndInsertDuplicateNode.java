
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
public class CreateAndInsertDuplicateNode {
    
    public static BinaryTreeNode<Integer> root;
    
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
    
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
	// Write your code here
        if(root == null)
            return;
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
        newNode.left = root.left;
        root.left = newNode;
        
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
    }
    
    public static void printLevelWise(BinaryTreeNode<Integer> root){
        // Write your code here
        int count = 0;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        Queue<BinaryTreeNode<Integer>> q1 = new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);
        count ++;
        while(count > 0) {
            count = 0;
            while(!q.isEmpty()) {
                BinaryTreeNode<Integer> node = q.poll();
                System.out.print(node.data + " ");
                if(node.left != null) {
                    q1.add(node.left);
                    count ++;
                }
                if(node.right != null) {
                    q1.add(node.right);
                    count ++;
                }
            }
            System.out.println();
            q.addAll(q1);
            q1.clear();
        }
    }
    
    public static void main(String[] args) {
        root = takeInputLevelWise();
        insertDuplicateNode(root);
        printLevelWise(root);
    }
}
