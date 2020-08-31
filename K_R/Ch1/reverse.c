#include <stdio.h>

#define MAXLENGTH 30

void reverse(char s[], int len);
int getcharline(char s[], int len);

int main() {

	int len;
	char line[MAXLENGTH];

	while((len = getcharline(line, MAXLENGTH)) > 0) {
		reverse(line, len);
		printf("%s", line);
	}

}

int getcharline(char s[], int len) {

	int c, i;

	for (i=0; i<len-1 && (c=getchar()) != EOF && c != '\n'; i++)
		s[i] = c;
	if (c == '\n') {
		s[i] = c;
		++i;
	}	
	s[i] = '\0';
	return i;
}

void reverse(char s[], int len) {

	int j, k;
	char temp;

	for (j = 0, k = len - 2; j != k && k > 0 ; j++, k--) {
		temp = s[j];
		s[j] = s[k];
		s[k] = temp;
	}

}
