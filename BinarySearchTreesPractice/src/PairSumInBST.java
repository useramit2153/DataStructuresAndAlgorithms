
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
public class PairSumInBST {
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
    public static void pairSum(ArrayList<Integer> arr, int num) {
        
        int i = 0, j = arr.size() - 1; 
        int count = 0;
        
        while (i != j && j > i && i < arr.size() - 1 && j > 0)  {
            if ((arr.get(i) + arr.get(j)) > num )  {
                j --;
            }
                  
            else if ((arr.get(j) + arr.get(i)) < num)  { 
                i ++;
            }
            
            else {
                System.out.println(arr.get(i) + " " + arr.get(j));
                if(arr.get(j - 1) == arr.get(j) && i != j - 1){
                    j --;
                    count ++;
                } 
                else {
                    if(arr.get(i) == arr.get(i + 1)) {
                        j = j + count;
                        count = 0;
                    }
                    else
                        j --;
                    i ++;
                }
            } 
        }
    }
    public static ArrayList<Integer> convertArray(BinaryTreeNode<Integer> root) {
        if(root == null) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            return arr;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> smallAnsLeft = convertArray(root.left);
        ans.addAll(smallAnsLeft);
        ans.add(root.data);
        ArrayList<Integer> smallAnsRight = convertArray(root.right);
        ans.addAll(smallAnsRight);
        return ans;
    }
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        // Write your code here
        ArrayList<Integer> arr = convertArray(root);
        pairSum(arr, s);
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printNodesSumToS(root, 12);
    }
}
