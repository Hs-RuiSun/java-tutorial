package com.ruby.sun.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BinaryTreeTraversal {
    private static void preOrder(BinaryTreeNode root){
        Deque<BinaryTreeNode> deque = new ArrayDeque<>();
        BinaryTreeNode node = root;
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

    private static void inOrder(BinaryTreeNode root){
        Deque<BinaryTreeNode> deque = new ArrayDeque<>();
        BinaryTreeNode node = root;
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
            System.out.print(node.val + "(" + node.count + ")" + " ");
            node = node.right;
        }
    }

    private static void postOrder(BinaryTreeNode root) {
        Deque<BinaryTreeNode> deque = new ArrayDeque<>();
        BinaryTreeNode node = root;
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

    private static void levelOrder(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        BinaryTreeNode node = root;
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

}
