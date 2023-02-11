package com.bz.addressbook.utility;


class Node <T> {
	private T data;
	private Node nextNode;
	public Node(T data) {
		this.data = data;
		this.nextNode = null;
	}
	public T getData() {
		return data;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}

/**
 * @author Shubham
 *
 * @param <T>
 */
public class LinkedList <T> implements ILinkedList <T>{

	static Node headNode;
	
	@Override
	public <T> void  add(T data) {
		Node newNode = new Node(data);
		if(headNode == null) {
			headNode = newNode;
		}else {
			Node temp = headNode;
			while(temp.getNextNode() != null) {
				temp = temp.getNextNode();
			}
			temp.setNextNode(newNode);
		}
	}

	@Override
	public void printLinkedList() {
		Node temp = headNode;
		while(temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNextNode();
		}
	}
	
	@Override
	public int size() {
		int size = 0;
		Node temp = headNode;
		while(temp != null) {
			temp = temp.getNextNode();
			size++;
		}
		return size;
	}

}
