#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>

#define MAXOP 100
#define NUMBER 0
#define FUNC 1
#define MAXVAL 100
#define BUFSIZE 100

int sp = 0;
double val[MAXVAL];
int bufp = 0;
char buf[BUFSIZE];

int getch(void) {
	return (bufp > 0) ? buf[--bufp] : getchar();
}

void ungetch(int c) {
	if (bufp >= BUFSIZE)
		printf("ungetch: too many characters\n");
	else
		buf[bufp++] = c;
}

int getop(char s[]) {
	int i,c,d;

	while ((s[0] = c = getch()) == ' ' || c == '\t')
		;
	s[1] = '\0';
	if (isalpha(c)) {
		i = 0;
		while (isalpha(s[i++] = c))
			c = getch();
		s[i-1] = '\0';
		if (c != EOF)
			ungetch(c);
		return FUNC;
	}
	if (!isdigit(c) && c != '.' && c != '-')
		return c;
	if (c == '-') {
		d = getch();
		if (d == ' ')
			return c;
		else
			ungetch(d);
	}
	i = 0;
	if (isdigit(c) || c == '-')
		while (isdigit(s[++i] = c = getch()))
			;
	if (c == '.')
		while (isdigit(s[++i] = c = getch()))
			;
	s[i] = '\0';
	if (c != EOF)
		ungetch(c);
	return NUMBER;
}

void push(double f) {
	if (sp < MAXVAL)
		val[sp++] = f;
	else
		printf("error: stack full, can't push %g\n", f);
}

double pop(void) {
	if (sp > 0)
		return val[--sp];
	else {
		printf("error: stack empty\n");
		return 0.0;
	}
}

void printTop() {
	if (sp > 0)
		printf("%.8g\n", val[sp-1]);
	else
		print("Stack empty\n");
}

void duplicateTop() {
	double top = pop();
	push(top);
	push(top);
}

void swapTop() {
	double op1 = pop();
	double op2 = pop();

	push(op1);
	push(op2);
}

void clearStack() {
	sp = 0;
}

void processfunction(char s[]) {
	double op2;

	if (strcmp(s, "sin") == 0)
		push(sin(pop()));
	else if (strcmp(s, "cos") == 0)
		push(cos(pop()));
	else if (strcmp(s, "exp") == 0)
		push(exp(pop()));
	else if (strcmp(s, "pow") == 0) {
		op2 = pop();
		push(pow(pop(), op2));
	}
	else
		printf("%s is not a valid function.\n", s);
}

int main() {
	int type;
	double op2;
	char s[MAXOP];

	while ((type = getop(s)) != EOF) {
		switch(type) {
		case NUMBER:
			push(atof(s));
			break;
		case FUNC
			processfunction(s);
		case '+':
			push(pop() + pop());
			break;
		case '*':
			push(pop() * pop());
			break;
		case '-':
			op2 = pop();
			push(pop() - op2);
			break;
		case '/':
			op2 = pop();
			if (op2 != 0.0)
				push(pop() / op2);
			else
				printf("error: zero divisor\n");
			break;
		case '%':
			op2 = pop();
			if (op2 != 0.0)
				push(fmod(pop(), op2));
			else
				printf("error: division by zero\n");
			break;
		case '\n':
			printf("\t%.8g\n", pop());
			break;
		default:
			printf("error: unknown command %s\n", s);
			break;
		}
	}
	return 0;
}


