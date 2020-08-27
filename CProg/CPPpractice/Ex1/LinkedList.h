#ifndef LINKEDLIST_H_
#define LINKEDLIST_H_

class Node;

class LinkedList {
	public:
		Node* head;

		LinkedList();
		LinkedList(int arr[], int size);
		LinkedList(const LinkedList &l);
		void insert(int val);
		int pop();
		LinkedList& operator=(const LinkedList &l);
		~LinkedList();
};

#endif

