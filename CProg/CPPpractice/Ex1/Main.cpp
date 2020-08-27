#include <cstdio>
#include "Node.h"
#include "LinkedList.h"

int main() {

	int test[] = {1,2,3,4,5};
	LinkedList l1(test+1,4), l2(test,5);
	LinkedList l3 = l2, l4;
	l4 = l1;
	printf("%d %d %d\n", l1.pop(), l3.pop(), l4.pop());
	return 0;
}

