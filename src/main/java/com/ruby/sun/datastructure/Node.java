package com.ruby.sun.datastructure;

import java.util.List;

public class Node {
    int val;
    List<Node> children;
    Node(int val, List<Node> children){
        this.val = val;
        this.children = children;
    }
}
