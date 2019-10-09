package com.telepathylabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.telepathylabs.domain.Node;
import com.telepathylabs.service.TreeSolutionService;

@RestController
@RequestMapping("/question2/solution")
public class NodeSolutionController {

	@Autowired
	private TreeSolutionService treeSolutionService;

	@PostMapping
	public Node message(@RequestBody Node rootNode) {

		if (rootNode == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Root node is null");
		}

		return treeSolutionService.reArrange(rootNode);
	}
}
