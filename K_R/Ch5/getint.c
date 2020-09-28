#include <stdio.h>
#include <ctype.h>

#define MAX 10

int getch(void);
void ungetch(int);
int getint(int *pn);

int main(void) {
	int i, num[MAX];
	int val;

	for (i = 0; i < MAX && (val = getint(&num[i])) != EOF; i++) {
		printf("num[%d] = %d, \tvalue return: %d (%s)\n", i, num[i], val, val != 0 ? "number" : "not a number");
	}
}

int getint(int *pn) {
	int c, sign;

	*pn = 0;

	while (isspace(c = getch()))
		;
	if (!isdigit(c) && c != EOF && c != '+' && c != '-') {
		ungetch(c);
		return 0;
	}
	sign = (c == '-') ? -1 : 1;
	if (c == '+' || c == '-') {
		c = getch();
		if (!isdigit(c)) {
			ungetch(sign == 1 ? '+' : '-');
			return 0;
		}
	}
	while (isdigit(c)) {
		*pn = 10 * *pn + (c - '0');
		c = getch();
	}
	*pn *= sign;
	if (c != EOF)
		ungetch(c);
	return c;
}

int bufp = 0;
int buf[MAX];

int getch(void) {
	return bufp > 0 ? buf[--bufp] : getchar();
}

void ungetch(int c) {
	if (bufp < MAX)
		buf[bufp++] = c;
}
