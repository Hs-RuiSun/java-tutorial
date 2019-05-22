package com.ruby.sun.datastructure;

public class BinaryTreeNode {
    int val;
    int count;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int val) { this.val = val; }
    BinaryTreeNode(int val, int count){
        this.val = val;
        this.count = count;
    }
}
