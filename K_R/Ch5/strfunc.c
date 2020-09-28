#include <stdio.h>

void str_cat(char *s, char *t) {
	while (*s != '\0')
		s++;
	while (*t != '\0') {
		*s = *t;
		t++;
		s++;
	}
	*s = '\0';
}

int str_cmp(char *s, char*t) {
	for ( ; *s == *t; s++, t++)
		if (*s == '\0')
			return 0;
	return *s - *t;
}

int str_end(char *s, char *t) {
	while (*s != '\0') {
		if (*s == *t && str_cmp(s, t) == 0)
			return 1;
		else
			s++;
	}
	return 0;
}

int main() {

	char s[] = "This is great";
	char t[] = "reat";
	char v[] = "Hey, ";

	str_cat(v, s);
	printf("%s\n", v);
	printf("%s\n", s);
	printf("Expect 1: %d\n", str_end(v, t));

}
