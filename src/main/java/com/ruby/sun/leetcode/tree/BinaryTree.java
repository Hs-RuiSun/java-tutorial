package com.ruby.sun.leetcode.tree;

public class BinaryTree {
    public static void main(String[] args) {
        int[] data = new int[]{10,2,15,3, 9, 7,18,13};
        TreeNode root = buildBinaryTree(data);
        System.out.println(BinaryTreeTraversal.inorderTraversal(root));
    }

    public static TreeNode buildBinaryTree(int[] data){
        TreeNode root = null;
        for(int i=0;i<data.length;i++){
            //root = recursiveInsert(root, data[i]);
        	root = insert(root, data[i]);
            //root = insertWithDuplicate(root, data[i]);
        }
        return root;
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
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            parent = current;
            if(current.val > val) {
            	current = current.left;
            }
            else {
            	current = current.right;
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

    private static TreeNode insertWithDuplicate(TreeNode root, int val){
        TreeNode node = new TreeNode(val, 1);
        if(root == null){
            root = node;
            return root;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.val > val){
                parent = cur;
                cur = cur.left;
            } else if(cur.val < val){
                parent = cur;
                cur = cur.right;
            } else {
                cur.count = cur.count + 1;
                return root;
            }
        }
        if(parent.val > val){
            parent.left = node;
        } else {
            parent.right = node;
        }
        return root;
    }
}
