#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main() {
	int pid;
	
	if ((pid = fork()) == 0) {
		char *myargs[3];
		myargs[0] = strdup("ls");
		myargs[1] = NULL;
		myargs[2] = NULL;
		execvp(myargs[0], myargs);	
	} else {
		int rc_wait = wait(NULL);
	}

	return 0;

}
