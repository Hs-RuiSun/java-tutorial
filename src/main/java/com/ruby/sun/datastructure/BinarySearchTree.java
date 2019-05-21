package com.ruby.sun.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BinarySearchTree {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return 0;
    }

    public static void main(String[] args) {
        int[] data = new int[]{10,5,15,3,7,18};
        TreeNode root = buildBinaryTree(data);
        //levelOrder(root);
        //preOrder(root);
        inOrder(root);
    }

    private static TreeNode buildBinaryTree(int[] data){
        TreeNode root = null;
        for(int i=0;i<data.length;i++){
            root = recursiveInsert(root, data[i]);
        }
        return root;
    }

    private static void preOrder(TreeNode treeNode){
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = treeNode;
        if(treeNode == null){
            return;
        }
        System.out.print("\npreOrder: ");
        deque.push(node);
        while (!deque.isEmpty()){
            node = deque.pop();
            System.out.print(node.val + " ");
            if(node.right != null){
                deque.push(node.right);
            }
            if(node.left != null){
                deque.push(node.left);
            }
        }
    }

    private static void inOrder(TreeNode treeNode){
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = treeNode;
        if(node == null){
            return;
        }
        System.out.print("\ninOrder: ");
        deque.push(node);
        node = node.left;
        while (!deque.isEmpty()){
            while (node!=null && node.left != null){
                deque.push(node);
                node = node.left;
            }
            if(node != null){
                System.out.print(node.val + " ");
            }
            node = deque.poll();
            if(node != null){
                System.out.print(node.val + " ");
                if(node.right != null) {
                    deque.push(node);
                    node = node.right;
                }
            }
        }
    }

    private static void levelOrder(TreeNode treeNode){
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode node;
        if(treeNode != null){
            queue.add(treeNode);
            System.out.print("\nlevelOrder: ");
        }
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.val + " ");
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }

    private static TreeNode recursiveInsert(TreeNode treeNode, int val) {
        if (treeNode == null) {
            return new TreeNode(val);
        }
        if (val < treeNode.val) {
            treeNode.left = recursiveInsert(treeNode.left, val);
        } else if (val > treeNode.val) {
            treeNode.right = recursiveInsert(treeNode.right, val);
        }
        return treeNode;
    }
}
