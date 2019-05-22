package com.ruby.sun.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return 0;
    }

    public static void main(String[] args) {
        int[] data = new int[]{10,5,15,3,7,18};
        TreeNode root = buildBinaryTree(data);
        levelOrder(root);
        preOrder(root);
        inOrder(root);
        postOrder(root);
    }

    private static TreeNode buildBinaryTree(int[] data){
        TreeNode root = null;
        for(int i=0;i<data.length;i++){
            //root = recursiveInsert(root, data[i]);
        	root = insert(root, data[i]);
        }
        return root;
    }

    private static void preOrder(TreeNode root){
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        if(root == null){
            return;
        }
        System.out.print("\npreOrder: ");
        while (node!=null || !deque.isEmpty()){
            System.out.print(node.val + " ");
            if(node.right != null){
                deque.push(node.right);
            }
            if(node.left != null){
                deque.push(node.left);
            }
            node = deque.poll();
        }
    }

    private static void inOrder(TreeNode root){
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        if(node == null){
            return;
        }
        System.out.print("\ninOrder: ");
        while (node != null || !deque.isEmpty()){
            while (node != null){
                deque.push(node);
                node = node.left;
            }
            node = deque.poll();
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
    
    private static void postOrder(TreeNode root) {
    	Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        if(node == null){
            return;
        }
        System.out.print("\npostOrder: ");
        while (node != null || !deque.isEmpty()){
            while (node != null){
                deque.push(node);
                deque.push(node);
                node = node.left;
            }
            node = deque.poll();
            if(node == deque.peek()) {
            	node = node.right;
            } else {
            	System.out.print(node.val + " ");
            	node = null;
            }
        }
    }

    private static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = root;
        if(node == null) {
        	return;
        }
        System.out.print("\nlevelOrder: ");
        while (node!=null || !queue.isEmpty()){
            System.out.print(node.val + " ");
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            node = queue.poll();
        }
    }

    private static TreeNode recursiveInsert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = recursiveInsert(root.left, val);
        } else if (val > root.val) {
            root.right = recursiveInsert(root.right, val);
        }
        return root;
    }
    
    private static TreeNode insert(TreeNode root, int val) {
    	if(root == null) {
    		return new TreeNode(val);
    	}
    	TreeNode node = new TreeNode(val);
        TreeNode parent = null, current = root;
        while (current != null) {
            parent = current;
            if(current.val > val) {
            	current = current.left;
            }
            else if (current.val < val) {
            	current = current.right;
            }
            else {
            	// overwrite duplicate
            } 
        }
        if(parent.val > val) {
        	parent.left = node;
        }
        else if (parent.val < val) {
        	parent.right = node;
        }
    	return root;
    }
}
