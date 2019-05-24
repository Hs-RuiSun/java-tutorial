package com.ruby.sun.datastructure;

import java.util.*;

public class NnaryTree {
    public static void main(String[] args) {
        Node node5 = new Node(0, null);
        Node node6 = new Node(6, null);

        Node node3 = new Node(3, Collections.singletonList(node6));
        Node node4 = new Node(5, null);
        Node node2 = new Node(10, Arrays.asList(node4, node5));
        Node root = new Node(1, Arrays.asList(node2, node3));
        LinkedList<Integer> solution = new LinkedList<>();
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> solution = new ArrayList<>();
        if(root == null){
            return solution;
        }
        Deque<Node> parentDeque = new LinkedList<>();
        Deque<Node> childrenDeque = new LinkedList<>();
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

    public static List<Integer> postOrderRecursive(Node root, List<Integer> solution){
        if(root != null) {
            List<Node> currentNodeChildren = root.children;
            for(int i = 0; i < currentNodeChildren.size(); i++ ) {
                postOrderRecursive(currentNodeChildren.get(i), solution );
            }
            solution.add(root.val);
        }
        return solution;
    }

    public static List<Integer> postorder(Node root){
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null)
            return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.addFirst(node.val);
            if(node.children != null) {
                node.children.forEach(stack::push);
            }
        }
        return list;
    }

    public static List<Integer> preorder(Node root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Deque<Node> deque = new ArrayDeque<>();
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
