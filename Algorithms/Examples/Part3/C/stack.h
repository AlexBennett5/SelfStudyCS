#ifndef STACK_H
#define STACK_H 1

struct Stack {
	int* arr;
	unsigned maxsize;
	int index;
};

typedef struct Stack Stack;

Stack* createStack(unsigned maxsize);

int isempty(Stack* stk);
void push(int x, Stack* stk);
int pop(Stack* stk);
int top(Stack* stk);

#endif
