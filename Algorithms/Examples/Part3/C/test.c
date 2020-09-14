#include <stdio.h>
#include "queue.h"

int main() {
	Queue* q = createQueue();
	for (int i = 0; i < 10; i++)
		enqueue(q, i);;
	for (int i = 0; i < 11; i++)
		printf("%d, %d\n", dequeue(q), first(q));
}
