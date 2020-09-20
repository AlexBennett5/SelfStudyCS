#include <stdio.h>

#define MAXLEN 1000

void reverse_rec(int start, int end, char s[]) {
	if (start == end)
		return;
	else {
		char temp = s[start];
		s[start] = s[end];
		s[end] = temp;
		reverse_rec(++start, --end, s);
	}
}

int itoa_rec_aug(int n, char s[], int ind) {
	if (n == 0)
		return ind;
	else {
		s[ind++] = n % 10 + '0';
	       	n /= 10;
		int ret = itoa_rec_aug(n, s, ind);	
		return ret;
	}
}

void itoa_rec(int n, char s[]) {
	int sign = 1;
	if (n < 0) {
		sign = -1;
		n *= -1;
	}
	int ind = itoa_rec_aug(n, s, 0);
	if (sign == -1) {
		s[ind++] = '-';
	}
	s[ind] = '\0';
	reverse_rec(0, ind-1, s);
}

int main() {

	char a[MAXLEN];
	itoa_rec(-324567, a);
	printf("%s\n", a);
}
