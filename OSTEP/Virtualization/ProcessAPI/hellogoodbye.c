#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
	int pid = fork();
	
	if (pid  == 0) {
		printf("Hello\n");	
	} else {
		sleep(2);
		printf("Goodbye\n");
	}

}
