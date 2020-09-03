#include <stdio.h>

int max(int a, int b) {
	return (a > b) ? a : b;
}

int knapsack(int limit, int weight[], int val[], int n) {

	int memo[n+1][limit+1];

	for (int i = 0; i <= n; i++) {
		for (int w = 0; w <= limit; w++) {
			if (i == 0 || w == 0)
				memo[i][w] = 0;
			else if (weight[i - 1] <= w)
				memo[i][w] = max(val[i - 1] + memo[i - 1][w - weight[i - 1]], memo[i - 1][w]);
			else
				memo[i][w] = memo[i - 1][w];
		}
	}

	return memo[n][limit];
}

int main() {
	int val[] = {10, 20, 30};
	int weight[] = {1, 1, 1};
	int limit = 2;
	printf("%d\n", knapsack(limit, weight, val, 3));
}
