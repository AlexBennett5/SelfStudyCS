#include <stdio.h>

#define MAXLENGTH 30

int getcharline(char s[], int maxlen);

int main() {

	int i, len;
	char line[MAXLENGTH];

	while ((len = getcharline(line, MAXLENGTH)) > 0) {
		i = len - 1;
		while (line[i] == ' ' || line[i] == '\t' || line[i] == '\n')
			--i;
		line[++i] = '\n';
		line[++i] = '\0';
		printf("%s", line);
	}

}

int getcharline(char s[], int maxlen) {

	int c, i;
	for (i = 0; i < maxlen - 1 && (c=getchar()) != EOF && c != '\n'; ++i)
		s[i] = c;
	if (c == '\n') {
		s[i] = c;
		++i;
	}
	s[i] = '\0';
	return i;
}


