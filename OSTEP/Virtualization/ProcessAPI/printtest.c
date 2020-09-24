#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
	int pid;
	if ((pid = fork()) == 0) {
		close(STDOUT_FILENO);
		printf("Test output\n");
	} else {
		wait(NULL);
	}

}
