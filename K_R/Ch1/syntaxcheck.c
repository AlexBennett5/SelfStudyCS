#include <stdio.h>

#define MAXLENGTH 100
#define TRUE 1
#define FALSE 0

int getcharline(char s[], int len);
void eval(char s[], int len);

int str;
int comment;
int paren;
int bracket;
int brace;

int main() {

	int len;
	char line[MAXLENGTH];

	extern int str;
	extern int comment;
	extern int paren;
	extern int bracket;
	extern int brace;

	str = comment = FALSE;
	paren = bracket = brace = 0;
	while ((len = getcharline(line, MAXLENGTH)) > 0) {
		eval(line, MAXLENGTH);
	}

	if (str)
		printf("ERROR: Unbalanced quotation mark\n");
	else if (comment)
		printf("ERROR: Unbalanced comment\n");
	else if (paren != 0)
		printf("ERROR: Unbalanced parentheses\n");
	else if (bracket != 0)
		printf("ERROR: Unbalanced bracket\n");
	else if (brace != 0)
		printf("ERROR: Unbalanced brace\n");
	else
		printf("Syntax valid\n");

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

void eval(char s[], int len) {

	extern int paren;
	extern int bracket;
	extern int brace;
	extern int str;
	extern int comment;

	for (int i = 0; i < len; i++) {
		if (!comment && !str) {
			if (s[i] == '(') 
				++paren;
			if (s[i] == ')')
				--paren;
			if (s[i] == '[')
				++bracket;
			if (s[i] == ']')
				--bracket;
			if (s[i] == '{')
				++brace;
			if (s[i] == '}')
				--brace;
			if (s[i] == '"')
				str = TRUE;
			if (s[i] == '/' && s[i+1] == '*')
				comment = TRUE;
				++i;
		} else if (!str && s[i] == '*' && s[i+1] == '/') {
			comment = FALSE;
			++i;
		} else if (!comment && str && s[i] == '"') {
			str = FALSE;
		}
	}

}


