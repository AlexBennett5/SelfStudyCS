#include <stdio.h>

#define MAXLENGTH 1000
#define FOLD 100

int getcharline(char s[], int len);
void fold(char s[], int len);

int main() {

	int len, i, lastws, lastfold;
	char line[MAXLENGTH];
	
	while ((len = getcharline(line, MAXLENGTH)) > 0) {
		
		if (len >= FOLD) 
			fold(line, len);
		printf("%s", line);
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

void fold(char s[], int len) {
	int i, lastfold, lastws;
	i = lastfold = 0;
	while (i < len) {
		if (s[i] != ' ' && s[i+1] == ' ')
			lastws = i+1;
		if (lastfold == FOLD) {
			s[lastws] = '\n';
			lastfold = 0;
		}
		++lastfold;
		++i;
	}
}

