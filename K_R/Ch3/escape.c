#include <stdio.h>
#include <string.h>

void escape(char s[], char t[]);

int main() {

	char a[] = "H	e	p	p	\n	y";
	char b[strlen(a)];
	escape(a, b);
	printf("%s\n", b);
}

void escape(char s[], char t[]) {
	int i, j, c;
	i = j = 0;
	while (s[i] != '\0') {
		switch(c = s[i++]) {
			case '\t':
				t[j++] = '\\';
				t[j++] = 't';
				break;
			case '\n':
				t[j++] = '\\';
				t[j++] = 'n';
				break;
			default:
				t[j++] = c;
			       	break;	
		}
	}
}
