#include <stdio.h>
#include "stack.h"

int main() {
	Stack* s = createStack(100);
	for (int i = 0; i < 10; i++)
		push(i, s);
	for (int i = 0; i < 11; i++)
		printf("%d, %d\n", pop(s), top(s));
}
