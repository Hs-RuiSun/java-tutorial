package com.ruby.sun.datastructure;

public class BinaryTree {
    public static void main(String[] args) {
        int[] data = new int[]{10,5,15,3,7,18};
        BinaryTreeNode root = buildBinaryTree(data);
    }

    public static BinaryTreeNode buildBinaryTree(int[] data){
        BinaryTreeNode root = null;
        for(int i=0;i<data.length;i++){
            //root = recursiveInsert(root, data[i]);
        	root = insert(root, data[i]);
            //root = insertWithDuplicate(root, data[i]);
        }
        return root;
    }

    private static BinaryTreeNode recursiveInsert(BinaryTreeNode root, int val) {
        if (root == null) {
            return new BinaryTreeNode(val);
        }
        if (val < root.val) {
            root.left = recursiveInsert(root.left, val);
        } else if (val > root.val) {
            root.right = recursiveInsert(root.right, val);
        }
        return root;
    }
    
    private static BinaryTreeNode insert(BinaryTreeNode root, int val) {
    	if(root == null) {
    		return new BinaryTreeNode(val);
    	}
    	BinaryTreeNode node = new BinaryTreeNode(val);
        BinaryTreeNode parent = null;
        BinaryTreeNode current = root;
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

    private static BinaryTreeNode insertWithDuplicate(BinaryTreeNode root, int val){
        BinaryTreeNode node = new BinaryTreeNode(val, 1);
        if(root == null){
            root = node;
            return root;
        }
        BinaryTreeNode parent = null;
        BinaryTreeNode cur = root;
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
