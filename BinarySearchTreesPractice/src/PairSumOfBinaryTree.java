
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
public class PairSumOfBinaryTree {
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
    public static ArrayList<Integer> convertTree(BinaryTreeNode<Integer> root) {
        
        if(root == null)
            return null;
        
        if(root.left == null && root.right == null){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(root.data);
            return arr;
        }
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> leftAns = convertTree(root.left);
        if(leftAns != null)
            arr.addAll(leftAns);
        ArrayList<Integer> rightAns = convertTree(root.right);
        if(rightAns != null)
            arr.addAll(rightAns);
        arr.add(root.data);
        return arr;
    }
    public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
        // Write your code here
        ArrayList<Integer> arr = convertTree(root);
        arr.sort(null);
        Integer[] a = new Integer[arr.size()];
        arr.toArray(a);
        int i = 0;
        int j = a.length - 1;
        while(j > i) {
            if((a[i] + a[j]) == sum){
                System.out.print(a[i] + " " + a[j]);
                System.out.println();
                i ++;
                j --;
            } else if((a[i] + a[j]) < sum)
                i ++;
            else
                j --;
        }
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        nodesSumToS(root, 15);
    }
}
