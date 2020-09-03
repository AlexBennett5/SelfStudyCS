#include <stdio.h>
#include <stdlib.h>

struct heapnode {
	char data;
	int freq;
	struct heapnode *left, *right;
};
typedef struct heapnode heapnode;

heapnode* createnode(char data, int freq) {
	heapnode* newnode = (heapnode*) malloc(sizeof(heapnode));
	newnode->data = data;
	newnode->freq = freq;
	newnode->left = newnode->right = NULL;
	return newnode;
}

int comparenode(heapnode* a, heapnode* b) {
	return (a->freq > b->freq) ? 1 : 0;
}

struct minheap {
	int size;
	int capacity;
	heapnode** arr;
};
typedef struct minheap minheap;

minheap* createheap(int capacity) {
	minheap* newheap = (minheap*) malloc(sizeof(minheap));
	newheap->capacity = capacity;
	newheap->size = 0;
	newheap->arr = (heapnode**) malloc(newheap->capacity * sizeof(heapnode*));
	return newheap;
}

void insertnode(minheap* heap, heapnode* node) {
	++heap->size;
	int index = heap->size - 1;

	while(index && node->freq < heap->arr[(index - 1) / 2]->freq) {
		heap->arr[index] = heap->arr[(index - 1) / 2];
		index = (index - 1) / 2;
	}
	heap->arr[index] = node;	
}

void swapnodes(heapnode** a, heapnode** b) {
	heapnode* temp = *a;
	*a = *b;
	*b = temp;	
}

void minheapify(minheap* heap, int root) {
	int smallest = root;
	int l = 2*root + 1;
	int r = 2*root + 2;
	if (l < heap->size && comparenode(heap->arr[root], heap->arr[l]))
		smallest = l;
	if (r < heap->size && comparenode(heap->arr[smallest], heap->arr[r]))
		smallest = r;
	if (smallest != root) {
		swapnodes(&heap->arr[root], &heap->arr[smallest]);
		minheapify(heap, smallest);
	}
}

heapnode* extractmin(minheap* heap) {
	heapnode* temp = heap->arr[0];
	heap->arr[0] = heap->arr[heap->size - 1];
	--heap->size;
	minheapify(heap, 0);
	return temp;
}

minheap* huffify(minheap* heap) {

	while(heap->size > 1) {
		
		heapnode* left = extractmin(heap);
		heapnode* right = extractmin(heap);

		heapnode* newnode = createnode('_', left->freq + right->freq);
		newnode->left = left;
		newnode->right = right;
		insertnode(heap, newnode);
	}

	return heap;
}

minheap* createhuffheap(char data[], int freq[], int len) {
	minheap* heap = createheap(len);

	for (int k = 0; k < len; k++) {
		heap->arr[k] = createnode(data[k], freq[k]);	
	}

	for (int k = (len/2) - 1; k >= 0; k--)
		minheapify(heap, k);
	
	heap->size = len;
	heap = huffify(heap);
	return heap;		
}

void printarr(int arr[], int n) {
	for (int k = 0; k < n; ++k)
		printf("%d", arr[k]);
	printf("\n");
}

void printcode(heapnode* node, int arr[], int top) {
	if (node->left) {
		arr[top] = 0;
		printcode(node->left, arr, top + 1);
	}
	if (node->right) {
		arr[top] = 1;
		printcode(node->right, arr, top + 1);
	}
	if (!(node->left) && !(node->right)) {
		printf("%c: ", node->data);
		printarr(arr, top);
	}	
}	

int main() {
	int len = 8;
	char data[] = {'a','b','c','d','e','f','g','h'};
	int freq[] = {2,5,10,30,22,11,7,19};

	minheap* heap = createhuffheap(data, freq, len);
	int arr[100];

	printcode(extractmin(heap), arr, 0);	
}
