#ifndef RBTREE_H
#define RBTREE_H 1

typedef enum {
	RED,
	BLACK
} node_color;

typedef struct Node {
	int key;
	node_color color;
	struct Node *left, *right, *parent;
} Node;

#define NIL &sentinel
Node sentinel = {0, BLACK, NIL, NIL, 0};
Node *root = NIL;

void rotateLeft(Node *n);
void rotateRight(Node *n);
void insertFixup(Node *n);
Node* insertNode(int key);
void deleteFixup(Node *n);
void deleteNode(Node *n);
Node* findNode(int key);

#endif
