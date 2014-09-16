package burov.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of single linked list.
 * Only required methods for testing reverse are implemented:
 * add, reverse, toList
 */
public class LinkedList<T> {
	private Node<T> startNode;
	private int size;

	public LinkedList() {
	}

	public void add(T value) {
		size++;
		if (startNode == null) {
			startNode = new Node<T>(value, null);
		} else {
			startNode.addNode(value);
		}
	}

	public void reverse() {
		if (startNode == null || startNode.next == null) {
			return;
		}

		Node<T> newStartNode = reverse(startNode, startNode.next);
		startNode.next = null;
		startNode = newStartNode;
	}

	private Node<T> reverse(Node<T> parent, Node<T> child) {
		if (child.next == null) {
			child.next = parent;
			parent.next = null;
			// return first node
			return child;

		} else {
			Node<T> firstNode = reverse(child, child.next);
			child.next = parent;
			return firstNode;
		}
	}

	public List<T> toList() {
		List<T> tList = new ArrayList<T>();
		fillList(tList, startNode);
		return tList;
	}

	private void fillList(List<T> tList, Node<T> startNode) {
		if (startNode != null) {
			tList.add(startNode.value);
			fillList(tList, startNode.next);
		}
	}

	private static class Node<T> {
		private T value;
		private Node<T> next;

		private Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}

		public void addNode(T value) {
			if (next == null) {
				next = new Node<T>(value, null);
			} else {
				next.addNode(value);
			}
		}
	}
}
