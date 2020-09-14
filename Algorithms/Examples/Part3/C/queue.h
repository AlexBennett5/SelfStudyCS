#ifndef QUEUE_H
#define QUEUE_H 1

struct Node {
	int data;
	struct Node *next;
};

typedef struct Node Node;

Node* newNode(int data);

struct Queue {
	Node *head, *tail;
};

typedef struct Queue Queue;

Queue* createQueue();

int isEmpty(Queue* q);
void enqueue(Queue* q, int val);
int dequeue(Queue* q);
int first(Queue* q);

#endif
