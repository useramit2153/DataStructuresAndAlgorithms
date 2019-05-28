
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
public class TreeUse {
    
    public static int count = 0;
    
    public static TreeNode<Integer> takeInput(Scanner scan) {
        int n = scan.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);
        int childNo = scan.nextInt();
        for(int i = 0; i < childNo; i ++) {
            root.children.add(takeInput(scan));
        }
        return root;
    }
    
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner scan = new Scanner(System.in);
        int rootData = scan.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode<Integer> node = q.poll();
            int noOfChild = scan.nextInt();
            for(int i = 0; i < noOfChild; i ++) {
                int n = scan.nextInt();
                TreeNode<Integer> child = new TreeNode<Integer>(n);
                node.children.add(child);
                q.add(child);
            }
        }
        return root;
    }
    
    public static void print(TreeNode<Integer> root) {                 // Pre Order Traversal
        String s = root.data + ": ";
        for(int i = 0; i < root.children.size(); i ++) {
            if(i == root.children.size() - 1)
                s = s + root.children.get(i).data;
            else
                s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for(int i = 0; i < root.children.size(); i ++) {
            print(root.children.get(i));
        }
    }
    
    public static void printLevelWise(TreeNode<Integer> root) {
        int count = 0;
        Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
        Queue<TreeNode<Integer>> q1 = new LinkedList<TreeNode<Integer>>();
        q.add(root);
        count ++;
        while(count > 0) {
            count = 0;
            while(!q.isEmpty()) {
                TreeNode<Integer> node = q.poll();
                System.out.print(node.data + " ");
                for(int i = 0; i < node.children.size(); i ++) {
                    q1.add(node.children.get(i));
                    count ++;
                }
            }
            System.out.println();
            q.addAll(q1);
            q1.clear();
        }
    }
    
    public static void postOrder(TreeNode<Integer> root) {
        if(root == null)
            return;
        
        for(int i = 0; i < root.children.size(); i ++)
            postOrder(root.children.get(i));
        
        System.out.print(root.data + " ");
        
    }
    
    public static int numNodes(TreeNode<Integer> root) {
        
        if(root == null)
            return 0;
        
        int count = 1;
        for(int i = 0; i < root.children.size(); i ++) {
            count += numNodes(root.children.get(i));
        }
        return count;
    }
    
    public static int sumOfAllNode(TreeNode<Integer> root) {
        if(root == null)
            return Integer.MIN_VALUE;
        
        int sum = root.data;
        for(int i = 0; i < root.children.size(); i ++) {
            sum += sumOfAllNode(root.children.get(i));
        }
        return sum;
    }
    
    public static int largest(TreeNode<Integer> root) {
        if(root == null)
            return Integer.MIN_VALUE;
        
        int ans = root.data;
        for(int i = 0; i < root.children.size(); i ++) {
            int childLargest = largest(root.children.get(i));
            if(childLargest > ans)
                ans = childLargest;
        }
        return ans;
    }
    
    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        int count = 0;
        for(int i = 0; i < root.children.size(); i ++) {
            count += numNodeGreater(root.children.get(i), x);
        }
        if(root.data > x)
            count += 1;
        return count;
    }
    
    public static int height(TreeNode<Integer> root) {
        if(root == null)
            return 0;
        
        int height = 1;
        int l = 0;
        for(int i = 0; i < root.children.size(); i ++) {
            int temp = height(root.children.get(i));
            if(l < temp)
                l = temp;
        }
        return height + l;
    }
    
    public static void printAtK(TreeNode<Integer> root, int k) {
        if(k < 0)
            return;
        if(k == 0) {
            System.out.println(root.data);
            return;
        }
        for(int i = 0; i < root.children.size(); i ++) {
            printAtK(root.children.get(i), k - 1);
        }
    }
    
    public static int countLeafNodes(TreeNode<Integer> root) {
        if(root == null)
            return 0;
        
        int count = 0;
        for(int i = 0; i < root.children.size(); i ++) {
            count += countLeafNodes(root.children.get(i));
        }
        if(root.children.size() == 0)
            count = 1;
        return count;
    }
    
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        // Write your code here
        
        if(root == null)
            return false;
        
        if(root.data == x)
            return true;
        
        for(int i = 0; i < root.children.size(); i ++){
            boolean flag =  checkIfContainsX(root.children.get(i), x);
            if(flag == true)
                return flag;
        }
        
        return false;
        
    }
    
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        // Write your code here
        if(root1 == null && root2 == null)
            return false;
        
        boolean flag = true;
        
        if(root1.data != root2.data)
            return false;
        
        for(int i = 0; i < root1.children.size() && i < root2.children.size() && flag; i ++){
            flag = checkIdentical(root1.children.get(i), root2.children.get(i));
        }
        
        return flag;
    }
    
    public static int k = 0;
    
    public static void replaceWithDepthValue(TreeNode<Integer> root){
        // Write your code here
        int count = 0;
        Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
        Queue<TreeNode<Integer>> q1 = new LinkedList<TreeNode<Integer>>();
        q.add(root);
        count ++;
        while(count > 0) {
            count = 0;
            while(!q.isEmpty()) {
                TreeNode<Integer> node = q.poll();
                node.data = k;
                for(int i = 0; i < node.children.size(); i ++) {
                    q1.add(node.children.get(i));
                    count ++;
                }
            }
            k ++;
            q.addAll(q1);
            q1.clear();
        }
    }
    
    public static TreeNode<Integer> l = null, s = null;
    
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        // Write your code here
        if(root == null)
            return null;
        
        if(l == null) {
            l = root;
            s = root;
        }
        else {
            if(l.data < root.data) {
                s = l;
                l = root;
            }
        }
        
        for(int i = 0; i < root.children.size(); i ++) {    
            findSecondLargest(root.children.get(i));
        }
        
        return s;
    }
    
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
        // Write your code here
        if(root == null)
            return null;
        
        TreeNode<Integer> largest = null;
        
        if(root.data > n)
            largest = root;
        
        for(int i = 0; i < root.children.size(); i ++) {
            TreeNode<Integer> slargest = findNextLargerNode(root.children.get(i), n);
            if(largest == null)
                largest = slargest;
            else if(slargest != null) {
                if(slargest.data < largest.data)
                    largest = slargest;
            }
        }
        
        return largest;
    }
    
    public static NodeSum mSumNode(TreeNode<Integer> root) {
        NodeSum ans = new NodeSum();
        
        ans.sum = root.data;
        ans.x = root;
        
        for(int i = 0; i < root.children.size(); i ++)
            ans.sum = ans.sum + root.children.get(i).data;
        
        for(int i = 0; i < root.children.size(); i ++) {
            NodeSum temp = mSumNode(root.children.get(i));
            if(temp.sum > ans.sum) {
                ans.sum = temp.sum;
                ans.x = temp.x;
            }
        }
        
        return ans;
    }
    
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        // Write your code here
        NodeSum ans = mSumNode(root);
        return ans.x;
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        //TreeNode<Integer> root = takeInput(scan);
        TreeNode<Integer> root = takeInputLevelWise();
//        TreeNode<Integer> root = new TreeNode<Integer>(4);
//        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
//        TreeNode<Integer> node2 = new TreeNode<Integer>(3);
//        TreeNode<Integer> node3 = new TreeNode<Integer>(5);
//        TreeNode<Integer> node4 = new TreeNode<Integer>(6);
//        
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);
//        
        //print(root);
//        printLevelWise(root);
//        System.out.println(numNodes(root));
//        System.out.println(sumOfAllNode(root));
//        System.out.println(largest(root));
//        int n = scan.nextInt();
//        System.out.println(numNodeGreater(root, n));
//        System.out.println(height(root));
//        printAtK(root, 1);
//        System.out.println(countLeafNodes(root));
//        postOrder(root);
//        System.out.println();
        
//        System.out.println(checkIfContainsX(root, 100));
//        TreeNode<Integer> root1 = takeInputLevelWise();
//        System.out.println(checkIdentical(root, root1));
//        replaceWithDepthValue(root);
//        System.out.println(findSecondLargest(root).data);
//        System.out.println(findNextLargerNode(root, 21).data);
        System.out.println(maxSumNode(root).data);
    }
    
}
