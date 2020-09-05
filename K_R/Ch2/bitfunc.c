#include <stdio.h>

int main() {

}

unsigned setbits(unsigned x, int p, int n, int y) {
	unsigned mask = ~(~0 << n)
	return (x & ~(mask << p+1-n)) | ((y & mask) << p+1-n); 
}

unsigned invert(unsigned x, int p, int n) {
	unsigned mask = ~(~0 << n);
	return x ^ (mask << p+1-n);
}

unsigned rightrot(unsigned x, int n) {
	while (n > 0) {
		if ((x & 1) == 1)
			x = (x >> 1) | ~(~0U >> 1);
		else
			x = (x >> 1);
		--n;
	}
	return x;
}


