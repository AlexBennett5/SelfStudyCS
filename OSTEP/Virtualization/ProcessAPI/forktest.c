#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
	int x = 100;
	int pid;
	printf("Value of x: %d (PID: %d)\n", x, (int) getpid());
	if ((pid = fork()) == 0) {
		printf("Value of x, pre-increment: %d (PID: %d)\n", x, (int) getpid());
		++x;
		printf("Value of x, post-increment: %d (PID: %d)\n", x, (int) getpid());
	} else {
		printf("Value of x, pre-increment: %d (PID: %d)\n", x, (int) getpid());
		++x;
		printf("Value of x, post-increment: %d (PID: %d)\n", x, (int) getpid());
		wait(NULL);
        	printf("Value of x, end: %d (PID: %d)\n", x, (int) getpid());
	}

}
