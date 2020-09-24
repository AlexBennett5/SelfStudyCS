#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>
#include <sys/stat.h>

int main() {
	
	int filedesc = open("./copytest.txt", O_WRONLY|O_CREAT|O_TRUNC, S_IRWXU);
	int pid = fork();
	write(filedesc, "First sentence\n", strlen("First sentence\n"));

	if (pid == 0) {
		write(filedesc, "Child process sentence\n", strlen("Child process sentence\n"));
		printf("File descriptor in child process: %d\n", filedesc);
	} else {
		write(filedesc, "Parent process sentence\n", strlen("Parent process sentence\n"));
		printf("File descriptor in parent process: %d\n", filedesc);
	
		wait(NULL);

		FILE *fileptr;
		fileptr = fopen("./copytest.txt", "r");
		int ch;
		printf("Output file:\n");
		while((ch = fgetc(fileptr)) != EOF)
			printf("%c", ch);
		fclose(fileptr);
	}
	close(filedesc);
	return 0;
}
