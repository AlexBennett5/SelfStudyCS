#include <stdlib.h>
#include "tree.h"

Tree *empty = NULL;

int tree_member(int x, Tree *tree) { 
	
	if (tree == NULL) {
		return 0;
	} else if (tree->value == x) {
		return 1;
	} else {
		return tree_member(x, tree->left) + tree_member(x, tree->right);
	}
}

Tree *tree_insert(int x, Tree *tree) { 
  
	if (tree == NULL) {
		Tree *leaf = (Tree *)malloc(sizeof(Tree));
		leaf->value = x;
		leaf->left = NULL;
		leaf->right = NULL;
		tree = leaf;
	} else {
		if (tree->value > x) {
			tree->left = tree_insert(x, tree->left);
		} else {
			tree->right = tree_insert(x, tree->right);
		}
	}

	return tree;

}

void tree_free(Tree *tree) { 

	if (tree == NULL) {
		return;
	}

	tree_free(tree->left);
	tree_free(tree->right);
	free(tree);

}

void pop_minimum(Tree *tree, int *min, Tree **new_tree) { 

	Tree *node = tree;

	while (node->left->left != NULL) {
		node = node->left;
	}

	*min = node->left->value;
	
	if (node->left->right != NULL) {
		node->left = node->left->right;
	} else {
		node->left = NULL;
	}

	*new_tree = tree;

}

Tree *tree_remove(int x, Tree *tree) { 
  

	if (tree->value == x) {

		if (tree->left == NULL && tree->right == NULL) {
		       tree = NULL;

		} else if (tree->left != NULL && tree->right == NULL) {
	 		tree = tree->left;

		} else if (tree->left == NULL && tree->right != NULL) {
			tree = tree->right;

		} else {

			int *min = NULL;
			Tree **newtree = NULL;
			pop_minimum(tree->right, min, newtree);
			tree->right = *newtree;
			tree->value = *min;
		}

	} else if (tree->value > x) {
		
		tree->left = tree_remove(x, tree->left);

	} else {
	
		tree->right = tree_remove(x, tree->right);
	}

	return tree;	

}

