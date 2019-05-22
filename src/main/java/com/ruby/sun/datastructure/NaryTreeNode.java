package com.ruby.sun.datastructure;

import java.util.List;

public class NaryTreeNode {
    int val;
    List<NaryTreeNode> children;
    NaryTreeNode(int val, List<NaryTreeNode> children){
        this.val = val;
        this.children = children;
    }
}
