#include <stdio.h>

#define MAXLENGTH 100
#define TABWIDTH 7

int getcharline(char s[], int len);
void entab(char s[], char t[], int len, int tabwidth);

int main() {

	int len;
	char line[MAXLENGTH];
	char entabbed[MAXLENGTH];

	while ((len = getcharline(line, MAXLENGTH)) > 0) {
		entab(line, entabbed, MAXLENGTH, TABWIDTH);
		printf("%s", entabbed);
	}

}

int getcharline(char s[], int len) {
	int c, i;

	for (i = 0; i < len - 1 && (c = getchar()) != EOF && c != '\n'; i++)
		s[i] = c;
	if (c == '\n') {
		s[i] = c;
		++i;
	}
	s[i] = '\0';
	return i;
}

void entab(char s[], char t[], int len, int tabwidth) {
	int i, j, whitespace;
	i = j = whitespace = 0;
	while (s[i] != '\0') {
		if (s[i] == ' ') {
			++whitespace;
			if ((whitespace % tabwidth) == 0)
				t[j++] = '\t';
		} else {
			for (int k = 0; k < (whitespace % tabwidth); k++)
				t[j++] = ' ';
			t[j++] = s[i];
			whitespace = 0;
		}
		++i;
	}
	t[len - 1] = '\0';
}

