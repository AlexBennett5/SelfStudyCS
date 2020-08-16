#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include "graph.h"

Node *empty = NULL;

Node *node(int value, Node *left, Node *right) { 
  Node *r = malloc(sizeof(Node));
  r->marked = false;
  r->value = value;
  r->left = left;
  r->right = right;
  return r;
}

int size(Node *node) { 

	if (node == NULL || node->marked) {
		return 0;
	}

	node->marked = true;
	int left = size(node->left);
	int right = size(node->right);

	return 1 + left + right;

}

void unmark(Node *node) { 

	if (node != NULL && node->marked) {
		node->marked = false;
		unmark(node->left);
		unmark(node->right);
	}

}

bool path_from(Node *node1, Node *node2) {
  
	if (node1 == NULL || node2 == NULL) {
		return false;
	}

	if (node1 == node2) {
		return true;
	}

	return path_from(node1->left, node2) || path_from(node1->right, node2);

}

bool cyclic(Node *node) { 

	return (node == NULL) ? false : (path_from(node->left, node) || path_from(node->right, node));

} 

void get_nodes(Node *node, Node **dest) { 

	if (node != NULL && !node->marked) {

		node->marked = true;
		dest[0] = node;
		get_nodes(node->left, ++dest);
		get_nodes(node->right, dest);

	}

}

void graph_free(Node *node) { 

	int graphsize = size(node);
	unmark(node);
	Node **dest = malloc(graphsize * (sizeof(Node)));
	get_nodes(node, dest);

	for (int i = 0; i < graphsize; i++) {
		free(dest[i]);
	}

	free(dest);

}


