package com.ruby.sun.datastructure.tree;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class BinaryTreeTraversal {
	@Test
	public void test() {
		TreeNode root = BinaryTree.buildBinaryTree(new int[] {4,5,1,7,2,3});
		Integer[] output = new Integer[6];
		assertArrayEquals(new Integer[] {4,1,2,3,5,7}, preorderTraversal(root).toArray(output));
		
	}
	//https://leetcode.com/problems/binary-tree-level-order-traversal/
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
        return list;
        
    }
	
	//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<>();
        return list;
    }
    
    https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<>();
        return list;
    }
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return list;
    }
	
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

	private static void postOrder(TreeNode root) {
		Deque<TreeNode> deque = new ArrayDeque<>();
		TreeNode node = root;
		if (node == null) {
			return;
		}
		System.out.print("\npostOrder: ");
		while (node != null || !deque.isEmpty()) {
			while (node != null) {
				deque.push(node);
				deque.push(node);
				node = node.left;
			}
			node = deque.poll();
			if (node == deque.peek()) {
				node = node.right;
			} else {
				System.out.print(node.val + " ");
				node = null;
			}
		}
	}

//	private static void levelOrder(TreeNode root) {
//		Queue<TreeNode> queue = new ArrayDeque<>();
//		TreeNode node = root;
//		if (node == null) {
//			return;
//		}
//		System.out.print("\nlevelOrder: ");
//		while (node != null || !queue.isEmpty()) {
//			System.out.print(node.val + " ");
//			if (node.left != null) {
//				queue.offer(node.left);
//			}
//			if (node.right != null) {
//				queue.offer(node.right);
//			}
//			node = queue.poll();
//		}
//	}

}
