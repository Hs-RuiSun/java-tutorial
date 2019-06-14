package com.ruby.sun.leetcode.tree;

import java.util.List;

public class NnaryTreeNode {
    int val;
    List<NnaryTreeNode> children;
    NnaryTreeNode(int val, List<NnaryTreeNode> children){
        this.val = val;
        this.children = children;
    }
}
