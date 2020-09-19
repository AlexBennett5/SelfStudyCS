#include <stdio.h>
#define MAXLINE 1000

int get_line(char line[], int max);
int strrindex(char s[], char t[]);

char pattern[] = "ould";

int main() {

	char line[MAXLINE];
	int found = 0;

	while (get_line(line, MAXLINE) > 0)
		if (strrindex(line, pattern) >= 0) {
			printf("%s\n", line);
			printf("Rightmost index: %d\n", strrindex(line, pattern));
			found++;
		}
	return found;
}

int get_line(char s[], int max) {
	int c, i;
	i = 0;

	while (--max > 0 && (c=getchar()) != EOF && c != '\n')
		s[i++] = c;
	if (c == '\n')
		s[i++] = c;
	s[i] = '\0';
	return i;
}

int strrindex(char s[], char t[]) {
	int i, j, k;
	int ret = -1;

	for (i = 0; s[i] != '\0'; i++) {
		for (j=i, k=0; t[k] != '\0' && s[j] == t[k]; j++, k++)
			;
		if (k > 0 && t[k] == '\0')
			ret = i;
	}
	return ret;	
}
