package com.ruby.sun.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> solution = new ArrayList<>();
		if (root == null) {
			return solution;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		while (root != null || !deque.isEmpty()) {

		}
		return solution;
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

	private static void preOrder(TreeNode root) {
		Deque<TreeNode> deque = new ArrayDeque<>();
		TreeNode node = root;
		if (root == null) {
			return;
		}
		System.out.print("\npreOrder: ");
		while (node != null || !deque.isEmpty()) {
			System.out.print(node.val + " ");
			if (node.right != null) {
				deque.push(node.right);
			}
			if (node.left != null) {
				deque.push(node.left);
			}
			node = deque.poll();
		}
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

	private static void levelOrder(TreeNode root) {
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

}
