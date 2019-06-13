package com.ruby.sun.datastructure.tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

public class BinaryTreeTraversal {
	@Test
	public void test() {
//		TreeNode root = BinaryTree.buildBinaryTree(new int[] {4,5,1,7,2,3});
//		Integer[] output = new Integer[6];
//		assertArrayEquals(new Integer[] {4,1,2,3,5,7}, preorderTraversal(root).toArray(output));
		TreeNode root = BinaryTree.buildBinaryTree(new int[] {5,9,4,3,20,7,15});
		assertArrayEquals(new Integer[] {3,4,7,15,20,9,5}, postorderTraversal(root).toArray());
		assertArrayEquals(new Integer[] {3,2,1}, postorderTraversal(BinaryTree.buildBinaryTree(new int[] {1,3,2})).toArray());
	}

	//https://leetcode.com/problems/binary-tree-postorder-traversal/
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> solution = new ArrayList<>();
		if(root == null) {
			return solution; 
		}
		return solution;
	}
	public List<Integer> postorderRecursive(TreeNode root) {
		List<Integer> solution = new ArrayList<>();
		if(root == null) {
			return solution; 
		}
		postorder(root, solution);
		return solution;
    }
	private void postorder(TreeNode root, List<Integer> solution) {
		if(root.left != null) {
			postorder(root.left, solution); 
		}
		if(root.right != null) {
			postorder(root.right, solution);
		}
		solution.add(root.val);
	}
//	private static void postOrder(TreeNode root) {
//		Deque<TreeNode> deque = new ArrayDeque<>();
//		TreeNode node = root;
//		if (node == null) {
//			return;
//		}
//		System.out.print("\npostOrder: ");
//		while (node != null || !deque.isEmpty()) {
//			while (node != null) {
//				deque.push(node);
//				deque.push(node);
//				node = node.left;
//			}
//			node = deque.poll();
//			if (node == deque.peek()) {
//				node = node.right;
//			} else {
//				System.out.print(node.val + " ");
//				node = null;
//			}
//		}
//	}
	
	//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> solution = new ArrayList<>();
		if (root == null) {
			return solution;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		while (root != null || !deque.isEmpty()) {
			while (root != null) {
				deque.push(root);
				root = root.left;
			}
			root = deque.pop();
			solution.add(root.val);
			root = root.right;
		}
		return solution;
	}
	
	//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if(root == null){
			return new LinkedList<>();
		}
		Deque<TreeNode> deque = new LinkedList<>();
		List<Integer> levelList = new ArrayList<>();
		deque.push(root);
		boolean zigzag = false;
		while(!deque.isEmpty()){
			int size = deque.size();
			for(int i=0;i < size; i++){
				root = deque.pollLast();
				if(zigzag) {
					levelList.add(0, root.val);
				} else {
					levelList.add(root.val);
				}
				if(root.left != null) {
					deque.push(root.left);
				}
				if(root.right != null) {
					deque.push(root.right);
				}
			}
			list.add(levelList);
			zigzag = !zigzag;
			levelList = new ArrayList<>();
		}
		return list;
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if(root == null){
			return new LinkedList<>();
		}
		Deque<TreeNode> deque = new LinkedList<>();
		List<Integer> levelList = new ArrayList<>();
		deque.push(root);
		while(!deque.isEmpty()){
			int size = deque.size();
			for(int i=0;i < size; i++){
				root = deque.pollLast();
				levelList.add(root.val);
				if(root.left != null) {
					deque.push(root.left);
				}
				if(root.right != null) {
					deque.push(root.right);
				}
			}
			list.add(0, levelList);  //this is a magic method
			levelList = new ArrayList<>();
		}
		return list;
	}

	//https://leetcode.com/problems/binary-tree-level-order-traversal/
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if(root == null){
			return list;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		List<Integer> levelList = new ArrayList<>();
		deque.push(root);
		while(!deque.isEmpty()){
			int size = deque.size();
			for(int i=0;i < size; i++){
				root = deque.pollLast();
				levelList.add(root.val);
				if(root.left != null) {
					deque.push(root.left);
				}
				if(root.right != null) {
					deque.push(root.right);
				}
			}
			list.add(levelList);
			levelList = new ArrayList<>();
		}
		return list;
	}
	private static void levelOrderTraverse(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		TreeNode node = root;
		if (node == null) {
			return;
		}
		System.out.print("\nlevelOrder: ");
		while (node != null || !queue.isEmpty()) {
			System.out.print(node.val + " ");
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			node = queue.poll();
		}
	}
	public static List<List<Integer>> levelOrderRecursive(TreeNode root) { // this is faster
		List<List<Integer>> list=new ArrayList<>();
		if(root!=null){
			traverseTree(root,0, list);
		}
		return list;
	}
	private static void traverseTree(TreeNode node,int depth, List<List<Integer>> list){
		if(node == null){
			return;
		}
		if(list.size() == depth){
			list.add(new ArrayList<>());
		}
		list.get(depth).add(node.val);
		traverseTree(node.left,depth+1, list);
		traverseTree(node.right,depth+1, list);
	}

    //https://leetcode.com/problems/binary-tree-preorder-traversal/
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		while(root!=null || !stack.isEmpty()) {
			list.add(root.val);
			if(root.right != null) {
				stack.push(root.right);
			}
			if(root.left != null) {
				stack.push(root.left);
			}
			root = stack.poll();
		}
        return list;
    }
}
