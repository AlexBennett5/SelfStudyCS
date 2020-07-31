#include <ctype.h>
#include <string.h>
#include "revwords.h"

void reverse_substring(char str[], int start, int end) { 
	char c;
	int i, j;
	for (i = start, j = end-1; i < j; i++, j--) {
		c = str[i], str[i] = str[j], str[j] = c;
	}
}


int find_next_start(char str[], int len, int i) { 
  
	while (i < len) {
		if (str[i]<65 || (str[i]>90 && str[i]<97) || str[i]>122) {
			i++;
		} else {
			return i;
		}
	}

  	return -1;
}

int find_next_end(char str[], int len, int i) {
  
	while (i < len) {
		if (str[i]<65 || (str[i]>90 && str[i]<97) || str[i]>122) {
			return i;
		} else {
			i++;
		}
	}

  	return len;
}

void reverse_words(char s[]) { 

	int p = 0;
	int e = 0;
	int len = strlen(s);
	
	while (p < len) {

		p = find_next_start(s, len, p);
		
		if (p == -1) {
			break;
		}

		e = find_next_end(s, len, p);
		reverse_substring(s, p, e);
		p = e;

	}

}
