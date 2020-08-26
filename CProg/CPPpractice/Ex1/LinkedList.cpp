#include <iostream>
#include "Node.h"

using namespace std;

class LinkedList {
	public:
		Node* head;

		LinkedList(int[] arr, int size);
		LinkedList(const LinkedList &l);
		int pop();
		LinkedList& operator=(const LinkedList &l);
		~LinkedList();
}

LinkedList::LinkedList(int[] arr, int size) {

	Node* current = new Node();
	head = current;

	while(size > 0) {
		current.data = arr[0];
		current.next = new Node();
		current = current.next;
		arr++;
		size--;
	}

}

LinkedList::LinkedList(const LinkedList &l) {


}

int LinkedList::pop() {

	int result = head.data;
	head = head.next;
	delete(head);
	return result;
}

LinkedList& operator=(const LinkedList &l) {

}

LinkedList::~LinkedList() {

	Node* prev = head;
	Node* current = head->next;

	while (prev) {
		
		delete(prev);
		prev = current;
		current = current->next;
	}
	
}

