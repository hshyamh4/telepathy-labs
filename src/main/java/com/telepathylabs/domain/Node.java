package com.telepathylabs.domain;

public class Node {
	private String id;
	private Node[] children;
	private Node right;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
