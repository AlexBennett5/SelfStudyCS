#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

Stack* createStack(unsigned maxsize) {
	Stack* stk = malloc(sizeof(Stack));
	stk->index = -1;
	stk->maxsize = maxsize;
	stk->arr = (int*) malloc(stk->maxsize * sizeof(int));
	return stk;
}

int isempty(Stack* stk) {
	return (stk->index == -1);
}

void push(int x, Stack* stk) {
	if (stk->index == stk->maxsize - 1) {
		return;
	} else {
		stk->arr[++stk->index] = x;
	}
}

int pop(Stack* stk) {
	if (isempty(stk))
		return -1;
	else
		return stk->arr[stk->index--];
}

int top(Stack* stk) {
	if (isempty(stk))
		return -1;
	else
		return stk->arr[stk->index];
}

