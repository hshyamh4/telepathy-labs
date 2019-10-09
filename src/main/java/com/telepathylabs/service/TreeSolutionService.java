package com.telepathylabs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.telepathylabs.domain.Node;

@Service
public class TreeSolutionService {

	public Node reArrange(Node rootNode) {

		if (rootNode == null) {
			return null;
		}

		List<Node> nodes = new ArrayList<>();
		nodes.add(rootNode);

		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			Node[] children = node.getChildren();
			if (children != null) {
				for (int j = 0; j < children.length; j++) {
					nodes.add(children[j]);
				}
			}
		}

		for (Node node : nodes) {
			arrangeSiblings(node);
		}

		return rootNode;
	}

	private void arrangeSiblings(Node node) {
		if (node != null && node.getChildren() != null) {
			Node[] children = node.getChildren();
			for (int index = 0; index < children.length - 1; index++) {
				children[index].setRight(children[index + 1]);
			}

			node.setChildren(new Node[] { children[0] });
		}
	}

}
