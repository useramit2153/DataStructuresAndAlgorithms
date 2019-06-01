
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
public class BinarySearchTreeUse {
    
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
    
    public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root , int k){
        /* Your class should be named Solution
        * Don't write main().
        * Don't read input, it is passed as function argument.
        * Return output and don't print it.
        * Taking input and printing output is handled automatically.
        */
        
        if(root == null)
            return null;
        
        if(root.data == k)
            return root;
        
        if(k < root.data)
            return searchInBST(root.left, k);
        else
            return searchInBST(root.right, k);
        
    }
    
    public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root,int k1,int k2){
        
        /*
        *In Order travarsersal gives us the sorted result of BST.
        *So for every root check its data exists between k1 and k2 or not.
        */
        
        if(root == null)
            return;
        if(root.data >= k1 && root.data <= k2)
            System.out.print(root.data + " ");
        if(k1 <= root.data)
            printNodeFromK1ToK2(root.left, k1, k2);
        if(k2 >= root.data)
            printNodeFromK1ToK2(root.right, k1, k2);
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
    
    public static BinaryTreeNode<Integer> SortedArrayToBSTUtils(int[] arr, int si, int ei) {
        if(si > ei)
            return null;
        
        int mid = (si + ei) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
        root.left = SortedArrayToBSTUtils(arr, si, mid - 1);
        root.right = SortedArrayToBSTUtils(arr, mid + 1, ei);
        return root;
    }
    
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr) {
        return SortedArrayToBSTUtils(arr, 0, arr.length - 1);
    }
    
    public static Node<Integer> head = null, tail = null;
    
    public static Node<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
	*/
        if(root == null)
            return null;
        BSTToSortedLL(root.left);
        Node<Integer> newNode = new Node<Integer>(root.data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        BSTToSortedLL(root.right);
        return head;
    }
    
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    
    public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data){
        /* Your class should be named Solution
	* Don't write main().
	* Don't read input, it is passed as function argument.
	* Return output and don't print it.
	* Taking input and printing output is handled automatically.
	*/
        if(root == null)
            return list;
        
        if(root.data == data){
            list.add(root.data);
            return list;
        }
        
        if(data < root.data)
            findPath(root.left, data);
        else
            findPath(root.right, data);
        if(list.size() != 0){
            list.add(root.data);
            return list;
        } else
            return null;
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
    
    // For LinkedList
    public static void print(Node<Integer> head) {
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        //BinaryTreeNode<Integer> root = takeInputLevelWise();
        
//        root = searchInBST(root, 12);
//        if(root != null)
//            System.out.println(root.data);
        
        //printNodeFromK1ToK2(root, 20, 50);
        //System.out.println(isBST(root));
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        BinaryTreeNode<Integer> root = SortedArrayToBST(arr);
//        Node<Integer> head = BSTToSortedLL(root);
//        print(head);
//        ArrayList path = findPath(root, 2);
//        for(int i = 0; i < path.size(); i ++)
//            System.out.println(path.get(i));
        //printLevelWise(root);
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertData(8);
        bst.insertData(5);
        bst.insertData(10);
        bst.insertData(2);
        bst.insertData(6);
        bst.insertData(7);
        bst.insertData(3);
        bst.deleteData(8);
        BinaryTreeNode<Integer> root = bst.root;
        printLevelWise(root);
        System.out.println(bst.search(90));
        bst.printTree();
    }
    
}
