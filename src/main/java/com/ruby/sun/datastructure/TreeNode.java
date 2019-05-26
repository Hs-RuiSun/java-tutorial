package com.ruby.sun.datastructure;

public class TreeNode {
    int val;
    int count;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, int count){
        this.val = val;
        this.count = count;
    }
}
