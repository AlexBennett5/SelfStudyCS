#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

Node* createNode(int data) {
	Node* n = malloc(sizeof(Node));
	n->data = data;
	n->next = NULL;
	return n;
}

Queue* createQueue() {
	Queue* q = malloc(sizeof(Queue));
	q->head = q->tail = NULL;
	return q;
}

int isEmpty(Queue* q) {
	return (q->tail == NULL);
}

void enqueue(Queue* q, int val) {

	Node* newnode = createNode(val);
	if (!isEmpty(q)) {
		q->tail->next = newnode;
		q->tail = newnode;	
	} else {
		q->head = q->tail = newnode;
	}
}

int dequeue(Queue* q) {
	if (!isEmpty(q)) {
		Node* n = q->head;
		int res = n->data;
		q->head = q->head->next;
		if (q->head == NULL)
			q->tail = NULL;
		free(n);
		return res;
	} else {
		return -1;
	}	
}

int first(Queue* q) {
	if (!isEmpty(q)) {
		return q->head->data;
	} else {
		return -1;
	}
}

