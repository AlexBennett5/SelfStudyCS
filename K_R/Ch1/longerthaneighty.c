#include <stdio.h>

#define MAXLENGTH 100

int getcharline(char s[], int maxlen);
void cleararray(char s[], int maxlen);

int main() {

	int len;
	char line[MAXLENGTH];

	while ((len = getcharline(line, MAXLENGTH)) > 0)
		if (len > 80) {
			printf("%s\n", line);
			cleararray(line, MAXLENGTH);
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

void cleararray(char s[], int maxlen) {

	for (int i = 0; i < maxlen; i++) {
		s[i] = ' ';
	}

}

