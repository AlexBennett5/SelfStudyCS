#include <iostream>
#include "Node.h"
#include "LinkedList.h"

using namespace std;

LinkedList::LinkedList() {
	head = nullptr;
}

LinkedList::LinkedList(int arr[], int size) {

	head = nullptr;

	for (int i = 0; i < size; i++) {
		insert(arr[i]);
	}

}

LinkedList::LinkedList(const LinkedList &l) {

	head = nullptr;
	Node* copyhead = l.head;

	while(copyhead != nullptr) {
		insert(copyhead->data);
		copyhead = copyhead->next;
	}

}

void LinkedList::insert(int val) {

	Node* newnode = new Node;
	newnode->data = val;
	newnode->next = nullptr;

	Node* current = head;

	if (current != nullptr) {

		while (current->next != nullptr) {
			current = current->next;
		}

		current->next = newnode;
	} else {

		head = newnode;
	}

}

int LinkedList::pop() {

	if (head != nullptr) {
		int result = head->data;
		Node* temp = head;
		head = head->next;
		delete temp;
		return result;
	} else {
		return -1;
	}
}

LinkedList& LinkedList::operator=(const LinkedList &l) {

	if (&l != this) {
		Node* temp = head;
		while (temp != nullptr && temp->next != nullptr) {
			head = head->next;
			delete temp;
			temp = head;
		}

		temp = l.head;
		while (temp != nullptr) {
			insert(temp->data);
			temp = temp->next;
		}
	}

	return *this;
}

LinkedList::~LinkedList() {

	Node* current = head;

	while (current != nullptr) {
		head = head->next;
		delete current;
		current = head;
	}

}

