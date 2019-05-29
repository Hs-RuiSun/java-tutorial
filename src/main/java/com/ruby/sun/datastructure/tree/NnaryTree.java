package com.ruby.sun.datastructure.tree;

import java.util.*;

public class NnaryTree {
    public static void main(String[] args) {
        NnaryTreeNode NnaryTreeNode5 = new NnaryTreeNode(0, null);
        NnaryTreeNode NnaryTreeNode6 = new NnaryTreeNode(6, null);

        NnaryTreeNode NnaryTreeNode3 = new NnaryTreeNode(3, Collections.singletonList(NnaryTreeNode6));
        NnaryTreeNode NnaryTreeNode4 = new NnaryTreeNode(5, null);
        NnaryTreeNode NnaryTreeNode2 = new NnaryTreeNode(10, Arrays.asList(NnaryTreeNode4, NnaryTreeNode5));
        NnaryTreeNode root = new NnaryTreeNode(1, Arrays.asList(NnaryTreeNode2, NnaryTreeNode3));
        LinkedList<Integer> solution = new LinkedList<>();
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(NnaryTreeNode root) {
        List<List<Integer>> solution = new ArrayList<>();
        if(root == null){
            return solution;
        }
        Deque<NnaryTreeNode> parentDeque = new LinkedList<>();
        Deque<NnaryTreeNode> childrenDeque = new LinkedList<>();
        parentDeque.push(root);
        solution.add(Collections.singletonList(root.val));
        List<Integer> level = new ArrayList<>();
        while (!parentDeque.isEmpty() || !childrenDeque.isEmpty()){
            if(!parentDeque.isEmpty()){
                root = parentDeque.pop();
                if(root.children != null){
                    for(int i=0;i<root.children.size();i++){
                        level.add(root.children.get(i).val);
                    }
                    childrenDeque.addAll(root.children);
                }
            }
            else {
                solution.add(level);
                parentDeque.addAll(childrenDeque);
                childrenDeque.clear();
                level = new ArrayList<>();
            }
        }
        return solution;
    }

    //https://leetcode.com/problems/n-ary-tree-postorder-traversal/
    public static List<Integer> postOrderRecursive(NnaryTreeNode root, List<Integer> solution){
        if(root != null) {
            List<NnaryTreeNode> currentNnaryTreeNodeChildren = root.children;
            for(int i = 0; i < currentNnaryTreeNodeChildren.size(); i++ ) {
                postOrderRecursive(currentNnaryTreeNodeChildren.get(i), solution );
            }
            solution.add(root.val);
        }
        return solution;
    }
    public static List<Integer> postorder(NnaryTreeNode root){
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null)
            return list;
        Stack<NnaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            NnaryTreeNode NnaryTreeNode = stack.pop();
            list.addFirst(NnaryTreeNode.val);
            if(NnaryTreeNode.children != null) {
                NnaryTreeNode.children.forEach(stack::push);
            }
        }
        return list;
    }

    public static List<Integer> preorder(NnaryTreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Deque<NnaryTreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            root = deque.pollLast();
            list.add(root.val);
            if(root.children != null){
                Collections.reverse(root.children);
                deque.addAll(root.children);
            }
        }
        return list;
    }
}
