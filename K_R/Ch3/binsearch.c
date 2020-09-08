#include <stdio.h>
#include <time.h>

int binsearch(int x, int v[], int n);
int binsearch_alt(int x, int v[], int n);

int main() {

	int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int len = 10;
	int val = 4;

	printf("Original function\n");
	clock_t time;
	time = clock();
	printf("Result: %d\n", binsearch(val, arr, len));
	time = clock() - time;
	double time_taken = ((double)time)/CLOCKS_PER_SEC;
	printf("Time taken: %f\n", time_taken);

	printf("Alternative function\n");
        time = clock();
        printf("Result: %d\n", binsearch_alt(val, arr, len));
        time = clock() - time;
        time_taken = ((double)time)/CLOCKS_PER_SEC;
        printf("Time taken: %f\n", time_taken);

}

int binsearch(int x, int v[], int n) {
	int low, high, mid;

        low = 0;
        high = n - 1;
        while (low <= high) {
                mid = (low + high)/2;
                if (x < v[mid]) 
                        high = mid - 1;
		else if (x > v[mid])
			low = mid + 1;
		else
                        return mid;
        }
       	return -1; 
}

int binsearch_alt(int x, int v[], int n) {
	int low, high, mid;

	low = mid = 0;
	high = n - 1;
	while (low <= high && x != v[mid]) {
		mid = (low + high)/2;
		if (x < v[mid])
			high = mid - 1;
		else
			low = mid + 1;
	}
	if (x == v[mid])
		return mid;
	else
		return -1;
}
