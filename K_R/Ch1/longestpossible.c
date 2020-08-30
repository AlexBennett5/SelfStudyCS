#include <stdio.h>

#define MAXLENGTH 30

int getcharline(char s[], int maxlen);
void copy(char to[], char from[]);

int main() {

	int len, max;
	char line[MAXLENGTH], longest[MAXLENGTH];

	max = 0;
	while ((len = getcharline(line, MAXLENGTH)) > 0)
		if (len > max) {
			max = len;
			copy(longest, line);
		}
	if (max > MAXLENGTH) {
		printf("Max line exceeded maxlength\n");
		printf("Max line length: %d\n", max);
		printf("First %d characters of max line: %s\n", MAXLENGTH, longest);
	} else if (max > 0) {
		printf("%s\n", longest);
	}
}

int getcharline(char s[], int maxlen) {

	int c, i;

	for (i=0; i<maxlen-1 && (c=getchar()) != EOF && c != '\n'; i++)
		s[i] = c;
	
	if (i == (maxlen - 1)) {
		while ((c=getchar()) != '\n')
			++i;
	}
	
	if (c == '\n') {
		s[i] = c;
		++i;
	}	
	
	s[i] = '\0';
	return i;
}

void copy(char to[], char from[]) {

	int i = 0;
	while ((to[i] = from[i]) != '\0')
		++i;

}
