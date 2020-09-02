#include <stdio.h>
#include <string.h>

int counter;

int lcs(char* A, char* B, int i, int j);
int lcsmemoized(char* A, char* B, int n, int m);
int max(int a, int b);
void compare(char* A, char* B, int n, int m);

int main() {

	char A[] = "DFTKUIYTR";
	char B[] = "AKUIYSDE";
	int n = strlen(A);
	int m = strlen(B);
	compare(A, B, n, m);
}

int lcs(char* A, char* B, int i, int j) {

	extern int counter;
	++counter;

	if (i == 0 || j == 0)
		return 0;
	else if (A[i] == B[j])
		return 1 + lcs(A, B, i-1, j-1);
	else
		return max(lcs(A,B,i-1,j), lcs(A,B,i,j-1));
}

int lcsmemoized(char* A, char* B, int n, int m) {

	extern int counter;
	int LCS[n+1][m+1];

	for (int i = 0; i < n+1; i++) {
		for (int j = 0; j < m+1; j++) {
			++counter;
			if (i == 0 || j == 0)
				LCS[i][j] = 0;
			else if (A[i] == B[j])
				LCS[i][j] = 1 + LCS[i-1][j-1];
			else
				LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1]);
		}
	}

	return LCS[n][m];

}

int max(int a, int b) {
	if (a > b)
		return a;
	else
		return b;
}

void compare(char* A, char* B, int n, int m) {

	extern int counter;
	counter = 0;
	printf("LONGEST COMMON SUBSEQUENCE\n");
	printf("RECURSIVE VERSION\n");
	int res = lcs(A, B, n, m);
	printf("The result was %d made with %d calculations\n", res, counter);
	counter = 0;
	printf("MEMOIZED VERSION\n");
	res = lcsmemoized(A, B, n, m);
	printf("The result was %d made with %d calculations\n", res, counter);

}
