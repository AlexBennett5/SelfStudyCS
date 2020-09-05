#include <stdio.h>
#include <limits.h>

int any(char s[], char t[]);

int main() {
	char a[] = "asfdsgfsfadwref";
	char b[] = "wryuiop";
	int index = any(a,b);
	printf("%d\n", index);
}

int any(char s[], char t[]) {
	int res = -1;
	int i, j;
	i = j = 0;
	while (t[j] != '\0') {
		while (s[i] != '\0') {
			if (s[i] == t[j] && (res == -1 || i < res))
				res = i;
			++i;
		}
		i = 0;
		++j;
	}
	return res;
}

