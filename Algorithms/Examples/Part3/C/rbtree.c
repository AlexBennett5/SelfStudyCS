#include <stdio.h>
#include "rbtree.h"

void rotateLeft(Node *n) {
	Node *m = n->right;
	n->right = m->left;
	if (m->left != NIL)
		m->left->parent = n;
	if (m != NIL)
		m->parent = n->parent;
	if (n->parent) {
		if (n = n->parent->left)
			n->parent->left = m;
		else
			n->parent->right = m;
	} else {
		root = m;
	}
	m->left = n;
	if (n != NIL)
		n->parent = m;
}

void rotateRight(Node *n) {
	Node *m = n->left;
	n->left = m->right;
	if (m->right != NIL)
		m->right->parent = n;
	if (n->parent) {
		if (n == n->parent->right)
			n->parent->right = m;
		else
			n->parent->left = m;
	} else {
		root = m;
	}
	m->right = n;
	if (n != NIL)
		n->parent = m;
}

void insertFixup(Node *n) {
	
}

Node* insertNode(int key);
void deleteFixup(Node *n);
void deleteNode(Node *n);
Node* findNode(int key);

