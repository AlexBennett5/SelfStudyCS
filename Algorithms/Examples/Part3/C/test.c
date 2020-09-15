#include <stdio.h>
#include "hash.h"

int main() {
	Hashtable *ht = create_hashtable();
	set(ht, "john", "joseph");
	set(ht, "samantha", "gertvald");
	set(ht, "pieter", "van der baan");
	set(ht, "ama", "odvenberk");

	printf("%s\n", get(ht, "john"));
	printf("%s\n", get(ht, "pieter"));
	printf("%s\n", get(ht, "rebecka"));
}
