#include <stdio.h>
#include <limits.h>

#define MATRICES 7

int counter;

int matchain(int p[], int i, int j);
int matchainmemoized(int p[], int n);
void compare(int p[], int n);

int main() {

	int p[MATRICES] = {30, 35, 15, 5, 10, 20, 25};
	compare(p, MATRICES);

}

int matchain(int p[], int i, int j) {

	extern int counter;

	++counter;

	if (i == j)
		return 0;
	
	int min = INT_MAX;
	int prod = 0;

	for (int k = i; k < j; k++) {
		prod = matchain(p, i, k) + matchain(p, k+1, j) + (p[i-1] * p[k] * p[j]);
		if (prod < min)
			min = prod;
	}

	return min;

}

int matchainmemoized(int p[], int n) {
        
	int memo[n][n];
	int prod, j;

	for (int i = 0; i < n; i++)
		memo[i][i] = 0;

       	for (int L = 2; L < n; L++) {
		for (int i = 1; i < n - L + 1; i++) {
			j = L - 1 + i;
			memo[i][j] = INT_MAX;

			for (int k = i; k < j; k++) {
				counter += 2;
				prod = memo[i][k] + memo[k+1][j] + (p[i-1] * p[k] * p[j]);
				if (prod < memo[i][j])
					memo[i][j] = prod;		
			}
		}
	}

	return memo[1][n-1];

}

void compare(int p[], int n) {

	extern int counter;
	counter = 0;

	printf("MATRIX CHAIN MULTIPLICATION FOR (%d, %d)\n", 1, n);
	printf("NON-MEMOIZED VERSION\n");
	int res = matchain(p, 1, n-1);
	printf("The result is %d, with %d computations\n", res, counter);
	
	printf("MEMOIZED VERSION\n");
	counter = 0;
	res = matchainmemoized(p, n);
	printf("The result is %d, with %d computations\n", res, counter);
}
