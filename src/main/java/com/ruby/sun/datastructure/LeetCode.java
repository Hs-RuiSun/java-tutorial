package com.ruby.sun.datastructure;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

public class LeetCode {
    @Test
    public void test() {
        int[] data = new int[]{10,5,15,3,7,18};
        BinaryTreeNode root = BinaryTree.buildBinaryTree(data);
        assertEquals(37, rangeSumBST(root, 5, 15));
        assertEquals(25, rangeSumBST(root, 10, 15));
        assertEquals(33, rangeSumBST(root, 15, 18));
        assertEquals(10, rangeSumBST(root, 10, 10));
        assertEquals(15, rangeSumBST(root, 3, 7));
    }

    private static int rangeSumBST(BinaryTreeNode root, int L, int R) {
        int sum = 0;
        Deque<BinaryTreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            root = deque.poll();
            if(root.val >= L && root.val <=R){
                sum += root.val;
            }
            if(root.left != null && root.left.val >= L){
                deque.push(root.left);
            }
            if(root.right != null && root.right.val <= R){
                deque.push(root.right);
            }
        }
        return sum;
    }
}