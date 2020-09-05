#include <stdio.h>

void squeeze(char s[], char t[]);

int main() {
	char a[] = "asdasd 	sdfdhsf rytrterwsdsfvdbasdfgaa";
	char b[] = " 	ad";
	squeeze(a, b);
	printf("%s\n", a);
}

void squeeze(char s[], char t[]) {
	int i, j, k;
	
	for (k = 0; t[k] != '\0'; k++) {
		for(i = j = 0; s[i] != '\0'; i++)
			if (s[i] != t[k])
				s[j++] = s[i];
		s[j] = '\0';
	}
}


