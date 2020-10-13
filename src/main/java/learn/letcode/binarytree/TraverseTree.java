package learn.letcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TraverseTree {

	/**
	 * 前序遍历
	 * @param node
	 */
	public void preOder(BinaryTree node) {
		if (node != null) {
			System.out.println(node.getData() + "\t");
			preOder(node.getLeft());
			preOder(node.getRight());
		}
	}

	/**
	 * 中序遍历
	 * @param node
	 */
	public void inOder(BinaryTree node) {
		if (node != null) {
			preOder(node.getLeft());
			System.out.println(node.getData() + "\t");
			preOder(node.getRight());
		}
	}

	/**
	 * 后续遍历
	 * @param node
	 */
	public void postOder(BinaryTree node) {
		if (node != null) {
			preOder(node.getLeft());
			preOder(node.getRight());
			System.out.println(node.getData() + "\t");
		}
	}

	/**
	 * 层序遍历
	 * @param node
	 */
	public void levelOrder(BinaryTree node) {
		BinaryTree temp;
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			System.out.println(temp.getData());
			if (temp.getLeft() != null) {
				queue.offer(temp.getLeft());
			}
			if (temp.getRight() != null) {
				queue.offer(temp.getRight());
			}
		}
	}


}
