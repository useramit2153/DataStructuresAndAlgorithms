
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amith
 */
public class BinaryTreeUse {
    
    public static void printTree(BinaryTreeNode<Integer> root) {
        
        if(root == null)
            return;
        
        String toBePrinted = root.data + ": ";
        if(root.left != null)
            toBePrinted = toBePrinted + "L:" + root.left.data + ",";
        if(root.right != null)
            toBePrinted = toBePrinted + "R:" + root.right.data;
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
        
    }
    
    public static void printTreeLevelWise(BinaryTreeNode<Integer> root) {
        
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
        pendingNodes.add(root);
        
        while(!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodes.poll();
            String toBePrinted = front.data + ":";
            if(front.left != null) {
                toBePrinted += "L:" + front.left.data + ",";
                pendingNodes.add(front.left);
            } else
                toBePrinted += "L:-1,";
            
            if(front.right != null) {
                toBePrinted += "R:" + front.right.data;
                pendingNodes.add(front.right);
            } else
                toBePrinted += "R:-1";
            
            System.out.println(toBePrinted);
        }
        
    }
    
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
    
    public static BinaryTreeNode<Integer> takeInput(Scanner scan) {
        int rootData;
        System.out.println("Enter root data.");
        rootData = scan.nextInt();
        if(rootData == -1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = takeInput(scan);
        root.right = takeInput(scan);
        return root;
    }
    
    public static int countNodes(BinaryTreeNode<Integer> root) {
        
        if(root == null)
            return 0;
        
        int ans = 1;
        ans += countNodes(root.left);
        ans += countNodes(root.right);
        return ans;
    }
    
    public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
        */
        if(root == null)
            return false;
        if(root.data == x)
            return true;
        boolean left =  isNodePresent(root.left, x);
        if(left == true)
            return true;
        boolean right = isNodePresent(root.right, x);
        if(right == true)
            return true;
        return (left | right);
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
    
    public static void mirror(BinaryTreeNode<Integer> root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * No need to print or return the output.
         * Taking input and printing output is handled automatically.
         */
        if(root.left == null && root.right == null)
            return;
        else if(root.right == null){
            root.left = null;
            return;
        }
        else if(root.left == null){
            root.right = null;
            return;
        }
        
        mirror(root.left);
        mirror(root.right);
        
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    
    public static int diameter(BinaryTreeNode<Integer> root) {
        if(root == null)
            return 0;
        
        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);
        return Math.max(option1, Math.max(option2, option3));
    }
    
    public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair<Integer,Integer> output = new Pair<>();
            output.first = 0;
            output.second = 0;
            return output;
        }
        Pair<Integer, Integer> lo = heightDiameter(root.left);
        Pair<Integer, Integer> ro = heightDiameter(root.right);
        int height = 1 + Math.max(lo.first, ro.first);
        int option1 = lo.first + ro.first;
        int option2 = lo.second;
        int option3 = ro.second;
        int diameter = Math.max(option1, Math.max(option2, option3));		
        Pair<Integer,Integer> output = new Pair<>();
        output.first = height;
        output.second = diameter;
        return output;
    }
    
    public static void printInorder(BinaryTreeNode<Integer> root) {
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    
    public static void preOrder(BinaryTreeNode<Integer> root) {
        if(root == null)
            return;
        
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void postOrder(BinaryTreeNode<Integer> root) {
        if(root == null)
            return;
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static BinaryTreeNode<Integer> buidBinaryTreeForPreAndInOrder(int in[], int pre[], int inS, int inE, int preS, int preE) {
        if (inS > inE) {
            return null;
        }
        int rootData = pre[preS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        int rootInIndex = -1;
        for (int i = inS; i <= inE; i++) {
            if (in[i] == rootData) {
        	rootInIndex = i;
       		break;
            }
        }
	if (rootInIndex == -1) {
            return null;
	}
		
        root.left = buidBinaryTreeForPreAndInOrder(in, pre, inS, rootInIndex - 1, preS + 1, rootInIndex - inS + preS);
        root.right = buidBinaryTreeForPreAndInOrder(in, pre, rootInIndex + 1, inE, rootInIndex - inS + preS + 1, preE);
		
        return root;
        
    } 
    
    public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in) {
        // write your code here
        return buidBinaryTreeForPreAndInOrder(pre, in, 0, in.length - 1, 0, pre.length - 1);
    }
    
    public static BinaryTreeNode<Integer> buildBinaryTreeForPostAndInOrder(int[] post, int[] in, int inS, int inE, int postS, int postE) {
        
        if(inS > inE)
            return null;
        
        int rootData = post[postE];
        int rootIndex = -1;
        for(int i = inS; i <= inE; i ++) {
            if(in[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex == -1)
            return null;
        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        
        int leftInS = inS;
        int leftInE = rootIndex - 1;
        int leftPostS = postS;
        int leftPostE = postE - (inE - rootIndex) - 1;
        int rightInS = rootIndex + 1;
        int rightInE = inE;
        int rightPostS = postE - (inE - rootIndex);
        int rightPostE = postE - 1;
        
        root.left = buildBinaryTreeForPostAndInOrder(post, in, leftInS, leftInE, leftPostS, leftPostE);
        root.right = buildBinaryTreeForPostAndInOrder(post, in, rightInS, rightInE, rightPostS, rightPostE);
        
        return root;
    }
    
    public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in){
        // Write your code here
        return buildBinaryTreeForPostAndInOrder(post, in, 0, in.length - 1, 0, post.length - 1);
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
    
    public static PairBalance cBalanced(BinaryTreeNode<Integer> root) {
        if(root == null) {
            PairBalance p = new PairBalance();
            p.height = 0;
            p.isBalanced = true;
            return p;
        }
        
        PairBalance lp = cBalanced(root.left);
        if(!lp.isBalanced)
            return lp;
        PairBalance rp = cBalanced(root.right);
        if(!rp.isBalanced)
            return rp;
        PairBalance p = new PairBalance();
        p.height = Math.max(lp.height, rp.height) + 1;
        if(Math.abs(lp.height - rp.height) <= 1)
            p.isBalanced = true;
        else
            p.isBalanced = false;
        return p;
    }
    
    public static boolean checkBalanced(BinaryTreeNode<Integer> root){
        // Write your code here
        return cBalanced(root).isBalanced;
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
    
    public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){
        // Write your code here
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return null;
        
        root.left = removeAllLeaves(root.left);
        root.right = removeAllLeaves(root.right);
        
        return root;
    }
    
    public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
        // Write your code here
        int count = 0;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        Queue<BinaryTreeNode<Integer>> q1 = new LinkedList<BinaryTreeNode<Integer>>();
        ArrayList<Node<BinaryTreeNode<Integer>>> list = new ArrayList<Node<BinaryTreeNode<Integer>>>();
        q.add(root);
        count ++;
        while(count > 0) {
            count = 0;
            Node<BinaryTreeNode<Integer>> head = null, tail = null;
            while(!q.isEmpty()) {
                BinaryTreeNode<Integer> node = q.poll();
                
                if(head == null){
                    Node<BinaryTreeNode<Integer>> newNode = new Node<BinaryTreeNode<Integer>>(node);
                    head = newNode;
                    tail = newNode;
                } else {
                    Node<BinaryTreeNode<Integer>> newNode = new Node<BinaryTreeNode<Integer>>(node);
                    tail.next = newNode;
                    tail = newNode;
                }
                
                if(node.left != null) {
                    q1.add(node.left);
                    count ++;
                }
                if(node.right != null) {
                    q1.add(node.right);
                    count ++;
                }
            }
            
            list.add(head);
            
            q.addAll(q1);
            q1.clear();
        }
        
        return list;
    }
    
    public static void printZigZag(BinaryTreeNode<Integer> root) {
        // Write your code here
        int count = 1;
        int levelCount = 0;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        Stack<BinaryTreeNode<Integer>> q1 = new Stack<BinaryTreeNode<Integer>>();
        q.add(root);
        count ++;
        while(count > 0) {
            count = 0;
            while(!q.isEmpty()) {
                BinaryTreeNode<Integer> node = q.poll();
                if(levelCount % 2 == 0)
                    System.out.print(node.data + " ");
                if(node.left != null) {
                    q1.push(node.left);
                    count ++;
                }
                if(node.right != null) {
                    q1.push(node.right);
                    count ++;
                }
            }
            System.out.println();
            q.addAll(q1);
            if(levelCount % 2 == 0) {
                while(!q1.isEmpty())
                    System.out.print(q1.pop().data + " ");
            }
            q1.clear();
            levelCount ++;
        }
    }
    
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        // Write your code here
        if(root == null)
            return;
        if(root.left == null && root.right != null)
            System.out.println(root.right.data);
        else if(root.left != null && root.right == null)
            System.out.println(root.left.data);
        
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }
    
    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
//        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
//        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(3);
//        root.left = node1;
//        root.right = node2;
//        System.out.println();
        
        //Scanner scan = new Scanner(System.in);
//        BinaryTreeNode<Integer> root = takeInput(scan);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        //printTree(root);
        //printTreeLevelWise(root);
        //System.out.println(countNodes(root));
        //scan.close();
        //System.out.println(isNodePresent(root, 100));
        //System.out.println(height(root));
        //System.out.println("diameter:" + heightDiameter(root).second);
        //printInorder(root);
        //preOrder(root);
        //postOrder(root);
//        int[] pre = {1, 2, 3, 4, 15, 5, 6, 7, 8, 10, 9, 12};
//        int[] in = {4, 15, 3, 2, 5, 1, 6, 10, 8, 7, 9, 12};
//        BinaryTreeNode<Integer> root = getTreeFromPreorderAndInorder(pre, in);
        
//        int[] post = {4, 8, 5, 2, 7, 3, 1};
//        int[] in = {4, 2, 8, 5, 1, 3, 7};
//        BinaryTreeNode<Integer> root = getTreeFromPostorderAndInorder(post, in);
        
        //System.out.println(sum(root));
        //System.out.println(checkBalanced(root));
        //printTreeLevelWise(root);
        //removeAllLeaves(root);
        //printZigZag(root);
        //printNodesWithoutSibling(root);
        //printLevelWise(root);
    }
    
}
