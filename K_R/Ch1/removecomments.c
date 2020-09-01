#include <stdio.h>

#define MAXLENGTH 100
#define TRUE 1
#define FALSE 0

int getcharline(char s[], int len);
void removecom(char s[], char t[], int len);

int str;
int comment;

int main() {

	int len;
	char line[MAXLENGTH];
	char commentless[MAXLENGTH];

	extern int str;
	extern int comment;

	str = FALSE;
	comment = FALSE;
	while ((len = getcharline(line, MAXLENGTH)) > 0) {
		removecom(line, commentless, MAXLENGTH);
		printf("%s", commentless);
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

void removecom(char s[], char t[], int len) {

	int i, j;
	extern int str;
	extern int comment;
	i = j = 0;
	while (i < len && j < len) {
		if (!str && !comment && s[i] == '"')
			str = TRUE;
		if (!str) {
			if (s[i] == '/' && s[i+1] == '*') {
				i += 2;
				comment = TRUE;
			}

			if (s[i] == '*' && s[i+1] == '/') {
				i += 2;
				comment = FALSE;
			}
			
			if (comment) 
				++i;
			if (!comment)
			       t[j++] = s[i++];	
		} else {
			t[j++] = s[i++];
		}
	}

}

