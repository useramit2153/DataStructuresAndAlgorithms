
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
public class HeightOfLargestBST {
    
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
    
    public static boolean isBSTUtil(BinaryTreeNode<Integer> node, int min, int max) { 
        /* an empty tree is BST */
        if (node == null) 
            return true; 
  
        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max) 
            return false; 
  
        /* otherwise check the subtrees recursively 
        tightening the min/max constraints */
        // Allow only distinct values 
        return (isBSTUtil(node.left, min, node.data-1) && isBSTUtil(node.right, node.data+1, max)); 
    }
    
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        /* Your class should be named Solution
        * Don't write main().
        * Don't read input, it is passed as function argument.
        * Return output and don't print it.
        * Taking input and printing output is handled automatically.
        */
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static int height(BinaryTreeNode<Integer> root) {
        /* Your class should be named Solution
        * Don't write main().
        * Don't read input, it is passed as function argument.
        * Return output and don't print it.
        * Taking input and printing output is handled automatically.
        */
        
        if(root == null)
            return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh > rh)
            return lh + 1;
        else
            return rh + 1;
    }
    
    public static Pair<Boolean, Integer> largestBSTSubtreeUtils(BinaryTreeNode<Integer> root) {
        // Write your code here
        if(root == null) {
            Pair<Boolean, Integer> p = new Pair<Boolean, Integer>();
            p.first = true;
            p.second = 0;
            p.min = 0;
            p.max = 0;
            return p;
        }
        
        if(root.left == null && root.right == null) {
            Pair<Boolean, Integer> p = new Pair<Boolean, Integer>();
            p.first = true;
            p.second = 1;
            p.min = root.data;
            p.max = root.data;
            return p;
        }
        
        Pair<Boolean, Integer> p = new Pair<Boolean, Integer>();
        Pair<Boolean, Integer> lp = largestBSTSubtreeUtils(root.left);
        Pair<Boolean, Integer> rp = largestBSTSubtreeUtils(root.right);
        
        if (root.data < lp.max || root.data > rp.min) {
            p.first = false;
            p.second = Math.max(lp.second, rp.second);
            p.min = lp.min;
            p.max = rp.max;
        } else {
            if(lp.first && rp.first) {
                p.first = true;
                p.second = Math.max(lp.second, rp.second) + 1;
                p.min = lp.min;
                p.max = rp.max;
            }
            else {
                p.first = false;
                p.second = Math.max(lp.second, rp.second);
                p.min = lp.min;
                p.max = rp.max;
            }
        }
        return p;
    }
    
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        // Write your code here
        return largestBSTSubtreeUtils(root).second;
    }
    
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        System.out.println(largestBSTSubtree(root));
    }
}
